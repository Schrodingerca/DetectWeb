package com.example.detectweb.controller;

import com.example.detectweb.pojo.Category;
import com.example.detectweb.pojo.PhotoPath;
import com.example.detectweb.service.CategoryService;
import com.example.detectweb.service.PageInfoService;
import com.example.detectweb.service.photoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class photoGalleryController {
    @Autowired
    private photoService photoService;
    @Autowired
    private CategoryService CategoryService;
    @Autowired
    private PageInfoService PageInfoService;
    @PostMapping("/getPhoto")
    @ResponseBody
    public List<PhotoPath> getPhotos(@RequestParam String category_id,
                                     HttpSession session) {
        String username = (String) session.getAttribute("loginUser");
        return photoService.getCategoryPhotos(category_id, username);
    }
    @PostMapping("/photoManage/addCategory")
    @ResponseBody
    public ResponseEntity<Map<String, String>> addCategory(@RequestParam("img-Category") String category_name,
                                                           @RequestParam("img-name") String img_name,
                                                           HttpSession session) {
        String username = (String) session.getAttribute("loginUser");
        Map<String, String> response = new HashMap<>();
        if (CategoryService.selectCategory(category_name, username)) {
            response.put("message", "该大类名称已存在");
            return ResponseEntity.badRequest().body(response);
        } else {
            if (CategoryService.selectCategory_name(img_name, username)) {
                response.put("message", "该小类名称已存在");
                return ResponseEntity.badRequest().body(response);
            } else {
                CategoryService.addCategory(category_name, img_name, username);
                response.put("message", "添加成功");
                return ResponseEntity.ok(response);
            }
        }
    }


    @RequestMapping("/photoManage")
    public String queryAllByPage(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "2")Integer pageSize,
                                 Model model, HttpSession session){
        String username = (String) session.getAttribute("loginUser");
        PageInfo<Category> CategoryList = PageInfoService.getAllCategories(pageNum,pageSize,username);
        List<Category> allCategory = CategoryService.getAllCategory(username);
        HashMap<Long, Object> categoryMaps  = new HashMap<>();
        for(Category category : CategoryList.getList()){
            Long id = category.getId();
            categoryMaps.put((long) Math.toIntExact(id), CategoryService.getAllSubcategory(Math.toIntExact(id), username));
        }
        model.addAttribute("categoryMaps",categoryMaps);
        model.addAttribute("CategoryList",CategoryList);
        model.addAttribute("allCategory",allCategory);
        return "photoManage";
    }
}
