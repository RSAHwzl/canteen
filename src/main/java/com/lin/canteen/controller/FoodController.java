package com.lin.canteen.controller;

import com.lin.canteen.bean.Food;
import com.lin.canteen.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;

    @GetMapping("/getFoodHot")
    public ArrayList<Food> getFoodHotByDate(int date, int canteen, int window){
        return foodService.getHotFoodByDate(date,canteen,window);
    }

    @GetMapping("/getFoodHotWeek")
    public HashMap<Integer,HashMap<String,Integer>> getFoodHotByDate(int date, int canteen, int window, @RequestParam(value = "names") String[] names){
        return foodService.getHotFoodByWeek(date,canteen,window,names);
    }
}
