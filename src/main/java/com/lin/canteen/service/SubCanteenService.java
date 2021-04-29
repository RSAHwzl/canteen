package com.lin.canteen.service;

import com.lin.canteen.bean.Consume;
import com.lin.canteen.bean.Window;
import com.lin.canteen.mapper.ConsumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class SubCanteenService {

    @Autowired
    ConsumeMapper consumeMapper;
    //窗口id
    private int[] windowTag = {1, 2, 3, 4, 5, 6, 7};

    /**
     * 返回各食堂各窗口某天消费数量
     */
    public HashMap<Integer, HashMap<Integer, Integer>> getWindowNumByDate(int date, int num, int canteen) {
        //返回数据集合
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        //七天
        for (int i = 0; i < 7; i++) {
            ArrayList<Window> window = consumeMapper.findCanteenByWindow(date);
            HashMap<Integer, Integer> hfz = new HashMap<>();
            //计算canteen食堂各窗口num的该天消费额
            for (int j = 1; j < num; j++) {
                int t = j - 1;
                int sum = window.parallelStream().filter(Window -> Window.getmCanteen() == canteen)
                        .filter(Window -> Window.getmWindow() == windowTag[t])
                        .mapToInt(Window::getcNum).sum();
                hfz.put(j, sum);
                //该天所有数据
                map.put(date, hfz);
            }
            //计算前一天
            date = date - 86400;
        }
        return map;
    }

    /**
     * 返回各食堂各窗口某天消费额
     */
    public HashMap<Integer, HashMap<Integer, Double>> getWindowSumByDate(int date, int num, int canteen) {
        //返回数据集合
        HashMap<Integer, HashMap<Integer, Double>> map = new HashMap<>();
        //七天
        for (int i = 0; i < 7; i++) {
            ArrayList<Window> window = consumeMapper.findCanteenByWindow(date);
            HashMap<Integer, Double> hfz = new HashMap<>();
            //计算canteen食堂各窗口num的该天消费额
            for (int j = 1; j < num; j++) {
                int t = j - 1;
                double sum = window.parallelStream().filter(Window -> Window.getmCanteen() == canteen)
                        .filter(Window -> Window.getmWindow() == windowTag[t])
                        .mapToDouble(Window::getmSum).sum();
                sum = new BigDecimal(sum).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                hfz.put(j, sum);
                //该天所有数据
                map.put(date, hfz);
            }
            //计算前一天
            date = date - 86400;
        }
        return map;
    }

    /**
     * 返回各食堂某天外卖/就地就餐份数
     */
    public HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> getWindowDeliveryByDate(int date, int num, int canteen) {
        //返回数据集合
        HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> map = new HashMap<>();
        int[] checkDate = new int[7];
        //七天
        String dateSearch = "(";
        for (int i = 0; i < 7; i++) {
            dateSearch += date + ",";
            checkDate[i] = date;
            date = date - 86400;
        }
        dateSearch = dateSearch.substring(0, dateSearch.length() - 1) + ")";
        ArrayList<Consume> window = consumeMapper.findCanteenAllByDate(dateSearch);
        //计算canteen食堂各窗口num的该天消费额
        for (int i = 0; i < 7; i++) {
            HashMap<Integer, HashMap<Integer, Integer>> windowResult = new HashMap<>();
            for (int j = 1; j < num; j++) {
                int t = j - 1;
                int finalI = i;
                HashMap<Integer, Integer> result = new HashMap<>();
                int sum = window.parallelStream().filter(Consume -> Consume.getmCanteen() == canteen)
                        .filter(Consume -> Consume.getcDate() == checkDate[finalI])
                        .filter(Consume -> Consume.getmWindow() == windowTag[t])
                        .mapToInt(Consume::getcNum).sum();
                int delivery = window.parallelStream().filter(Consume -> Consume.getmCanteen() == canteen)
                        .filter(Consume -> Consume.getmWindow() == windowTag[t])
                        .filter(Consume -> Consume.getcDate() == checkDate[finalI])
                        .mapToInt(Consume::getcDelivery).sum();
                result.put(1, sum - delivery);
                result.put(2, delivery);
                result.put(3, (sum - delivery) - delivery);
                //该天所有数据
                windowResult.put(j, result);
            }
            map.put(checkDate[i], windowResult);
        }

        return map;
    }

    /**
     * 返回各食堂某天外卖/就地就餐份数
     */
    public HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> getWindowMaleByDate(int date, int num, int canteen) {
        //返回数据集合
        HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> map = new HashMap<>();
        int[] checkDate = new int[7];
        //七天
        String dateSearch = "(";
        for (int i = 0; i < 7; i++) {
            dateSearch += date + ",";
            checkDate[i] = date;
            date = date - 86400;
        }
        dateSearch = dateSearch.substring(0, dateSearch.length() - 1) + ")";
        ArrayList<Consume> window = consumeMapper.findCanteenAllByDate(dateSearch);
        //计算canteen食堂各窗口num的该天消费额
        for (int i = 0; i < 7; i++) {
            HashMap<Integer, HashMap<Integer, Integer>> windowResult = new HashMap<>();
            for (int j = 1; j < num; j++) {
                int t = j - 1;
                int finalI = i;
                HashMap<Integer, Integer> result = new HashMap<>();
                int sum = window.parallelStream().filter(Consume -> Consume.getmCanteen() == canteen)
                        .filter(Consume -> Consume.getcDate() == checkDate[finalI])
                        .filter(Consume -> Consume.getmWindow() == windowTag[t])
                        .mapToInt(Consume::getcNum).sum();
                int male = window.parallelStream().filter(Consume -> Consume.getmCanteen() == canteen)
                        .filter(Consume -> Consume.getmWindow() == windowTag[t])
                        .filter(Consume -> Consume.getcDate() == checkDate[finalI])
                        .mapToInt(Consume::getcMale).sum();
                result.put(1, sum - male);
                result.put(2, male);
                result.put(3, (sum - male) - male);
                //该天所有数据
                windowResult.put(j, result);
            }
            map.put(checkDate[i], windowResult);
        }

        return map;
    }

}

