package com.example.detectweb.service;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.text.SimpleDateFormat;

import com.example.detectweb.pojo.imgList;
import org.springframework.stereotype.Service;

@Service
public class allService {
    static List<String> Transportation = Arrays.asList("bicycle", "car", "motorcycle", "airplane", "bus",
            "train", "truck", "boat", "traffic light", "stop sign", "parking meter");
    static List<String> facilityOrItem = Arrays.asList("bench", "fire hydrant", "backpack", "umbrella", "handbag", "tie",
            "suitcase", "frisbee", "skis", "snowboard", "sports ball", "kite", "baseball bat", "baseball glove",
            "skateboard", "surfboard", "tennis racket", "bottle", "wine glass", "cup", "fork", "knife", "spoon", "bowl");
    static List<String> Animal = Arrays.asList("bird", "cat", "dog", "horse", "sheep", "cow", "elephant", "bear",
            "zebra", "giraffe");
    static List<String> FoodAndBeverage = Arrays.asList("banana", "apple", "sandwich", "orange", "broccoli", "carrot",
            "hot dog", "pizza", "donut", "cake");
    static List<String> FurnitureAndHousehold = Arrays.asList("chair", "couch", "potted plant", "bed", "dining table",
            "toilet", "tv", "laptop", "mouse", "remote", "keyboard", "cell phone", "microwave", "oven", "toaster",
            "sink", "refrigerator", "book", "clock", "vase", "scissors", "teddy bear", "hair drier", "toothbrush");

    public static imgList uploadImage(String response, List<String> classesList) {
        // 保存图像的目录
        String directoryPath = "File/image/detect/";
        // 如果目录不存在，则创建
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        try {
            String base64Image = "data:image/png;base64," + response.replace("\"", "");
            // 移除数据URI前缀
            String base64Data = base64Image.substring(base64Image.indexOf(",") + 1);
            // 移除可能存在的空格或不可见字符
            base64Data = base64Data.trim();
            // 尝试解码base64图像字符串
            byte[] imageBytes = Base64.getDecoder().decode(base64Data);

            // 最终存储路径
            String filePath = "";
            String classes = null;
            for (String name : classesList){
                if (Classify(name)!=null) {
                    classes = Classify(name);
                    break;
                }
            }if (classes!=null){
                filePath = directoryPath + classes + "/" + String.join("_", classesList) + ".jpg";
            }
            System.out.println(filePath);

            try {
                createDirectory(filePath);
                saveImage(imageBytes, filePath);
                imgList imgList = new imgList();
                imgList.setImgFile(filePath);
                imgList.setClasses(classes);
                imgList.setImgName(getImgName(classesList));
                return imgList;
            } catch (IOException e) {
                System.err.println("保存图像时出错：" + e.getMessage());
                e.printStackTrace();
                return null;
            }
        } catch (IllegalArgumentException e) {
            System.err.println("解码base64字符串时出错：" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public static List<String> extractStrings(String input) {
        List<String> stringList = new ArrayList<>();
        // 使用正则表达式匹配字符串元素
        Pattern pattern = Pattern.compile("\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            stringList.add(matcher.group(1));
        }

        return stringList;
    }

    // 判断类别
    public static String Classify(String classes){
        if (Transportation.contains(classes)){
            return "Transportation";
        }else if (facilityOrItem.contains(classes)){
            return "facilityOrItem";
        }else if (Animal.contains(classes)){
            return "Animal";
        }else if (FoodAndBeverage.contains(classes)){
            return "FoodAndBeverage";
        }else if (FurnitureAndHousehold.contains(classes)){
            return "FurnitureAndHousehold";
        }else{
            return null;
        }
    }
    static void saveImage(byte[] imageBytes, String destinationFile) throws IOException {
        try (FileOutputStream out = new FileOutputStream(destinationFile)) {
            out.write(imageBytes);
        }
    }
    static void createDirectory(String filePath) throws IOException {
        Path path = Paths.get(filePath).getParent();
        if (path != null && !Files.exists(path)) {
            Files.createDirectories(path);
        }
    }
    // 获取当前时间
    public static String getTime() {
        Date currentTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        return dateFormat.format(currentTime);
    }
    public static String getImgName(List<String> imgNamelist){
        System.out.println(imgNamelist);  // 检查返回值是否为null
        String[] imgNames = imgNamelist.toArray(new String[0]);
        return String.join(",", imgNames);  // 执行字符串拼接
    }
}