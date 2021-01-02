package com.example.demo.service;



import com.example.demo.model.Announcement;

import java.util.List;


public interface AnnouncementService {

    List<Announcement> getAllAnnouncements();
    List<Announcement> getAllNews();
    int addAnnouncement(Announcement announcement);
    Announcement getAnnoucementById(int id);
    int updateAnnouncement(Announcement announcement);
    int deleteAnnouncement(int id);

}
