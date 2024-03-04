package com.example.detectweb.service;

import com.example.detectweb.pojo.Category;
import com.example.detectweb.pojo.PhotoList;
import com.example.detectweb.pojo.PhotoPath;
import com.example.detectweb.pojo.imgList;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PageInfoService {

    PageInfo<imgList> queryAllByPage(Integer pageNum, Integer pageSize, String userName);
    PageInfo<Category> getAllCategories(Integer pageNum, Integer pageSize, String userName);
    PageInfo<PhotoPath> getAllPhotos(Integer pageNum, Integer pageSize, String userName);
    PageInfo<PhotoList> GetPhotoLists(Integer pageNum, Integer pageSize, String username);
}