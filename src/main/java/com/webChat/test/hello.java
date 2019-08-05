package com.webChat.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class hello {

    @RequestMapping("/hello")
    @ResponseBody
    public String helloWord(){
        System.out.println("hello Word");
        return "hello";
    }


}
