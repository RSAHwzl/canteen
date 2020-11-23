package com.lin.canteen.controller;

import com.lin.canteen.service.CanteenAllService;
import com.lin.canteen.service.CanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CanteenController {
    @Autowired
    CanteenAllService canteenAllService;
    @Autowired
    CanteenService canteenService;

    //食堂总消费
    @GetMapping("/getCanteenAll")
    public HashMap<Integer,Double> getCanteenAllByDate(int date){
        return canteenAllService.getCanteenAllByDate(date);
    }
    //各食堂消费
    @GetMapping("/getCanteenSum")
    public HashMap<Integer, HashMap<Integer,Double>> getCanteenSumByDate(int date){
        return canteenAllService.getCanteenSumByDate(date);
    }
    //红房子各窗口总消费
    @GetMapping("/getHfzSum")
    public HashMap<Integer,HashMap<Integer,Double>> getHfzSumByDate(int date){
        return canteenService.getWindowSumByDate(date,6,1);
    }
    //林间小聚各窗口总消费
    @GetMapping("/getLjSum")
    public HashMap<Integer,HashMap<Integer,Double>> getLjSumByDate(int date){
        return canteenService.getWindowSumByDate(date,8,2);
    }
    //一食堂各窗口总消费
    @GetMapping("/getYstSum")
    public HashMap<Integer,HashMap<Integer,Double>> getYstSumByDate(int date){
        return canteenService.getWindowSumByDate(date,7,3);
    }
    //二食堂各窗口总消费
    @GetMapping("/getEstSum")
    public HashMap<Integer,HashMap<Integer,Double>> getEstSumByDate(int date){
        return canteenService.getWindowSumByDate(date,8,4);
    }
    //三期各窗口总消费
    @GetMapping("/getSqSum")
    public HashMap<Integer,HashMap<Integer,Double>> getSqSumByDate(int date){
        return canteenService.getWindowSumByDate(date,6,5);
    }

}
