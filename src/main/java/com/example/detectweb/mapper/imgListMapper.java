package com.example.detectweb.mapper;

import com.example.detectweb.pojo.PhotoList;
import com.example.detectweb.pojo.PhotoPath;
import com.example.detectweb.pojo.imgList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface imgListMapper {
    List<imgList> queryAllByPage(String username);
    void saveImage(String username, String bigCategory, String shortCategory, String filePath);
    List<PhotoList> queryAll(String username);
}