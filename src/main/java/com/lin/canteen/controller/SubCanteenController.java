package com.lin.canteen.controller;

import com.lin.canteen.service.SubCanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class SubCanteenController {

    @Autowired
    SubCanteenService subCanteenService;

    //红房子各窗口消费份数
    @GetMapping("/getHfzNum")
    public HashMap<Integer, HashMap<Integer, Integer>> getHfzNumByDate(int date) {
        return subCanteenService.getWindowNumByDate(date, 6, 1);
    }

    //红房子各窗口总消费
    @GetMapping("/getHfzSum")
    public HashMap<Integer, HashMap<Integer, Double>> getHfzSumByDate(int date) {
        return subCanteenService.getWindowSumByDate(date, 6, 1);
    }

    //红房子各窗口外卖/就地就餐
    @GetMapping("/getHfzDelivery")
    public HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> getHfzDeliveryByDate(int date) {
        return subCanteenService.getWindowDeliveryByDate(date, 6, 1);
    }

    //红房子各窗口男/女就餐
    @GetMapping("/getHfzMale")
    public HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> getHfzMaleByDate(int date) {
        return subCanteenService.getWindowMaleByDate(date, 6, 1);
    }


    //林间小聚各窗口消费份数
    @GetMapping("/getLjNum")
    public HashMap<Integer, HashMap<Integer, Integer>> getLjNumByDate(int date) {
        return subCanteenService.getWindowNumByDate(date, 8, 2);
    }

    //林间小聚各窗口总消费
    @GetMapping("/getLjSum")
    public HashMap<Integer, HashMap<Integer, Double>> getLjSumByDate(int date) {
        return subCanteenService.getWindowSumByDate(date, 8, 2);
    }

    //林间小聚各窗口外卖/就地就餐
    @GetMapping("/getLjDelivery")
    public HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> getLjDeliveryByDate(int date) {
        return subCanteenService.getWindowDeliveryByDate(date, 8, 2);
    }

    //林间小聚各窗口男/女就餐
    @GetMapping("/getLjMale")
    public HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> getLjMaleByDate(int date) {
        return subCanteenService.getWindowMaleByDate(date, 8, 2);
    }

    //一食堂各窗口消费份数
    @GetMapping("/getYstNum")
    public HashMap<Integer, HashMap<Integer, Integer>> getYstNumByDate(int date) {
        return subCanteenService.getWindowNumByDate(date, 7, 3);
    }

    //一食堂各窗口总消费
    @GetMapping("/getYstSum")
    public HashMap<Integer, HashMap<Integer, Double>> getYstSumByDate(int date) {
        return subCanteenService.getWindowSumByDate(date, 7, 3);
    }

    //一食堂各窗口外卖/就地就餐
    @GetMapping("/getYstDelivery")
    public HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> getYstDeliveryByDate(int date) {
        return subCanteenService.getWindowDeliveryByDate(date, 7, 3);
    }

    //一食堂各窗口男/女就餐
    @GetMapping("/getYstMale")
    public HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> getYstMaleByDate(int date) {
        return subCanteenService.getWindowMaleByDate(date, 7, 3);
    }

    //二食堂各窗口消费份数
    @GetMapping("/getEstNum")
    public HashMap<Integer, HashMap<Integer, Integer>> getEstByDate(int date) {
        return subCanteenService.getWindowNumByDate(date, 8, 4);
    }

    //二食堂各窗口总消费
    @GetMapping("/getEstSum")
    public HashMap<Integer, HashMap<Integer, Double>> getEstSumByDate(int date) {
        return subCanteenService.getWindowSumByDate(date, 8, 4);
    }

    //二食堂各窗口外卖/就地就餐
    @GetMapping("/getEstDelivery")
    public HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> getEstDeliveryByDate(int date) {
        return subCanteenService.getWindowDeliveryByDate(date, 8, 4);
    }

    //二食堂各窗口男/女就餐
    @GetMapping("/getEstMale")
    public HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> getEstMaleByDate(int date) {
        return subCanteenService.getWindowMaleByDate(date, 8, 4);
    }

    //三期各窗口消费份数
    @GetMapping("/getSqNum")
    public HashMap<Integer, HashMap<Integer, Integer>> getSqNumByDate(int date) {
        return subCanteenService.getWindowNumByDate(date, 6, 5);
    }

    //三期各窗口总消费
    @GetMapping("/getSqSum")
    public HashMap<Integer, HashMap<Integer, Double>> getSqSumByDate(int date) {
        return subCanteenService.getWindowSumByDate(date, 6, 5);
    }

    //三期各窗口外卖/就地就餐
    @GetMapping("/getSqDelivery")
    public HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> getSqDeliveryByDate(int date) {
        return subCanteenService.getWindowDeliveryByDate(date, 6, 5);
    }

    //三期各窗口男/女就餐
    @GetMapping("/getSqMale")
    public HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> getSqMaleByDate(int date) {
        return subCanteenService.getWindowMaleByDate(date, 6, 5);
    }

}
