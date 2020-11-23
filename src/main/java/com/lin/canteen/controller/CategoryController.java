package com.lin.canteen.controller;

import com.lin.canteen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/getCategory")
    public HashMap<Integer, HashMap<String,Object>> getCategory(int date){
        return  categoryService.getCategoryByDate(date);
    }
}
