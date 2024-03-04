package com.example.detectweb.controller;


import com.example.detectweb.pojo.Subcategory;
import com.example.detectweb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/findKinds")
    @ResponseBody
    public List<Subcategory> findKinds(@RequestParam String bigKinds, HttpSession session) {
        String username = (String) session.getAttribute("loginUser");
        return categoryService.findBigKinds(bigKinds, username);
    }
    @RequestMapping("/deleteCategory")
    public String deleteCategory(HttpServletRequest request,
                                 Model model, HttpSession session) {
        String category_name = request.getParameter("category_name");
        String username = (String) session.getAttribute("loginUser");
        if(categoryService.selectCategory(category_name, username)){
            int category_id = categoryService.selectCategory_id(category_name, username);
            if(categoryService.selectsubCategory(category_id, username)){
                categoryService.deletesubCategory(category_id, username);
            }
            categoryService.deleteCategory(category_name, username);
            System.out.println("删除成功");
        }
        return "redirect:/photoManage";
    }
    @RequestMapping("/updateCategory")
    public String updateCategory(@RequestParam("CategoryName") String NewName,
                                 @RequestParam("originalName") String OldName,
                                 Model model, HttpSession session) {
        String username = (String) session.getAttribute("loginUser");
        if(categoryService.updateCategory(NewName, OldName, username)){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
        return "redirect:/photoManage";
    }
    @RequestMapping("/updateSubCategory")
    public String updateSubCategory(@RequestParam("updateSubCategory-label") String categoryName,
                                    @RequestParam("subCategory") String OldSubName,
                                    @RequestParam("NewsubCategory") String NewSubName,
                                    Model model,HttpSession session){
        String username = (String) session.getAttribute("loginUser");
        int category_id = categoryService.selectCategory_id(categoryName,username);
        if(Objects.equals(OldSubName, "请选择")){
            if(!categoryService.selectNewsubCategory(category_id, NewSubName, username)){
                categoryService.addSubCategory(category_id, NewSubName, username);
                System.out.println("添加成功");
            }else{
                System.out.println("此类别已存在");
            }
        }else{
            if(!categoryService.selectNewsubCategory(category_id, NewSubName, username)){
                categoryService.updateSubCategory(category_id, OldSubName, NewSubName, username);
                System.out.println("修改成功");
            }else{
                System.out.println("此类别已存在");
            }
        }
        return "redirect:/photoManage";
    }
    @PostMapping("/CategorySearch")
    @ResponseBody
    public List<String> CategorySearch(@RequestParam("category_name") String category_name,
                                 Model model, HttpSession session) {
        String username = (String) session.getAttribute("loginUser");
        List<String> subCategory = null;
        if (categoryService.selectCategory(category_name, username)) {
            int category_id = categoryService.selectCategory_id(category_name, username);
            subCategory = categoryService.getAllSubcategory(category_id, username);
        }
        return subCategory;
    }
    @PostMapping("/getCategoryID")
    @ResponseBody
    public int getCategoryID(@RequestParam("category_name") String category_name,
                                 Model model, HttpSession session) {
        String username = (String) session.getAttribute("loginUser");
        int category_id = 0;
        if (categoryService.selectCategory(category_name, username)) {
            category_id = categoryService.selectCategory_id(category_name, username);
        }
        return category_id;
    }
}
