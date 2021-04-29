package com.lin.canteen.controller;

import com.lin.canteen.service.CanteenAllService;
import com.lin.canteen.service.SubCanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CanteenAllController {
    @Autowired
    CanteenAllService canteenAllService;
    @Autowired
    SubCanteenService subCanteenService;

    //食堂总消费
    @GetMapping("/getCanteenAll")
    public HashMap<Integer, Double> getCanteenAllByDate(int date) {
        return canteenAllService.getCanteenAllByDate(date);
    }

    //各食堂消费
    @GetMapping("/getCanteenSum")
    public HashMap<Integer, HashMap<Integer, Double>> getCanteenSumByDate(int date) {
        return canteenAllService.getCanteenSumByDate(date);
    }

    //食堂外卖/就地消费
    @GetMapping("/getCanteenDelivery")
    public HashMap<Integer, HashMap<Integer, Integer>> getCanteenAllDeliveryByDate(int date) {
        return canteenAllService.getCanteenAllDeliveryByDate(date);
    }

    //食堂男/女消费
    @GetMapping("/getCanteenSex")
    public HashMap<Integer, HashMap<Integer, Integer>> getCanteenAllSexByDate(int date) {
        return canteenAllService.getCanteenAllSexByDate(date);
    }
}
