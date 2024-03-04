package com.example.detectweb.mapper;

import com.example.detectweb.pojo.PhotoPath;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface photoMapper {
    List<PhotoPath> getCategoryPhotos(String username, String category_id);
    List<PhotoPath> getPhotos(String username, int category, int subcategory);
    List<PhotoPath> getAllPhotos(String username);
    void addPhoto(int Category_id, int subCategory_id, String filePath, String username);

    void deletePhotopath(String imgPath, String username);
    void DelPhoto(String imgPath, String username);
}