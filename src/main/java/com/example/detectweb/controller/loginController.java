package com.example.detectweb.controller;

import com.example.detectweb.mapper.userMapper;
import com.example.detectweb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class loginController {
    @Autowired
   userMapper UserMapper;
    // 实现用户登录

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                      @RequestParam("password") String password,
                      Model model, HttpSession session){
        try {
            String pwd = UserMapper.chekuser(username);
            System.out.println(pwd);
            if(password.equals(pwd)){
                model.addAttribute("username",username);
                // 实现登录拦截器
                session.setAttribute("loginUser",username);
                return "redirect:/top";
            }
        }catch (EmptyResultDataAccessException e){
            model.addAttribute("error","用户名或密码错误！");
            return "redirect:/top";
        }
        model.addAttribute("error","请输入用户名！");
        return "redirect:/top";
    }


    @RequestMapping("/user/register")
    public String register(@RequestParam("username") String username,
                        @RequestParam("password2") String password,
                        Model model, HttpSession session){
        try{
            List<String> users = UserMapper.checkAllUsers();
            System.out.println(users);
            for (String user : users) {
                if (user.equals(username)) {
                    model.addAttribute("msg","用户名已存在");
                    return "/login";
                }
            }
            UserMapper.registerUser(username, password);
            model.addAttribute("msg", "注册成功，请登录");
        }catch (EmptyResultDataAccessException e){

        }
        return "redirect:/login";
    }
}