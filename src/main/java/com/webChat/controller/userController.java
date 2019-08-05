package com.webChat.controller;

import com.webChat.DAO.UserDao;
import com.webChat.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class userController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/userlogin")
    public String login(User user, ModelMap modelMap){
        String username = user.getUsername();
        String password = user.getPassword();
        User uu = userDao.get(username,password);
//        System.out.println("login :" + username + " : " + password);

        if(uu != null){
            return "home";
        }

        modelMap.addAttribute("msg","用户名密码错误!");
        return "login";
    }
}
