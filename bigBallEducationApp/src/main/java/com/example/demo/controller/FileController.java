package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
public class FileController {

    @Autowired
    private UserMapper usermapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);
    @PostMapping("/upload/{phoneNumber}")
    public String upload(@RequestParam("file") MultipartFile file, @PathVariable("phoneNumber") String PhoneNumber, HttpServletRequest request) throws FileNotFoundException {
        if (file==null) {
            return "上传失败，请选择文件";
        }
        if (PhoneNumber==null) {
            return "上传失败，phonenumber is null";
        }
        String folderPath=ResourceUtils.getURL("classpath:static").getPath();
      //  String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        String realPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath()+"/education/img/";
        String fileName = file.getOriginalFilename();
       // String filePath = "C://SchoolFile/";

        String path = System.getProperty("user.dir");
        path=path+"\\src\\main\\resources\\static\\Education\\img\\";
        path=realPath;
        path="F:\\imgs\\";
        int index= fileName.lastIndexOf(".");
        String extension=fileName.substring(index);
        fileName=PhoneNumber+extension;
        String filePath=path+fileName;

        File folder=new File (path);

        if ( !folder.exists ())
        {
            folder.mkdir ();
        }

        File oldFile = new File(filePath);
        if (oldFile.exists())
        {
            oldFile.delete();
        }

        File dest = new File(filePath);
        try {
            file.transferTo(dest);
            usermapper.updateUserPhoto(PhoneNumber,"img/"+fileName);
           LOGGER.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "上传失败！";
    }





}
