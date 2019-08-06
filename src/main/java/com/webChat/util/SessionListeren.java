package com.webChat.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

public class SessionListeren implements HttpSessionListener,HttpSessionAttributeListener {

    private ServletContext application = null;

    List list = new ArrayList();

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        application = event.getSession().getServletContext();
//        Session session = new Session();
//        session.setName(event.getName());
//        session.setValue((String) event.getValue());
        list.add((String) event.getValue());
        application.setAttribute("onlineUser",list);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
