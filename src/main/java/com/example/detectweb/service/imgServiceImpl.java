package com.example.detectweb.service;

import com.example.detectweb.mapper.CategoryMapper;
import com.example.detectweb.mapper.imgListMapper;
import com.example.detectweb.mapper.photoMapper;
import com.example.detectweb.pojo.Category;
import com.example.detectweb.pojo.PhotoList;
import com.example.detectweb.pojo.PhotoPath;
import com.example.detectweb.pojo.imgList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class imgServiceImpl implements PageInfoService {
    @Autowired
    private imgListMapper imgListMapper;
    @Autowired
    private CategoryMapper CategoryMapper;
    @Autowired
    private photoMapper photoMapper;
    @Autowired
    private photoService photoService;
    @Autowired
    private CategoryService CategoryService;

    @Override
    public PageInfo<imgList> queryAllByPage(Integer pageNum, Integer pageSize, String username) {
        PageHelper.startPage(pageNum, pageSize);
        List<imgList> imgList = imgListMapper.queryAllByPage(username);
        PageInfo<imgList> pageInfo = new PageInfo<>(imgList);
        return pageInfo;
    }

    @Override
    public PageInfo<Category> getAllCategories(Integer pageNum, Integer pageSize, String username) {
        PageHelper.startPage(pageNum, pageSize);
        List<Category> Category = CategoryMapper.getAllCategories(username);
        return new PageInfo<>(Category);
    }
    @Override
    public PageInfo<PhotoPath> getAllPhotos(Integer pageNum, Integer pageSize, String username){
        PageHelper.startPage(pageNum, pageSize);
        List<PhotoPath> allPhotos = photoMapper.getAllPhotos(username);
        PageInfo<PhotoPath> Allphoto_list = new PageInfo<>(allPhotos);
        return Allphoto_list;
    }
    @Override
    public PageInfo<PhotoList> GetPhotoLists(Integer pageNum, Integer pageSize, String username){
        PageHelper.startPage(pageNum, pageSize);
        List<PhotoList> photoLists = imgListMapper.queryAll(username);
        PageInfo<PhotoList> photoList = new PageInfo<>(photoLists);
        return photoList;
    }
}