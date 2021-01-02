package com.example.demo;

import com.example.demo.controller.AnnouncementController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

public class FileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnnouncementController.class);
    public  static  String saveFile(MultipartFile file) throws FileNotFoundException {
        String folderPath= ResourceUtils.getURL("classpath:static").getPath();
        //  String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        String realPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath()+"/education/img/";
        String fileName = file.getOriginalFilename();

        String path = System.getProperty("user.dir");
        path=path+"\\src\\main\\resources\\static\\Education\\img\\";
        path=realPath;
        path="F:\\imgs\\";
        int index= fileName.lastIndexOf(".");
        String extension=fileName.substring(index);
        UUID uuid = UUID.randomUUID();
        fileName=uuid+extension;
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
            LOGGER.info("上传成功");
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }

        return  "./imgs/"+fileName;

    }


}
