package com.example.detectweb.mapper;


import com.example.detectweb.pojo.Category;
import com.example.detectweb.pojo.PhotoList;
import com.example.detectweb.pojo.PhotoPath;
import com.example.detectweb.pojo.Subcategory;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {
    List<Category> getAllCategories(String username);
    List<String> getAllSubcategory(int category_id, String username);
    List<Subcategory> findBigKinds(String bigKinds, String username);
    List <String> selectCategory(String username);
    List<String> selectImgName(String img_name, String username);
    void addCategory(String category_name, String username);
    int selectCategory_id(String category_name, String username);
    void addImgName(int category_id, String img_name, String username);
    int selectsubCategory(int category_id, String username);
    void deletesubCategory(int category_id, String username);
    void deletePhotopath(int category_id, String username);
    void deleteCategory(String category_name, String username);
    void updateCategory(String NewName, String OldName, String username);
    int selectNewsubCategory(int category_id, String newName, String username);
    void updateSubCategory(int category_id, String OldSubName, String NewSubName, String username);
    void addSubCategory(int category_id, String NewSubName, String username);
    int selectSubCategory_id(String subCategory_name, int category_id, String username);
    String getCategoryName(String username, int category_id);
    String getsubCategoryName(String username, int Subcategory_id);
}
