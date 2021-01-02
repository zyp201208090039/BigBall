package com.example.demo.controller;



import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Announcement;
import com.example.demo.model.StateEnum;
import com.example.demo.model.Status;
import com.example.demo.service.AnnouncementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class AnnouncementController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnnouncementController.class);

    @Autowired
    private AnnouncementService Service;

    @RequestMapping(value = "/addAnnouncement/", method = RequestMethod.POST)
    public Status addAnnouncement(@RequestParam("file") MultipartFile file , HttpServletRequest request)
    {
        Status status=new Status();
        try {

           // @RequestParam("file") MultipartFile file
             String  s= request.getParameter("announce");
            JSONObject json = JSONObject.parseObject(s);

            String folderPath= ResourceUtils.getURL("classpath:static").getPath();
            //  String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
            String realPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath()+"/education/img/";
            String fileName = file.getOriginalFilename();
            // String filePath = "C://SchoolFile/";
//, @RequestBody Announcement announcement
            Announcement announcement=new Announcement();
            announcement.setTitle(json.getString("title"));
            announcement.setContent(json.getString("content"));
            announcement.setType(json.getString("type"));
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
                announcement.setImgurl("./imgs/"+fileName);
                LOGGER.info("上传成功");
            } catch (IOException e) {
                LOGGER.error(e.toString(), e);
            }




            java.sql.Date dt=new  java.sql.Date( new  Date().getTime());

            SimpleDateFormat sdf1 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
            //Date d1= new Date();
            String sdate = sdf1.format(dt);

            announcement.setPublish(sdate);
            if (announcement.getType()==null)
            {
                announcement.setType("new");
            }
           else if (!(announcement.getType().equalsIgnoreCase("new")||announcement.getType().equalsIgnoreCase("announce")))
           {
               announcement.setType("new");
           }
            Service.addAnnouncement(announcement);
            status.setCode(StateEnum.secuccessful.getValue());
            status.setMsg("seccessful");
        }
        catch (Exception ex)
        {
            status.setMsg("failed");
            status.setReason(ex.toString());
        }
        return status;
    }

    @RequestMapping("/deleteAnnouncement/{id}")
    private  Status deleteAnnouncement(@PathVariable ("id") int id)
    {
        Status status=new Status();
        try {
            Service.deleteAnnouncement(id);
            status.setCode(StateEnum.secuccessful.getValue());
            status.setMsg("seccessful");
        }
        catch (Exception ex)
        {
            status.setCode(StateEnum.failed.getValue());
            status.setMsg("failed");
        }
       return  status;
    }

    @RequestMapping("/getAllAnnounces")
    private  Status getAllAnnounces()
    {
        Status status=new Status();
        try {

            status.setT(Service.getAllAnnouncements());
            status.setCode(StateEnum.secuccessful.getValue());
            status.setMsg("seccessful");
        }
        catch (Exception ex)
        {
            status.setCode(StateEnum.failed.getValue());
            status.setMsg("failed");
        }
        return  status;
    }

    @RequestMapping("/getAllNews")
    private  Status getAllNews()
    {
        Status status=new Status();
        try {

            status.setCode(StateEnum.secuccessful.getValue());
            status.setT( Service.getAllNews());
            status.setMsg("seccessful");
        }
        catch (Exception ex)
        {
            status.setCode(StateEnum.failed.getValue());
            status.setMsg("failed");
        }
        return  status;
    }
    @RequestMapping("/getAnnouncementById/{id}")
    public Status getAnnouncementById(@PathVariable("id") int id)
    {

        Status status=new Status();
        try {

            status.setCode(StateEnum.secuccessful.getValue());
            status.setT( Service.getAnnoucementById(id));
            status.setMsg("seccessful");
        }
        catch (Exception ex)
        {
            status.setCode(StateEnum.failed.getValue());
            status.setMsg("failed");
        }
        return  status;
    }
}
