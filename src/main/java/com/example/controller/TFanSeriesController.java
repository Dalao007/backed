package com.example.controller;

import com.example.entity.Page;
import com.example.entity.TConsumers;
import com.example.entity.TFanSeries;
import com.example.entity.TVideos;
import com.example.service.TFanSeriesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 剧集(TFanSeries)表控制层
 *
 * @author makejava
 * @since 2020-10-13 12:01:05
 */
@RestController
public class TFanSeriesController {
    /**
     * 服务对象
     */
    @Resource
    private TFanSeriesService tFanSeriesService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("selectOnea")
    public TFanSeries selectOnea(Integer id) {
        return this.tFanSeriesService.queryById(id);
    }

    @PostMapping("getFansByPage")
    public Object getFansByPage(@RequestBody Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<TFanSeries> list = tFanSeriesService.queryAllByLimit();
        PageInfo<TFanSeries> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @SneakyThrows
    @PostMapping("/upFanSeries")
    public String upload(@RequestParam("file") MultipartFile[] file,
                         @RequestParam("seriesNum") Integer seriesNum,
                         @RequestParam("fanNo")Integer fanNo) {
        //多个文件
        if (file.length == 0) {
            return "false";
        }
        //开Ftp通道
        Ftp ftp = new Ftp("49.234.77.189", 21, "15535590500", "123456");
        ftp.ftpLogin();
        TFanSeries tFanSeries = new TFanSeries();
        for (MultipartFile multipartFile : file) {
            //获取原始文件名称
            String originalFilename = multipartFile.getOriginalFilename();
            //获取文件后缀名
            String extension = "." + FilenameUtils.getExtension(originalFilename);
            //获取新文件名称 命名：时间戳+UUID+后缀
            String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
                    + UUID.randomUUID().toString().substring(0, 4)
                    + extension;
            File file1 = new File(newFileName);
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file1);
            boolean b = ftp.uploadFile(file1, "/home/data/");
            if (file1.exists()) {
                boolean a = file1.delete();
            }
            //对象上传数据库
            if (extension.equals(".jpg") || extension.equals(".png")) {
                tFanSeries.setSeriesPic("http://49.234.77.189:8080/fan/" + file1.getName());
            } else {
                int nameLength = multipartFile.getOriginalFilename().lastIndexOf('.');
                String vTitle = multipartFile.getOriginalFilename().substring(0, nameLength);
                String vUrl = "http://49.234.77.189:8080/fan/" + file1.getName();
                tFanSeries.setFanNo(fanNo);
                tFanSeries.setSeriesNum(seriesNum);
                tFanSeries.setSeriesTitle(vTitle);
                tFanSeries.setSeriesUrl(vUrl);
            }
        }
        tFanSeriesService.insert(tFanSeries);
        ftp.ftpLogOut();
        return "success";
    }
}