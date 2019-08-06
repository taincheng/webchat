package com.webChat.controller;

import com.webChat.entities.Chat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class chatController {

    @RequestMapping("/publicChat")
    public String publicChat(Chat chat, HttpSession session){
        session.setAttribute("publicchat",chat);
        return "home";
    }

    @RequestMapping("/privateChat")
    public String privateChat(Chat chat, HttpSession session){
        session.setAttribute("privatechat",chat);
        String whoChat = chat.getWhochat();
        String chatWho = chat.getChatwho();
        String appNameSelf = whoChat + "To" + chatWho;
        session.setAttribute("talkname",appNameSelf);
        return "home";
    }
}
