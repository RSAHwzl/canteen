package com.lin.canteen.service;

import com.lin.canteen.bean.Canteen;
import com.lin.canteen.mapper.ConsumeMapper;
import com.lin.canteen.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Service
public class CanteenAllService {
    @Autowired
    ConsumeMapper consumeMapper;
    @Autowired
    private RedisService redisService;

    /**
     * 某时间前7天各食堂每天消费额
     */
    public HashMap<Integer, HashMap<Integer, Double>> getCanteenSumByDate(int date) {
        //返回数据集合
        HashMap<Integer, HashMap<Integer, Double>> map = new HashMap<>();
        //查询7天各食堂总消费额
        for (int i = 0; i < 7; i++) {
            //计算食堂数据集合
            HashMap<Integer, Double> canteenAll = new HashMap<>();
            List<Canteen> canteen;
            String cache = redisService.get(String.valueOf(date));
            if (cache == null) {
                canteen = consumeMapper.findCanteenByDate(date);
                int finalDate = date;
                //异步存入redis
                new Thread(() -> {
                    redisService.setAndExpire(String.valueOf(finalDate), canteen, 0);
                }).start();
            } else {
                canteen = JsonUtils.jsonToList(cache, Canteen.class);
            }
            //计算红房子该天总消费额
            Double sum1 = canteen.parallelStream().filter(Canteen -> Canteen.getmCanteen() == 1)
                    .mapToDouble(Canteen::getmSum).sum();
            //计算林间小聚该天总消费额
            Double sum2 = canteen.parallelStream().filter(Canteen -> Canteen.getmCanteen() == 2)
                    .mapToDouble(Canteen::getmSum).sum();
            //计算一食堂该天总消费额
            Double sum3 = canteen.parallelStream().filter(Canteen -> Canteen.getmCanteen() == 3)
                    .mapToDouble(Canteen::getmSum).sum();
            //计算二食堂该天总消费额
            Double sum4 = canteen.parallelStream().filter(Canteen -> Canteen.getmCanteen() == 4)
                    .mapToDouble(Canteen::getmSum).sum();
            //计算三期该天总消费额
            Double sum5 = canteen.parallelStream().filter(Canteen -> Canteen.getmCanteen() == 5)
                    .mapToDouble(Canteen::getmSum).sum();
            //处理double，只保留一位小数
            sum1 = new BigDecimal(sum1).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            sum2 = new BigDecimal(sum2).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            sum3 = new BigDecimal(sum3).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            sum4 = new BigDecimal(sum4).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            sum5 = new BigDecimal(sum5).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            //数据放入
            canteenAll.put(1, sum1);
            canteenAll.put(2, sum2);
            canteenAll.put(3, sum3);
            canteenAll.put(4, sum4);
            canteenAll.put(5, sum5);
            map.put(date, canteenAll);
            //计算前一天
            date = date - 86400;
        }

        return map;
    }

    /**
     * 某时间前7天所有食堂每天总消费额
     */
    public HashMap<Integer, Double> getCanteenAllByDate(int date) {
        //返回数据集合
        HashMap<Integer, Double> map = new HashMap<>();
        //查询7天各食堂总消费额
        for (int i = 0; i < 7; i++) {
            List<Canteen> canteen;
            String cache = redisService.get(String.valueOf(date));
            if (cache == null) {
                canteen = consumeMapper.findCanteenByDate(date);
                int finalDate = date;
                //异步存入redis
                new Thread(() -> {
                    redisService.setAndExpire(String.valueOf(finalDate), canteen, 0);
                }).start();
            } else {
                canteen = JsonUtils.jsonToList(cache, Canteen.class);
            }
            //计算所有食堂该天总消费额
            Double sum = canteen.parallelStream().mapToDouble(Canteen::getmSum).sum();
            //处理double，只保留一位小数
            sum = new BigDecimal(sum).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            //数据放入
            map.put(date, sum);
            //计算前一天
            date = date - 86400;
        }

        return map;
    }

    /**
     * 某时间前7天所有食堂外卖/就地消费数量
     */
    public HashMap<Integer, HashMap<Integer, Integer>> getCanteenAllDeliveryByDate(int date) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < 7; i++) {
            HashMap<Integer, Integer> deliveryAll = new HashMap<>();
            List<Canteen> canteen;
            String cache = redisService.get(String.valueOf(date));
            if (cache == null) {
                canteen = consumeMapper.findCanteenByDate(date);
                int finalDate = date;
                //异步存入redis
                new Thread(() -> {
                    redisService.setAndExpire(String.valueOf(finalDate), canteen, 0);
                }).start();
            } else {
                canteen = JsonUtils.jsonToList(cache, Canteen.class);
            }
            //计算食堂总消费份数
            int sum = canteen.parallelStream().mapToInt(Canteen::getcNum).sum();
            //计算食堂外卖份数
            int delivery = canteen.parallelStream().mapToInt(Canteen::getcDelivery).sum();
            //就地就餐份数
            deliveryAll.put(1, sum - delivery);
            //外卖份数
            deliveryAll.put(2, delivery);
            //数据放入
            map.put(date, deliveryAll);
            //计算前一天
            date = date - 86400;
        }

        return map;
    }

    /**
     * 某时间前7天所有食堂男/女消费数量
     */
    public HashMap<Integer, HashMap<Integer, Integer>> getCanteenAllSexByDate(int date) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < 7; i++) {
            HashMap<Integer, Integer> sexAll = new HashMap<>();
            List<Canteen> canteen;
            String cache = redisService.get(String.valueOf(date));
            if (cache == null) {
                canteen = consumeMapper.findCanteenByDate(date);
                int finalDate = date;
                //异步存入redis
                new Thread(() -> {
                    redisService.setAndExpire(String.valueOf(finalDate), canteen, 0);
                }).start();
            } else {
                canteen = JsonUtils.jsonToList(cache, Canteen.class);
            }
            //计算食堂总消费份数
            int sum = canteen.parallelStream().mapToInt(Canteen::getcNum).sum();
            //计算食堂男生份数
            int male = canteen.parallelStream().mapToInt(Canteen::getcMale).sum();
            //男生份数
            sexAll.put(1, male);
            //女生份数
            sexAll.put(2, sum - male);
            //数据放入
            map.put(date, sexAll);
            //计算前一天
            date = date - 86400;
        }

        return map;
    }

}
