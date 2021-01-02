package com.example.demo.mapper;



import com.example.demo.model.Announcement;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface  AnnouncementMapper {

@Select("select * from Announcement  where type='announce' ORDER BY id DESC LIMIT 0,5")
List<Announcement> getAllAnnouncement();

@Select("SELECT * FROM Announcement  WHERE TYPE='new' ORDER BY id DESC LIMIT 0,5 ")
List<Announcement> getAllNews();

@Insert({"insert into Announcement(publish,title,content,imgurl,Phone,type) values(#{publish},#{title},#{content},#{imgurl},#{Phone},#{type})"})
int addAnnouncement(Announcement announcement);


@Select("select * from Announcement where id=#{id}")
Announcement getAnnouncementById(int id);

@Delete("delete from Announcement where id=#{id}")
    Integer deleteAnnouncementById(String id);

@Update("update Announcement set publish=#{publish},title=#{title},content=#{content},imgurl=#{imgurl} where id=#{id}")
    Integer updateAnnouncement(Announcement ann);
}
