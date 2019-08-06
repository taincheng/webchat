package com.webChat.controller;

import com.webChat.DAO.UserDao;
import com.webChat.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class userController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/userlogin")
    public String login(User user, ModelMap modelMap,HttpSession session){
        String username = user.getUsername();
        String password = user.getPassword();
        User uu = userDao.get(username,password);

        if(uu != null){
            session.setAttribute("username",username);
            return "home";
        }

        modelMap.addAttribute("msg","用户名密码错误!");
        return "login";
    }

    @RequestMapping("/userlogout/{username}")
    public String logout(@PathVariable(value = "username",required = false) String s,HttpSession session){
        session.removeAttribute(s);
        session.invalidate();
        return "redirect:/index.jsp";
    }

    @RequestMapping("/userregister")
    public String userRegister(User user){
        userDao.add(user);
        return "redirect:/views/login.jsp";
    }
}
