package com.lin.canteen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/index")
    public String toIndex() {
        return "index";
    }

    @GetMapping("/student")
    public String toStudent() {
        return "student";
    }

    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }
}
