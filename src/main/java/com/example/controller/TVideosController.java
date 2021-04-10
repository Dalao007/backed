package com.example.controller;

import com.example.entity.Page;
import com.example.entity.TConsumers;
import com.example.entity.TVideos;
import com.example.service.TVideosService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 视频(TVideos)表控制层
 *
 * @author makejava
 * @since 2020-10-13 14:34:33
 */
@RestController
@RequestMapping("tVideos")
public class TVideosController {
    /**
     * 服务对象
     */
    @Resource
    private TVideosService tVideosService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TVideos selectOne(Integer id) {
        return this.tVideosService.queryById(id);
    }

    @PostMapping("getVideoByPage")
    public Object getVideoByPage(@RequestBody Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<TVideos> list = tVideosService.queryAllByLimit();
        PageInfo<TVideos> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @SneakyThrows
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile[] file) {
        //多个文件
        if (file.length == 0) {
            return "false";
        }
        //开Ftp通道
        Ftp ftp = new Ftp("49.234.77.189", 21, "13593568046", "123456");
        ftp.ftpLogin();
        TVideos tVideos = new TVideos();
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
                tVideos.setVPic("http://49.234.77.189:8080/video/" + file1.getName());
            } else {
                int nameLength = multipartFile.getOriginalFilename().lastIndexOf('.');
                String vTitle = multipartFile.getOriginalFilename().substring(0, nameLength);
                String vUrl = "http://49.234.77.189:8080/video/" + file1.getName();
                tVideos.setVTitle(vTitle);
                tVideos.setVUrl(vUrl);
                tVideos.setConNo(1);
                tVideos.setVCoins(0);
            }
        }
        tVideosService.insert(tVideos);
        ftp.ftpLogOut();
        return "success";
    }

    @PostMapping("fengVideo")
    public boolean fengVideo(@Param("vNo") Integer vNo) {
        return tVideosService.fengVideo(vNo);

    }

}