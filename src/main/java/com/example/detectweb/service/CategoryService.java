package com.example.detectweb.service;

import com.example.detectweb.mapper.CategoryMapper;
import com.example.detectweb.pojo.Category;
import com.example.detectweb.pojo.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> getAllCategories(String username) {
        return categoryMapper.getAllCategories(username);
    }
    public List<Subcategory> findBigKinds(String username, String bigKinds) {
        return categoryMapper.findBigKinds(username, bigKinds);
    }
    public Boolean selectCategory(String category_name, String username) {
        List<String> Categroy_names = categoryMapper.selectCategory(username);
        for (String name : Categroy_names) {
            if (name.equals(category_name)) {
                return true;
            }
        }
        return false;
    }
    public List<String> getAllSubcategory(int category_id, String username){
        return categoryMapper.getAllSubcategory(category_id, username);
    }
    public Boolean selectCategory_name(String img_name, String username) {
        List<String> img_names = categoryMapper.selectImgName(img_name, username);
        for (String name : img_names) {
            if (name.equals(img_name)) {
                return true;
            }
        }
        return false;
    }
    public void addCategory(String category_name, String img_name, String username) {
        categoryMapper.addCategory(category_name, username);
        int id = categoryMapper.selectCategory_id(category_name, username);
        categoryMapper.addImgName(id, img_name, username);
    }
    public int selectCategory_id(String category_name, String username) {
        return categoryMapper.selectCategory_id(category_name, username);
    }
    public int selectSubCategory_id(String subCategory_name, int category_id, String username) {
        return categoryMapper.selectSubCategory_id(subCategory_name, category_id, username);
    }
    public Boolean selectsubCategory(int category_id, String username){
        return categoryMapper.selectsubCategory(category_id, username) > 0;
    }
    public void deletesubCategory(int category_id, String username) {
        categoryMapper.deletePhotopath(category_id, username);
        categoryMapper.deletesubCategory(category_id, username);
    }
    public void deleteCategory(String category_name, String username){
        categoryMapper.deleteCategory(category_name, username);
    }
    public Boolean updateCategory(String NewName, String OldName, String username){
        if(!CategoryService.this.selectCategory(NewName, username)){
            categoryMapper.updateCategory(NewName, OldName, username);
            return true;
        }else{
            return false;
        }
    }
    public Boolean selectNewsubCategory(int category_id,String NewSubName, String username){
        return categoryMapper.selectNewsubCategory(category_id,NewSubName,username) > 0;
    }
    public void updateSubCategory(int category_id, String OldSubName, String NewSubName, String username){
        categoryMapper.updateSubCategory(category_id, OldSubName, NewSubName, username);
    }
    public void addSubCategory(int category_id, String NewSubName, String username){
        categoryMapper.addSubCategory(category_id, NewSubName, username);
    }
    public List<Category> getAllCategory(String username){
        return categoryMapper.getAllCategories(username);
    }
    public String getCategoryName(String username, int category_id){
        return categoryMapper.getCategoryName(username, category_id);
    }
    public String getsubCategoryName(String username, int Subcategory_id){
        return categoryMapper.getsubCategoryName(username, Subcategory_id);
    }
}
