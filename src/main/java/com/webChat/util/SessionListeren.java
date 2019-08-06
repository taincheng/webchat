package com.webChat.util;

import com.sun.javafx.css.SimpleSelector;
import com.webChat.entities.Chat;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import java.util.*;

@Component
public class SessionListeren implements HttpSessionListener, HttpSessionAttributeListener {

    private ServletContext application = null;

    Set onlineUser = new HashSet();

    List publicChat = null;


    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        application = event.getSession().getServletContext();
        String attrName = event.getName();
        //说明是用户登录
        if (attrName.equals("username")) {
            onlineUser.add((String) event.getValue());
            application.setAttribute("onlineUser", onlineUser);
        }

        //说明是公聊
        if (attrName.equals("publicchat")) {
            Chat chat = (Chat) event.getValue();
            String whochat = chat.getWhochat();
            String saywhat = chat.getSaywhat();

            if (application.getAttribute("publicChatAll") == null) {
                publicChat = new LinkedList();
                publicChat.add(whochat + " : " + saywhat);
                application.setAttribute("publicChatAll", publicChat);
            } else {
                publicChat = (List) application.getAttribute("publicChatAll");
                publicChat.add(whochat + " : " + saywhat);
                application.setAttribute("publicChatAll", publicChat);
            }
        }

        //私聊
        if (attrName.equals("privatechat")) {
            Chat chat = (Chat) event.getValue();
            String whoChat = chat.getWhochat();
            String chatWho = chat.getChatwho();
            String sayWhat = chat.getSaywhat();

            String appNameSelf = whoChat + "To" + chatWho;
            String appNameOther = chatWho + "To" + whoChat;

            List privateChat = null;

            if (application.getAttribute(appNameSelf) == null) {
                privateChat = new LinkedList();
                privateChat.add(whoChat + " : " + sayWhat);
                application.setAttribute(appNameSelf, privateChat);
            } else {
                privateChat = (List) application.getAttribute(appNameSelf);
                privateChat.add(whoChat + " : " + sayWhat);

                application.setAttribute(appNameSelf, privateChat);
            }
            //对方的信息是同步的,所以只要直接保存
            application.setAttribute(appNameOther, privateChat);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        String remove = (String) event.getValue();
        onlineUser.remove(remove);
        application.setAttribute("onlineUser", onlineUser);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        application = event.getSession().getServletContext();
        String attrName = event.getName();
        //说明是公聊
        if (attrName.equals("publicchat")) {
            HttpSession session = event.getSession();

            Chat chat = (Chat) session.getAttribute("publicchat");
            String whochat = chat.getWhochat();
            String saywhat = chat.getSaywhat();

            publicChat = (List) application.getAttribute("publicChatAll");
            publicChat.add(whochat + " : " + saywhat);
            application.setAttribute("publicChatAll", publicChat);
        }

        //私聊
        if (attrName.equals("privatechat")) {
            HttpSession session = event.getSession();
            Chat chat = (Chat) session.getAttribute("privatechat");
            String whoChat = chat.getWhochat();
            String chatWho = chat.getChatwho();
            String sayWhat = chat.getSaywhat();

            String appNameSelf = whoChat + "To" + chatWho;
            String appNameOther = chatWho + "To" + whoChat;

            List privateChat = null;

            privateChat = (List) application.getAttribute(appNameSelf);
            privateChat.add(whoChat + " : " + sayWhat);
            application.setAttribute(appNameSelf, privateChat);
            //对方的信息是同步的,所以只要直接保存
            application.setAttribute(appNameOther, privateChat);
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
