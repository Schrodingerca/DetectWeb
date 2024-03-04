package com.example.detectweb.mapper;

import com.example.detectweb.pojo.imgList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface imgMapper {
    void uploadImg(String username, String imgPath, String classes, String imgName, String detectTime);
    List<imgList> chekAllImage(String username);
    void deleteImg(int id);
}