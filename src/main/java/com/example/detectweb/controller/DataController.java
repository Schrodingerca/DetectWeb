package com.example.detectweb.controller;


import com.example.detectweb.mapper.imgMapper;
import com.github.pagehelper.PageInfo;
import com.example.detectweb.pojo.imgList;
import com.example.detectweb.service.PageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
public class DataController {
    @Autowired
    private PageInfoService PageInfoService;
    @Autowired
    private imgMapper imgMapper;
    @RequestMapping("/historyList")
    public String queryAllByPage(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "5")Integer pageSize,
                                 Model model, HttpSession session){
        String username = (String) session.getAttribute("loginUser");
        PageInfo<imgList> imgListPageInfo = PageInfoService.queryAllByPage(pageNum, pageSize, username);
        model.addAttribute("imgListPageInfo",imgListPageInfo);
        return "historyList";
    }
    @RequestMapping("/deleteImg")
    public String deleteImg(HttpServletRequest request){
        String id = request.getParameter("id");
        imgMapper.deleteImg(Integer.parseInt(id));
        return "redirect:/historyList";
    }
}