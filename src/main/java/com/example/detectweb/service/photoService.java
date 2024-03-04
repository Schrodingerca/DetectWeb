package com.example.detectweb.service;

import com.example.detectweb.mapper.imgListMapper;
import com.example.detectweb.mapper.photoMapper;
import com.example.detectweb.pojo.PhotoList;
import com.example.detectweb.pojo.PhotoPath;
import com.example.detectweb.service.allService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class photoService {
    @Autowired
    private photoMapper photoMapper;
    @Autowired
    private CategoryService CategoryService;
    @Autowired
    private photoService photoService;
    @Autowired
    private imgListMapper imgListMapper;
    public List<PhotoPath> getCategoryPhotos(String username, String category_id) {
        return photoMapper.getCategoryPhotos(username, category_id);
    }
    public void addPhoto(MultipartFile file, String bigCategory, String shortCategory, String username, String Filename){
        int Category_id = CategoryService.selectCategory_id(bigCategory, username);
        int subCategory_id = CategoryService.selectSubCategory_id(shortCategory, Category_id, username);
        try {
            byte[] imageBytes = file.getBytes();
            String filePath = "File/image/photoGallery/" + bigCategory + "/" + shortCategory +"/"+ Filename;
            try{
                allService.createDirectory(filePath);
                allService.saveImage(imageBytes, filePath);
                photoMapper.addPhoto(Category_id, subCategory_id, filePath, username);
                imgListMapper.saveImage(username, bigCategory, shortCategory, filePath);
            } catch (IOException e) {
                System.err.println("保存图像时出错：" + e.getMessage());
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<PhotoPath> getPhotos(String username, int category, int subcategory) {
        return photoMapper.getPhotos(username,category,subcategory);
    }
    public List<PhotoPath> getAllPhotos(String username) {
        return photoMapper.getAllPhotos(username);
    }
    public void deletePhoto(String imgPath, String username) {
        photoMapper.deletePhotopath(imgPath, username);
    }
    public void DelPhoto(String imgPath, String username) {
        photoMapper.DelPhoto(imgPath, username);
    }
}
