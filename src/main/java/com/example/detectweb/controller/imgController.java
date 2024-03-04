package com.example.detectweb.controller;

import com.example.detectweb.pojo.imgList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.client.RestTemplate;

import com.example.detectweb.service.allService;
import com.example.detectweb.mapper.imgMapper;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;





@Controller
public class imgController {
    @Autowired
    imgMapper imgMapper;

    @Value("${yolov5.api.url}")  // 从配置文件中获取YOLOv5 API的URL
    private String yolov5ApiUrl;
    @Value("${baidu.api.url}")
    private String baiduApiUrl;

    String UPLOAD_PATH = "File/image/upload";

    // 上传图片
    @RequestMapping(value = "/DetectImage", method = RequestMethod.POST)
    public String uploadImage(@RequestParam("image") MultipartFile image,
                              Model model, HttpSession session) {
        String username = (String) session.getAttribute("loginUser");
        try {
            Path directory = Paths.get(UPLOAD_PATH);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }
            byte[] imageBytes = image.getBytes();
            String img0 = Base64Utils.encodeToString(imageBytes);
            // 将图像数据发送到YOLOv5 API
            RestTemplate restTemplate = new RestTemplate();
            String apiUrl = yolov5ApiUrl + "/detect";
            String response = restTemplate.postForObject(apiUrl, imageBytes, String.class);
            // 获取检测结果
            String lableurl = yolov5ApiUrl + "/label";
            String classes = restTemplate.getForObject(lableurl,String.class);

            // 将图片保存到服务器
            List<String> classesList = allService.extractStrings(classes);
            if ( !Objects.equals(classes, "检测失败") ){
                // 保存历史图片，user（用户名）、response（图片base64）、classes（检测结果）
                imgList imgList = allService.uploadImage(response, classesList);
                if (imgList!=null) {
                    if (imgMapper.chekAllImage(username)!=null){
                        imgMapper.uploadImg(username, imgList.getImgFile(), imgList.getClasses(), imgList.getImgName(), allService.getTime());
                    }
                }
                // 将base64图片上传到前端
                String base64Image = "data:image/png;base64," + response.replace("\"","");
                String base64img = "data:image/png;base64," + img0.replace("\"","");
                model.addAttribute("base64Image", base64Image);
                model.addAttribute("img0", base64img);
                model.addAttribute("label", classesList);
                return "detect";
            }else{
                model.addAttribute("error", "没有识别到物体");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "detect";
    }
    @RequestMapping(value = "/baiduApi", method = RequestMethod.POST)
    public String baiduAPI(@RequestParam("image") MultipartFile image,
                           Model model){
        try{
            byte[] imageBytes = image.getBytes();
            String img0 = Base64Utils.encodeToString(imageBytes);
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.postForObject(baiduApiUrl, img0, String.class);
            String base64Image = "data:image/png;base64," + response.replace("\"", "");
            model.addAttribute("base64Image", base64Image);
            return "detect";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @RequestMapping("/manage")
    public String showImages(Model model,
                             HttpSession session) {
        String username = (String) session.getAttribute("loginUser");
//        List<String> imagePaths = imgMapper.chekAllImage(username);  // 从服务器获取图片路径列表
        List<imgList> imgLists = imgMapper.chekAllImage(username);
        model.addAttribute("imgList", imgLists);
        return "manage";
    }
}
