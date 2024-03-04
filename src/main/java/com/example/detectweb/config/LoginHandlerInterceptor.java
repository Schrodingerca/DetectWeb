//package com.example.detectweb.config;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//public class LoginHandlerInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Object loginUser = request.getSession().getAttribute("loginUser");
//        if (loginUser==null){
//            request.setAttribute("error","请先登录！");
//            request.getRequestDispatcher("/").forward(request,response);
//            return false;
//        }else{
//            return true;
//        }
//    }
//}
