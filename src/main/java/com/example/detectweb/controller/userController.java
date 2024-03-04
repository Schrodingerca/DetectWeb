package com.example.detectweb.controller;

import com.example.detectweb.mapper.userMapper;
import com.example.detectweb.pojo.User;
import jdk.jfr.Percentage;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class userController {

    @Autowired
    userMapper UserMapper;

    @RequestMapping("/upload/user")
    public String upload(@RequestParam("uname") String username,
                       @RequestParam("psw") String password,
                       Model model, HttpSession session,
                       HttpServletRequest request){
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser!=username){
            return "top";
        }
        try {
            UserMapper.uploadUser((String)loginUser, username,password);
                session.setAttribute("loginUser", username);
                model.addAttribute("newname",username);
        }catch (EmptyResultDataAccessException ignored){

        }
        return "";
    }
    @PostMapping("/getUsername")
    @ResponseBody
    public String getUsername(HttpSession session){
        return (String) session.getAttribute("loginUser");
    }
}
