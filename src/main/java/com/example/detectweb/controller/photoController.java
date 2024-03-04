package com.example.detectweb.controller;

import com.example.detectweb.pojo.Category;
import com.example.detectweb.pojo.PhotoList;
import com.example.detectweb.pojo.PhotoPath;
import com.example.detectweb.service.PageInfoService;
import com.example.detectweb.service.CategoryService;
import com.example.detectweb.service.photoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class photoController {
    @Autowired
    private PageInfoService PageInfoService;
    @Autowired
    private CategoryService CategoryService;
    @Autowired
    private photoService photoService;
    @RequestMapping("/findPhoto")
    @ResponseBody
    public PageInfo<PhotoList> findPhoto(@RequestParam("category") int category,
                                         @RequestParam("subcategory") int subcategory,
                                         @RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                         @RequestParam(value = "pageSize",required = false,defaultValue = "6")Integer pageSize,
                                         Model model, HttpSession session){
        String username = (String) session.getAttribute("loginUser");
        List<PhotoPath> photoPath = photoService.getPhotos(username, category, subcategory);
        List<PhotoList> photoLists = new ArrayList<>();
        for (PhotoPath path : photoPath) {
            String category_name = CategoryService.getCategoryName(username, path.getCategory_id());
            String subcategory_name = CategoryService.getsubCategoryName(username, path.getSubcategory_id());
            PhotoList photoList = new PhotoList(path.getId(), category_name, subcategory_name, path.getImgPath());
            photoLists.add(photoList);
        }
        PageInfo<PhotoList> PhotoLists = new PageInfo<>(photoLists);
        return PhotoLists;
    }
    @RequestMapping("/selectPhoto")
    public String getAllCategories(Model model, HttpSession session,
                                   @RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                   @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize) {
        String username = (String) session.getAttribute("loginUser");
        List<Category> a = CategoryService.getAllCategories(username);
        List<Category> allCategory = CategoryService.getAllCategory(username);
        PageInfo<PhotoList> photoListPageInfo = PageInfoService.GetPhotoLists(pageNum, pageSize, username);
        model.addAttribute("photoLists", photoListPageInfo);
        model.addAttribute("allCategory",allCategory);
        model.addAttribute("category", a);
        return "selectPhoto";
    }
    @PostMapping("/addPhoto")
    public String addPhoto(@RequestPart("file") MultipartFile file,
                           @RequestParam("bigCategory") String bigCategory,
                           @RequestParam("shortCategory") String shortCategory,
                           HttpSession session){
        String username = (String) session.getAttribute("loginUser");
        String Filename = file.getOriginalFilename();
        photoService.addPhoto(file, bigCategory, shortCategory, username, Filename);
        System.out.println(bigCategory + "\n" + shortCategory);
        return "/selectPhoto";
    }
    @PostMapping("/photodelete")
    public String deletePhoto(@RequestParam("imgPath") String imgPath, HttpSession session){
        String username = (String) session.getAttribute("loginUser");
        Path filePath = Paths.get(imgPath);
        try {
            deleteFile(filePath);
            System.out.println("删除成功");
            photoService.deletePhoto(imgPath, username);
            photoService.DelPhoto(imgPath, username);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        photoService.deletePhoto(imgPath, username);
        return "/selectPhoto";
    }
    public static void deleteFile(Path filePath) throws IOException {
        if (Files.exists(filePath) && Files.isRegularFile(filePath)) {
            Files.delete(filePath);
        } else {
            System.out.println("File does not exist or is not a regular file.");
        }
    }
}