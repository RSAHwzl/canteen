package com.lin.canteen.controller;

import com.lin.canteen.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/getStudentRank")
    public HashMap<Integer, HashMap<String, Object>> getStudentRank(int date) {
        return studentService.getStudentCanteenRankByDate(date);
    }

    @GetMapping("/getStudentDelivery")
    public HashMap<Integer, HashMap<String, Integer>> getStudentDelivery(int date) {
        return studentService.getStudentCanteenDeliveryByDate(date);
    }

    @GetMapping("/getStudentMale")
    public HashMap<Integer, HashMap<String, Integer>> getStudentMale(int date) {
        return studentService.getStudentCanteenMaleByDate(date);
    }

    //学生分页
    @GetMapping("/getHfzCanteenRange")
    public HashMap<Integer, Integer> getHfzCanteenRange(int date) {
        return studentService.getStudentCanteenRangeByDate(date, 1);
    }

    @GetMapping("/getHfzStudentWindow")
    public HashMap<Integer, Integer> getStudentCanteenWindowByDate(int date) {
        return studentService.getStudentCanteenWindowByDate(date, 1, 5);
    }

    @GetMapping("/getHfzStudentWindowRank")
    public HashMap<Integer, HashMap<String, Object>> getHfzStudentWindowRank(int date) {
        return studentService.getStudentCanteenWindowRankByDate(date, 1, 5);
    }

    @GetMapping("/getLjCanteenRange")
    public HashMap<Integer, Integer> getLjCanteenRange(int date) {
        return studentService.getStudentCanteenRangeByDate(date, 2);
    }

    @GetMapping("/getLjStudentWindow")
    public HashMap<Integer, Integer> getLjStudentWindow(int date) {
        return studentService.getStudentCanteenWindowByDate(date, 2, 7);
    }

    @GetMapping("/getLjStudentWindowRank")
    public HashMap<Integer, HashMap<String, Object>> getLjStudentWindowRank(int date) {
        return studentService.getStudentCanteenWindowRankByDate(date, 2, 7);
    }

    @GetMapping("/getYstCanteenRange")
    public HashMap<Integer, Integer> getYstCanteenRange(int date) {
        return studentService.getStudentCanteenRangeByDate(date, 3);
    }

    @GetMapping("/getYstStudentWindow")
    public HashMap<Integer, Integer> getYstStudentWindow(int date) {
        return studentService.getStudentCanteenWindowByDate(date, 3, 6);
    }

    @GetMapping("/getYstStudentWindowRank")
    public HashMap<Integer, HashMap<String, Object>> getYstStudentWindowRank(int date) {
        return studentService.getStudentCanteenWindowRankByDate(date, 3, 6);
    }

    @GetMapping("/getEstCanteenRange")
    public HashMap<Integer, Integer> getEstCanteenRange(int date) {
        return studentService.getStudentCanteenRangeByDate(date, 4);
    }

    @GetMapping("/getEstStudentWindow")
    public HashMap<Integer, Integer> getEstStudentWindow(int date) {
        return studentService.getStudentCanteenWindowByDate(date, 4, 7);
    }

    @GetMapping("/getEstStudentWindowRank")
    public HashMap<Integer, HashMap<String, Object>> getEstStudentWindowRank(int date) {
        return studentService.getStudentCanteenWindowRankByDate(date, 4, 7);
    }

    @GetMapping("/getSqCanteenRange")
    public HashMap<Integer, Integer> getSqCanteenRange(int date) {
        return studentService.getStudentCanteenRangeByDate(date, 5);
    }

    @GetMapping("/getSqStudentWindow")
    public HashMap<Integer, Integer> getSqStudentWindow(int date) {
        return studentService.getStudentCanteenWindowByDate(date, 5, 5);
    }

    @GetMapping("/getSqStudentWindowRank")
    public HashMap<Integer, HashMap<String, Object>> getSqStudentWindowRank(int date) {
        return studentService.getStudentCanteenWindowRankByDate(date, 5, 5);
    }

}
