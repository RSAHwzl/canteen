package com.lin.canteen.service;

import com.lin.canteen.bean.Consume;
import com.lin.canteen.mapper.ConsumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class StudentService {

    @Autowired
    ConsumeMapper consumeMapper;

    /**
     * 某天各食堂销售菜品top3
     */
    public HashMap<Integer, HashMap<String, Object>> getStudentCanteenRankByDate(int date) {
        HashMap<Integer, HashMap<String, Object>> result = new HashMap<>();
        //返回数据集合,前15名
        ArrayList<Consume> consumeRank = consumeMapper.findStudentCanteenRankByDate(date, 15);
        int rank = 0;
        for (Consume consume : consumeRank) {
            HashMap<String, Object> map = new HashMap<>();
            switch (consume.getmCanteen()) {
                case 1:
                    map.put("name", "红房子-" + consume.getmName());
                    map.put("num", consume.getcNum());
                    break;
                case 2:
                    map.put("name", "林间小聚-" + consume.getmName());
                    map.put("num", consume.getcNum());
                    break;
                case 3:
                    map.put("name", "一食堂-" + consume.getmName());
                    map.put("num", consume.getcNum());
                    break;
                case 4:
                    map.put("name", "二食堂-" + consume.getmName());
                    map.put("num", consume.getcNum());
                    break;
                case 5:
                    map.put("name", "三期-" + consume.getmName());
                    map.put("num", consume.getcNum());
                    break;
            }
            result.put(rank, map);
            rank++;
        }

        return result;
    }

    /**
     * 某天各食堂消费份数(就地就餐/外卖)
     */
    public HashMap<Integer, HashMap<String, Integer>> getStudentCanteenDeliveryByDate(int date) {
        //返回数据集合
        HashMap<Integer, HashMap<String, Integer>> map = new HashMap<>();
        ArrayList<Consume> consumeAll = consumeMapper.findStudentCanteenAllByDate(date);
        //存放5个食堂数据
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashMap<String, Integer> map3 = new HashMap<>();
        HashMap<String, Integer> map4 = new HashMap<>();
        HashMap<String, Integer> map5 = new HashMap<>();

        int sum1 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 1).mapToInt(Consume::getcNum).sum();
        int delivery1 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 1).mapToInt(Consume::getcDelivery).sum();
        int sum2 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 2).mapToInt(Consume::getcNum).sum();
        int delivery2 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 2).mapToInt(Consume::getcDelivery).sum();
        int sum3 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 3).mapToInt(Consume::getcNum).sum();
        int delivery3 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 3).mapToInt(Consume::getcDelivery).sum();
        int sum4 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 4).mapToInt(Consume::getcNum).sum();
        int delivery4 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 4).mapToInt(Consume::getcDelivery).sum();
        int sum5 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 5).mapToInt(Consume::getcNum).sum();
        int delivery5 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 5).mapToInt(Consume::getcDelivery).sum();
        map1.put("delivery", delivery1);
        map1.put("local", sum1 - delivery1);
        map1.put("sum", sum1);
        map2.put("delivery", delivery2);
        map2.put("local", sum2 - delivery2);
        map2.put("sum", sum2);
        map3.put("delivery", delivery3);
        map3.put("local", sum3 - delivery3);
        map3.put("sum", sum3);
        map4.put("delivery", delivery4);
        map4.put("local", sum4 - delivery4);
        map4.put("sum", sum4);
        map5.put("delivery", delivery5);
        map5.put("local", sum5 - delivery5);
        map5.put("sum", sum5);
        map.put(1, map1);
        map.put(2, map2);
        map.put(3, map3);
        map.put(4, map4);
        map.put(5, map5);
        return map;
    }

    /**
     * 某天各食堂消费份数(男/女)
     */
    public HashMap<Integer, HashMap<String, Integer>> getStudentCanteenMaleByDate(int date) {
        //返回数据集合
        HashMap<Integer, HashMap<String, Integer>> map = new HashMap<>();
        ArrayList<Consume> consumeAll = consumeMapper.findStudentCanteenAllByDate(date);
        //存放5个食堂数据
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashMap<String, Integer> map3 = new HashMap<>();
        HashMap<String, Integer> map4 = new HashMap<>();
        HashMap<String, Integer> map5 = new HashMap<>();

        int sum1 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 1).mapToInt(Consume::getcNum).sum();
        int delivery1 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 1).mapToInt(Consume::getcMale).sum();
        int sum2 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 2).mapToInt(Consume::getcNum).sum();
        int delivery2 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 2).mapToInt(Consume::getcMale).sum();
        int sum3 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 3).mapToInt(Consume::getcNum).sum();
        int delivery3 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 3).mapToInt(Consume::getcMale).sum();
        int sum4 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 4).mapToInt(Consume::getcNum).sum();
        int delivery4 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 4).mapToInt(Consume::getcMale).sum();
        int sum5 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 5).mapToInt(Consume::getcNum).sum();
        int delivery5 = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == 5).mapToInt(Consume::getcMale).sum();
        map1.put("delivery", delivery1);
        map1.put("local", sum1 - delivery1);
        map2.put("delivery", delivery2);
        map2.put("local", sum2 - delivery2);
        map3.put("delivery", delivery3);
        map3.put("local", sum3 - delivery3);
        map4.put("delivery", delivery4);
        map4.put("local", sum4 - delivery4);
        map5.put("delivery", delivery5);
        map5.put("local", sum5 - delivery5);
        map.put(1, map1);
        map.put(2, map2);
        map.put(3, map3);
        map.put(4, map4);
        map.put(5, map5);

        return map;
    }

    /**
     * 学生分页面
     */
    //获取食堂消费区间
    public HashMap<Integer, Integer> getStudentCanteenRangeByDate(int date, int canteen) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Consume> consumeAll = consumeMapper.findStudentCanteenAllByDate(date);
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        for (Consume consume : consumeAll) {
            if (consume.getmCanteen() != canteen) {
                continue;
            }
            if (consume.getmPrice() < 8) {
                num1++;
            } else if (8 <= consume.getmPrice() && consume.getmPrice() < 12) {
                num2++;
            } else if (12 <= consume.getmPrice() && consume.getmPrice() < 20) {
                num3++;
            } else {
                num4++;
            }
        }
        map.put(0, num1);
        map.put(1, num2);
        map.put(2, num3);
        map.put(3, num4);
        return map;
    }

    //获取食堂各窗口消费份数
    public HashMap<Integer, Integer> getStudentCanteenWindowByDate(int date, int canteen, int window) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Consume> consumeAll = consumeMapper.findStudentCanteenAllByDate(date);
        for (int i = 1; i <= window; i++) {
            int finalI = i;
            int sum = consumeAll.parallelStream().filter(Consume -> Consume.getmCanteen() == canteen).
                    filter(Consume -> Consume.getmWindow() == finalI).
                    mapToInt(Consume::getcNum).sum();
            map.put(i, sum);
        }
        return map;
    }

    //获取食堂消费份数前15
    public HashMap<Integer, HashMap<String, Object>> getStudentCanteenWindowRankByDate(int date, int canteen, int window) {
        String[][] windowName = {{"红房子二刀面庄", "奇妙干锅", "盖饭炒饭系列", "小炒系列", "套饭系列"},
                {"哈喽米线", "套饭系列", "如意家常小炒", "刘嬢嬢豌杂面", "乔园里包子铺", "麻辣香锅", "掉渣饼"},
                {"罐罐米线", "美滋滋洋芋饭", "亦冰亦火焖锅", "西西里风情", "木桶大盘鸡", "包满意"},
                {"特色炒饭", "煲仔蛋包饭", "牛肉饭", "营养早餐", "老麻抄手", "酱香饼", "好粥道"},
                {"皇尚吉祥", "特色渔粉", "晓忆匠卤现捞", "盐都干锅王", "嗨皮土豆"}};
        HashMap<Integer, HashMap<String, Object>> result = new HashMap<>();
        ArrayList<Consume> consumeAll = consumeMapper.findStudentCanteenWindowRankByDate(date, canteen, window, 15);
        int num = 0;
        for (Consume consume : consumeAll) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("name", windowName[consume.getmCanteen() - 1][consume.getmWindow() - 1] + "-" + consume.getmName());
            map.put("num", consume.getcNum());
            result.put(num, map);
            num++;
        }

        return result;
    }

}
