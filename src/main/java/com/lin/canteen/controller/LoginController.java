package com.lin.canteen.controller;

import com.lin.canteen.bean.User;
import com.lin.canteen.service.UserService;
import com.lin.canteen.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    //生成验证码
    @GetMapping("/getImg")
    public Object getCaptchaImg(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        Map result = new HashMap();
        try {
            response.setContentType("image/png");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Expire", "0");
            response.setHeader("Pragma", "no-cache");
            CodeUtil validateCode = new CodeUtil();
            // 返回base64
            String base64String = validateCode.getRandomCodeBase64(request, response);
            result.put("url", "data:image/png;base64," + base64String);
            result.put("message", "created successfull");
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;

    }

    @GetMapping("/regist")
    public int regist(User user) {
        return userService.insertUser(user);
    }

    @GetMapping("/toLogin")
    public int login(String UserName, String PassWord, int Auth, String Code, HttpServletRequest request) {
        String code = String.valueOf(request.getSession().getAttribute("JCCODE")).toLowerCase();
        int result = userService.selectUser(UserName, PassWord, Auth);
        if (result != 0 && code.equals(Code)) {
            request.getSession().setAttribute("account", UserName);
            return 1;
        }
        return 0;
    }
}
