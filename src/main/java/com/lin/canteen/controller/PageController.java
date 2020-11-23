package com.lin.canteen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {

    @GetMapping("/index")
    public String toIndex(HttpServletRequest request) {
        String user= String.valueOf(request.getSession().getAttribute("account"));
        if (user.equals("null")){
            return "login";
        }else {
            System.out.println(user.length());
            System.out.println(user);
            return "index";
        }
    }

    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }
}
