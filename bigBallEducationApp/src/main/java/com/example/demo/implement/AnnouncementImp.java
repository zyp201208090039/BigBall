package com.example.demo.implement;

import com.example.demo.mapper.AnnouncementMapper;
import com.example.demo.model.Announcement;
import com.example.demo.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AnnouncementImp implements AnnouncementService {
    @Autowired
    private AnnouncementMapper announcementMapper;
    @Override
    public List<Announcement> getAllAnnouncements() {
        return announcementMapper.getAllAnnouncement();
    }

    @Override
    public List<Announcement> getAllNews() {
        return announcementMapper.getAllNews();
    }

    @Override
    public int addAnnouncement(Announcement announcement) {
        return announcementMapper.addAnnouncement(announcement);
    }

    @Override
    public Announcement getAnnoucementById(int id) {
        return announcementMapper.getAnnouncementById(id);
    }

    @Override
    public int updateAnnouncement(Announcement announcement) {
        return announcementMapper.updateAnnouncement(announcement);
    }

    @Override
    public int deleteAnnouncement(int id) {
        return 0;
    }
}
