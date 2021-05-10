package com.lin.canteen.service;

import com.lin.canteen.bean.Category;
import com.lin.canteen.bean.Consume;
import com.lin.canteen.mapper.ConsumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CategoryService {
    @Autowired
    ConsumeMapper consumeMapper;

    //按日期查询分类情况
    public HashMap<Integer, HashMap<String, Object>> getCategoryByDate(int date) {
        HashMap<Integer, HashMap<String, Object>> result = new HashMap<>();
        ArrayList<Category> categories = consumeMapper.findCategoryByDate(date);
        //食堂集合
        HashMap<String, Object> map1 = new HashMap<>();
        HashMap<String, Object> map2 = new HashMap<>();
        HashMap<String, Object> map3 = new HashMap<>();
        HashMap<String, Object> map4 = new HashMap<>();
        HashMap<String, Object> map5 = new HashMap<>();
        HashMap<String, Object> map6 = new HashMap<>();
        //分类集合
        HashMap<String, Object> map7 = new HashMap<>();
        //总计集合
        HashMap<String, Object> map8 = new HashMap<>();
        //获取林间小聚分类1--早餐
        int num1 = getCategoryNum(categories, 2, 5, 1);
        double sum1 = getCategorySum(categories, 2, 5, 1);
        map1.put("num1", num1);
        map1.put("sum1", sum1);
        //获取一食堂分类1--早餐
        num1 = getCategoryNum(categories, 3, 6, 1);
        sum1 = getCategorySum(categories, 3, 6, 1);
        map1.put("num2", num1);
        map1.put("sum2", sum1);
        //获取二食堂分类1--早餐
        num1 = getCategoryNum(categories, 4, 4, 1);
        sum1 = getCategorySum(categories, 4, 4, 1);
        map1.put("num3", num1);
        map1.put("sum3", sum1);
        //获取二食堂分类1--早餐
        num1 = getCategoryNum(categories, 4, 7, 1);
        sum1 = getCategorySum(categories, 4, 7, 1);
        map1.put("num4", num1);
        map1.put("sum4", sum1);
        //获取三期分类1--早餐
        num1 = getCategoryNum(categories, 5, 1, 1);
        sum1 = getCategorySum(categories, 5, 1, 1);
        map1.put("num5", num1);
        map1.put("sum5", sum1);
        //获取红房子分类2--套饭系列
        int num2 = getCategoryNum(categories, 1, 5, 2);
        double sum2 = getCategorySum(categories, 1, 5, 2);
        map2.put("num1", num2);
        map2.put("sum1", sum2);
        //获取林间小聚分类2--套饭系列
        num2 = getCategoryNum(categories, 2, 2, 2);
        sum2 = getCategorySum(categories, 2, 2, 2);
        map2.put("num2", num2);
        map2.put("sum2", sum2);
        //获取林间小聚分类2--套饭系列
        num2 = getCategoryNum(categories, 3, 2, 2);
        sum2 = getCategorySum(categories, 3, 2, 2);
        map2.put("num3", num2);
        map2.put("sum3", sum2);
        //获取二食堂煲仔蛋包饭--套饭系列
        num2 = getCategoryNum(categories, 4, 2, 2);
        sum2 = getCategorySum(categories, 4, 2, 2);
        map2.put("num4", num2);
        map2.put("sum4", sum2);
        //获取二食堂你牛肉饭--套饭系列
        num2 = getCategoryNum(categories, 4, 3, 2);
        sum2 = getCategorySum(categories, 4, 3, 2);
        map2.put("num5", num2);
        map2.put("sum5", sum2);
        //获取三期分类2--套饭系列
        num2 = getCategoryNum(categories, 5, 3, 2);
        sum2 = getCategorySum(categories, 5, 3, 2);
        map2.put("num6", num2);
        map2.put("sum6", sum2);
        //获取红房子分类3--盖饭小炒
        int num3 = getCategoryNum(categories, 1, 3, 3);
        double sum3 = getCategorySum(categories, 1, 3, 3);
        map3.put("num1", num3);
        map3.put("sum1", sum3);
        //获取红房子分类3--盖饭小炒
        num3 = getCategoryNum(categories, 1, 4, 3);
        sum3 = getCategorySum(categories, 1, 4, 3);
        map3.put("num2", num3);
        map3.put("sum2", sum3);
        //获取林间小聚分类3--盖饭小炒
        num3 = getCategoryNum(categories, 2, 3, 3);
        sum3 = getCategorySum(categories, 2, 3, 3);
        map3.put("num3", num3);
        map3.put("sum3", sum3);
        //获取一食堂分类3--盖饭小炒
        num3 = getCategoryNum(categories, 3, 5, 3);
        sum3 = getCategorySum(categories, 3, 5, 3);
        map3.put("num4", num3);
        map3.put("sum4", sum3);
        //获取二食堂分类3--盖饭小炒
        num3 = getCategoryNum(categories, 4, 1, 3);
        sum3 = getCategorySum(categories, 4, 1, 3);
        map3.put("num5", num3);
        map3.put("sum5", sum3);
        //获取红房子分类4--干锅
        int num4 = getCategoryNum(categories, 1, 2, 4);
        double sum4 = getCategorySum(categories, 1, 2, 4);
        map4.put("num1", num4);
        map4.put("sum1", sum4);
        //获取林间小聚分类4--干锅
        num4 = getCategoryNum(categories, 2, 6, 4);
        sum4 = getCategorySum(categories, 2, 6, 4);
        map4.put("num2", num4);
        map4.put("sum2", sum4);
        //获取一食堂分类4--干锅
        num4 = getCategoryNum(categories, 3, 3, 4);
        sum4 = getCategorySum(categories, 3, 3, 4);
        map4.put("num3", num4);
        map4.put("sum3", sum4);
        //获取三期分类4--干锅
        num4 = getCategoryNum(categories, 5, 4, 4);
        sum4 = getCategorySum(categories, 5, 4, 4);
        map4.put("num4", num4);
        map4.put("sum4", sum4);
        //获取红房子分类5--面食
        int num5 = getCategoryNum(categories, 1, 1, 5);
        double sum5 = getCategorySum(categories, 1, 1, 5);
        map5.put("num1", num5);
        map5.put("sum1", sum5);
        //获取林间小聚分类5--面食
        num5 = getCategoryNum(categories, 2, 1, 5);
        sum5 = getCategorySum(categories, 2, 1, 5);
        map5.put("num2", num5);
        map5.put("sum2", sum5);
        //获取林间小聚分类5--面食
        num5 = getCategoryNum(categories, 2, 4, 5);
        sum5 = getCategorySum(categories, 2, 4, 5);
        map5.put("num3", num5);
        map5.put("sum3", sum5);
        //获取一食堂分类5--面食
        num5 = getCategoryNum(categories, 3, 1, 5);
        sum5 = getCategorySum(categories, 3, 1, 5);
        map5.put("num4", num5);
        map5.put("sum4", sum5);
        //获取二食堂分类5--面食
        num5 = getCategoryNum(categories, 4, 5, 5);
        sum5 = getCategorySum(categories, 4, 5, 5);
        map5.put("num5", num5);
        map5.put("sum5", sum5);
        //获取三期分类5--面食
        num5 = getCategoryNum(categories, 5, 2, 5);
        sum5 = getCategorySum(categories, 5, 2, 5);
        map5.put("num6", num5);
        map5.put("sum6", sum5);
        //获取林间小聚分类6--小吃
        int num6 = getCategoryNum(categories, 2, 7, 6);
        double sum6 = getCategorySum(categories, 2, 7, 6);
        map6.put("num1", num6);
        map6.put("sum1", sum6);
        //获取一食堂分类6--小吃
        num6 = getCategoryNum(categories, 3, 4, 6);
        sum6 = getCategorySum(categories, 3, 4, 6);
        map6.put("num2", num6);
        map6.put("sum2", sum6);
        //获取二食堂分类6--小吃
        num6 = getCategoryNum(categories, 4, 6, 6);
        sum6 = getCategorySum(categories, 4, 6, 6);
        map6.put("num3", num6);
        map6.put("sum3", sum6);
        //获取一食堂分类6--小吃
        num6 = getCategoryNum(categories, 5, 5, 6);
        sum6 = getCategorySum(categories, 5, 5, 6);
        map6.put("num4", num6);
        map6.put("sum4", sum6);
        //获取早餐所有份数，消费额
        int num7 = getCategoryNumAll(categories, 1);
        double sum7 = getCategorySumAll(categories, 1);
        map7.put("num1", num7);
        map7.put("sum1", sum7);
        //获取套饭所有份数，消费额
        num7 = getCategoryNumAll(categories, 2);
        sum7 = getCategorySumAll(categories, 2);
        map7.put("num2", num7);
        map7.put("sum2", sum7);
        //获取盖饭小炒所有份数，消费额
        num7 = getCategoryNumAll(categories, 3);
        sum7 = getCategorySumAll(categories, 3);
        map7.put("num3", num7);
        map7.put("sum3", sum7);
        //获取干锅所有份数，消费额
        num7 = getCategoryNumAll(categories, 4);
        sum7 = getCategorySumAll(categories, 4);
        map7.put("num4", num7);
        map7.put("sum4", sum7);
        //获取面食所有份数，消费额
        num7 = getCategoryNumAll(categories, 5);
        sum7 = getCategorySumAll(categories, 5);
        map7.put("num5", num7);
        map7.put("sum5", sum7);
        //获取小吃所有份数，消费额
        num7 = getCategoryNumAll(categories, 6);
        sum7 = getCategorySumAll(categories, 6);
        map7.put("num6", num7);
        map7.put("sum6", sum7);
        //获取所有份数，消费额
        int num8 = categories.parallelStream().mapToInt(Category::getcNum).sum();
        double sum8 = categories.parallelStream().mapToDouble(Category::getmSum).sum();
        sum8 = new BigDecimal(sum8).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        map8.put("num", num8);
        map8.put("sum", sum8);
        //拼装数据
        result.put(1, map1);
        result.put(2, map2);
        result.put(3, map3);
        result.put(4, map4);
        result.put(5, map5);
        result.put(6, map6);
        result.put(7, map7);
        result.put(8, map8);

        return result;
    }

    public int getCategoryNum(ArrayList<Category> categories, int canteen, int window, int category) {
        return categories.parallelStream().filter(Category -> Category.getmCanteen() == canteen).
                filter(Category -> Category.getmWindow() == window).
                filter(Category -> Category.getmCategory() == category).
                mapToInt(Category::getcNum).sum();
    }

    public int getCategoryNumAll(ArrayList<Category> categories, int category) {
        return categories.parallelStream().filter(Category -> Category.getmCategory() == category).
                mapToInt(Category::getcNum).sum();
    }

    public double getCategorySum(ArrayList<Category> categories, int canteen, int window, int category) {
        double sum = categories.parallelStream().filter(Category -> Category.getmCanteen() == canteen).
                filter(Category -> Category.getmWindow() == window).
                filter(Category -> Category.getmCategory() == category).
                mapToDouble(Category::getmSum).sum();
        return new BigDecimal(sum).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public double getCategorySumAll(ArrayList<Category> categories, int category) {
        double sum = categories.parallelStream().filter(Category -> Category.getmCategory() == category).
                mapToDouble(Category::getmSum).sum();
        return new BigDecimal(sum).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public HashMap<Integer, HashMap<String, Object>> getCategoryDeliveryByDate(int date) {
        HashMap<Integer, HashMap<String, Object>> result = new HashMap<>();
        ArrayList<Consume> categories = consumeMapper.findCanteenAllByDate("(" + String.valueOf(date) + ")");
        //分类集合
        HashMap<String, Object> map1 = new HashMap<>();
        HashMap<String, Object> map2 = new HashMap<>();
        HashMap<String, Object> map3 = new HashMap<>();
        HashMap<String, Object> map4 = new HashMap<>();
        HashMap<String, Object> map5 = new HashMap<>();
        HashMap<String, Object> map6 = new HashMap<>();
        //分类份数总计
        HashMap<String, Object> map7 = new HashMap<>();
        //获取林间小聚分类1--早餐
        int num1 = getCanteenCategoryDelivery(categories, 2, 5, 1);
        int sum1 = getCanteenCategorySum(categories, 2, 5, 1);
        map1.put("delivery1", num1);
        map1.put("local1", sum1 - num1);
        //获取一食堂分类1--早餐
        num1 = getCanteenCategoryDelivery(categories, 3, 6, 1);
        sum1 = getCanteenCategorySum(categories, 3, 6, 1);
        map1.put("delivery2", num1);
        map1.put("local2", sum1 - num1);
        //获取二食堂分类1--早餐
        num1 = getCanteenCategoryDelivery(categories, 4, 4, 1);
        sum1 = getCanteenCategorySum(categories, 4, 4, 1);
        map1.put("delivery3", num1);
        map1.put("local3", sum1 - num1);
        //获取二食堂分类1--早餐
        num1 = getCanteenCategoryDelivery(categories, 4, 7, 1);
        sum1 = getCanteenCategorySum(categories, 4, 7, 1);
        map1.put("delivery4", num1);
        map1.put("local4", sum1 - num1);
        //获取三期分类1--早餐
        num1 = getCanteenCategoryDelivery(categories, 5, 1, 1);
        sum1 = getCanteenCategorySum(categories, 5, 1, 1);
        map1.put("delivery5", num1);
        map1.put("local5", sum1 - num1);
        //获取红房子分类2--套饭系列
        int num2 = getCanteenCategoryDelivery(categories, 1, 5, 2);
        int sum2 = getCanteenCategorySum(categories, 1, 5, 2);
        map2.put("delivery1", num2);
        map2.put("local1", sum2 - num2);
        //获取林间小聚分类2--套饭系列
        num2 = getCanteenCategoryDelivery(categories, 2, 2, 2);
        sum2 = getCanteenCategorySum(categories, 2, 2, 2);
        map2.put("delivery2", num2);
        map2.put("local2", sum2 - num2);
        //获取林间小聚分类2--套饭系列
        num2 = getCanteenCategoryDelivery(categories, 3, 2, 2);
        sum2 = getCanteenCategorySum(categories, 3, 2, 2);
        map2.put("delivery3", num2);
        map2.put("local3", sum2 - num2);
        //获取二食堂煲仔蛋包饭--套饭系列
        num2 = getCanteenCategoryDelivery(categories, 4, 2, 2);
        sum2 = getCanteenCategorySum(categories, 4, 2, 2);
        map2.put("delivery4", num2);
        map2.put("local4", sum2 - num2);
        //获取二食堂你牛肉饭--套饭系列
        num2 = getCanteenCategoryDelivery(categories, 4, 3, 2);
        sum2 = getCanteenCategorySum(categories, 4, 3, 2);
        map2.put("delivery5", num2);
        map2.put("local5", sum2 - num2);
        //获取三期分类2--套饭系列
        num2 = getCanteenCategoryDelivery(categories, 5, 3, 2);
        sum2 = getCanteenCategorySum(categories, 5, 3, 2);
        map2.put("delivery6", num2);
        map2.put("local6", sum2 - num2);
        //获取红房子分类3--盖饭小炒
        int num3 = getCanteenCategoryDelivery(categories, 1, 3, 3);
        int sum3 = getCanteenCategorySum(categories, 1, 3, 3);
        map3.put("delivery1", num3);
        map3.put("local1", sum3 - num3);
        //获取红房子分类3--盖饭小炒
        num3 = getCanteenCategoryDelivery(categories, 1, 4, 3);
        sum3 = getCanteenCategorySum(categories, 1, 4, 3);
        map3.put("delivery2", num3);
        map3.put("local2", sum3 - num3);
        //获取林间小聚分类3--盖饭小炒
        num3 = getCanteenCategoryDelivery(categories, 2, 3, 3);
        sum3 = getCanteenCategorySum(categories, 2, 3, 3);
        map3.put("delivery3", num3);
        map3.put("local3", sum3 - num3);
        //获取一食堂分类3--盖饭小炒
        num3 = getCanteenCategoryDelivery(categories, 3, 5, 3);
        sum3 = getCanteenCategorySum(categories, 3, 5, 3);
        map3.put("delivery4", num3);
        map3.put("local4", sum3 - num3);
        //获取二食堂分类3--盖饭小炒
        num3 = getCanteenCategoryDelivery(categories, 4, 1, 3);
        sum3 = getCanteenCategorySum(categories, 4, 1, 3);
        map3.put("delivery5", num3);
        map3.put("local5", sum3 - num3);
        //获取红房子分类4--干锅
        int num4 = getCanteenCategoryDelivery(categories, 1, 2, 4);
        int sum4 = getCanteenCategorySum(categories, 1, 2, 4);
        map4.put("delivery1", num4);
        map4.put("local1", sum4 - num4);
        //获取林间小聚分类4--干锅
        num4 = getCanteenCategoryDelivery(categories, 2, 6, 4);
        sum4 = getCanteenCategorySum(categories, 2, 6, 4);
        map4.put("delivery2", num4);
        map4.put("local2", sum4 - num4);
        //获取一食堂分类4--干锅
        num4 = getCanteenCategoryDelivery(categories, 3, 3, 4);
        sum4 = getCanteenCategorySum(categories, 3, 3, 4);
        map4.put("delivery3", num4);
        map4.put("local3", sum4 - num4);
        //获取三期分类4--干锅
        num4 = getCanteenCategoryDelivery(categories, 5, 4, 4);
        sum4 = getCanteenCategorySum(categories, 5, 4, 4);
        map4.put("delivery4", num4);
        map4.put("local4", sum4 - num4);
        //获取红房子分类5--面食
        int num5 = getCanteenCategoryDelivery(categories, 1, 1, 5);
        int sum5 = getCanteenCategorySum(categories, 1, 1, 5);
        map5.put("delivery1", num5);
        map5.put("local1", sum5 - num5);
        //获取林间小聚分类5--面食
        num5 = getCanteenCategoryDelivery(categories, 2, 1, 5);
        sum5 = getCanteenCategorySum(categories, 2, 1, 5);
        map5.put("delivery2", num5);
        map5.put("local2", sum5 - num5);
        //获取林间小聚分类5--面食
        num5 = getCanteenCategoryDelivery(categories, 2, 4, 5);
        sum5 = getCanteenCategorySum(categories, 2, 4, 5);
        map5.put("delivery3", num5);
        map5.put("local3", sum5 - num5);
        //获取一食堂分类5--面食
        num5 = getCanteenCategoryDelivery(categories, 3, 1, 5);
        sum5 = getCanteenCategorySum(categories, 3, 1, 5);
        map5.put("delivery4", num5);
        map5.put("local4", sum5 - num5);
        //获取二食堂分类5--面食
        num5 = getCanteenCategoryDelivery(categories, 4, 5, 5);
        sum5 = getCanteenCategorySum(categories, 4, 5, 5);
        map5.put("delivery5", num5);
        map5.put("local5", sum5 - num5);
        //获取三期分类5--面食
        num5 = getCanteenCategoryDelivery(categories, 5, 2, 5);
        sum5 = getCanteenCategorySum(categories, 5, 2, 5);
        map5.put("delivery6", num5);
        map5.put("local6", sum5 - num5);
        //获取林间小聚分类6--小吃
        int num6 = getCanteenCategoryDelivery(categories, 2, 7, 6);
        int sum6 = getCanteenCategorySum(categories, 2, 7, 6);
        map6.put("delivery1", num6);
        map6.put("local1", sum6 - num6);
        //获取一食堂分类6--小吃
        num6 = getCanteenCategoryDelivery(categories, 3, 4, 6);
        sum6 = getCanteenCategorySum(categories, 3, 4, 6);
        map6.put("delivery2", num6);
        map6.put("local2", sum6 - num6);
        //获取二食堂分类6--小吃
        num6 = getCanteenCategoryDelivery(categories, 4, 6, 6);
        sum6 = getCanteenCategorySum(categories, 4, 6, 6);
        map6.put("delivery3", num6);
        map6.put("local3", sum6 - num6);
        //获取一食堂分类6--小吃
        num6 = getCanteenCategoryDelivery(categories, 5, 5, 6);
        sum6 = getCanteenCategorySum(categories, 5, 5, 6);
        map6.put("delivery4", num6);
        map6.put("local4", sum6 - num6);
        //分类总份数
        int deliverySum1 = getCategoryDelivery(categories, 1);
        int categorySum1 = getCategorySum(categories, 1);
        map7.put("deliverySum1", deliverySum1);
        map7.put("localSum1", categorySum1 - deliverySum1);
        deliverySum1 = getCategoryDelivery(categories, 2);
        categorySum1 = getCategorySum(categories, 2);
        map7.put("deliverySum2", deliverySum1);
        map7.put("localSum2", categorySum1 - deliverySum1);
        deliverySum1 = getCategoryDelivery(categories, 3);
        categorySum1 = getCategorySum(categories, 3);
        map7.put("deliverySum3", deliverySum1);
        map7.put("localSum3", categorySum1 - deliverySum1);
        deliverySum1 = getCategoryDelivery(categories, 4);
        categorySum1 = getCategorySum(categories, 4);
        map7.put("deliverySum4", deliverySum1);
        map7.put("localSum4", categorySum1 - deliverySum1);
        deliverySum1 = getCategoryDelivery(categories, 5);
        categorySum1 = getCategorySum(categories, 5);
        map7.put("deliverySum5", deliverySum1);
        map7.put("localSum5", categorySum1 - deliverySum1);
        deliverySum1 = getCategoryDelivery(categories, 6);
        categorySum1 = getCategorySum(categories, 6);
        map7.put("deliverySum6", deliverySum1);
        map7.put("localSum6", categorySum1 - deliverySum1);
        //拼接返回数据
        result.put(1, map1);
        result.put(2, map2);
        result.put(3, map3);
        result.put(4, map4);
        result.put(5, map5);
        result.put(6, map6);
        result.put(7, map7);

        return result;
    }

    public int getCanteenCategorySum(ArrayList<Consume> consumes, int canteen, int window, int category) {
        return consumes.parallelStream().filter(Consume -> Consume.getmCanteen() == canteen).
                filter(Consume -> Consume.getmWindow() == window).
                filter(Consume -> Consume.getmCategory() == category).
                mapToInt(Consume::getcNum).sum();
    }

    public int getCanteenCategoryDelivery(ArrayList<Consume> consumes, int canteen, int window, int category) {
        return consumes.parallelStream().filter(Consume -> Consume.getmCanteen() == canteen).
                filter(Consume -> Consume.getmWindow() == window).
                filter(Consume -> Consume.getmCategory() == category).
                mapToInt(Consume::getcDelivery).sum();
    }

    public int getCategoryDelivery(ArrayList<Consume> categories, int category) {
        return categories.parallelStream().filter(Consume -> Consume.getmCategory() == category).
                mapToInt(Consume::getcDelivery).sum();
    }

    public int getCategorySum(ArrayList<Consume> categories, int category) {
        return categories.parallelStream().filter(Consume -> Consume.getmCategory() == category).
                mapToInt(Consume::getcNum).sum();
    }

    public HashMap<Integer, HashMap<String, Object>> getCategoryMaleByDate(int date) {
        HashMap<Integer, HashMap<String, Object>> result = new HashMap<>();
        ArrayList<Consume> categories = consumeMapper.findCanteenAllByDate("(" + String.valueOf(date) + ")");
        //分类集合
        HashMap<String, Object> map1 = new HashMap<>();
        HashMap<String, Object> map2 = new HashMap<>();
        HashMap<String, Object> map3 = new HashMap<>();
        HashMap<String, Object> map4 = new HashMap<>();
        HashMap<String, Object> map5 = new HashMap<>();
        HashMap<String, Object> map6 = new HashMap<>();
        //分类份数总计
        HashMap<String, Object> map7 = new HashMap<>();
        //获取林间小聚分类1--早餐
        int num1 = getCanteenCategoryMale(categories, 2, 5, 1);
        int sum1 = getCanteenCategorySum(categories, 2, 5, 1);
        map1.put("male1", num1);
        map1.put("female1", sum1 - num1);
        //获取一食堂分类1--早餐
        num1 = getCanteenCategoryMale(categories, 3, 6, 1);
        sum1 = getCanteenCategorySum(categories, 3, 6, 1);
        map1.put("male2", num1);
        map1.put("female2", sum1 - num1);
        //获取二食堂分类1--早餐
        num1 = getCanteenCategoryMale(categories, 4, 4, 1);
        sum1 = getCanteenCategorySum(categories, 4, 4, 1);
        map1.put("male3", num1);
        map1.put("female3", sum1 - num1);
        //获取二食堂分类1--早餐
        num1 = getCanteenCategoryMale(categories, 4, 7, 1);
        sum1 = getCanteenCategorySum(categories, 4, 7, 1);
        map1.put("male4", num1);
        map1.put("female4", sum1 - num1);
        //获取三期分类1--早餐
        num1 = getCanteenCategoryMale(categories, 5, 1, 1);
        sum1 = getCanteenCategorySum(categories, 5, 1, 1);
        map1.put("male5", num1);
        map1.put("female5", sum1 - num1);
        //获取红房子分类2--套饭系列
        int num2 = getCanteenCategoryMale(categories, 1, 5, 2);
        int sum2 = getCanteenCategorySum(categories, 1, 5, 2);
        map2.put("male1", num2);
        map2.put("female1", sum2 - num2);
        //获取林间小聚分类2--套饭系列
        num2 = getCanteenCategoryMale(categories, 2, 2, 2);
        sum2 = getCanteenCategorySum(categories, 2, 2, 2);
        map2.put("male2", num2);
        map2.put("female2", sum2 - num2);
        //获取林间小聚分类2--套饭系列
        num2 = getCanteenCategoryMale(categories, 3, 2, 2);
        sum2 = getCanteenCategorySum(categories, 3, 2, 2);
        map2.put("male3", num2);
        map2.put("female3", sum2 - num2);
        //获取二食堂煲仔蛋包饭--套饭系列
        num2 = getCanteenCategoryMale(categories, 4, 2, 2);
        sum2 = getCanteenCategorySum(categories, 4, 2, 2);
        map2.put("male4", num2);
        map2.put("female4", sum2 - num2);
        //获取二食堂你牛肉饭--套饭系列
        num2 = getCanteenCategoryMale(categories, 4, 3, 2);
        sum2 = getCanteenCategorySum(categories, 4, 3, 2);
        map2.put("male5", num2);
        map2.put("female5", sum2 - num2);
        //获取三期分类2--套饭系列
        num2 = getCanteenCategoryMale(categories, 5, 3, 2);
        sum2 = getCanteenCategorySum(categories, 5, 3, 2);
        map2.put("male6", num2);
        map2.put("female6", sum2 - num2);
        //获取红房子分类3--盖饭小炒
        int num3 = getCanteenCategoryMale(categories, 1, 3, 3);
        int sum3 = getCanteenCategorySum(categories, 1, 3, 3);
        map3.put("male1", num3);
        map3.put("female1", sum3 - num3);
        //获取红房子分类3--盖饭小炒
        num3 = getCanteenCategoryMale(categories, 1, 4, 3);
        sum3 = getCanteenCategorySum(categories, 1, 4, 3);
        map3.put("male2", num3);
        map3.put("female2", sum3 - num3);
        //获取林间小聚分类3--盖饭小炒
        num3 = getCanteenCategoryMale(categories, 2, 3, 3);
        sum3 = getCanteenCategorySum(categories, 2, 3, 3);
        map3.put("male3", num3);
        map3.put("female3", sum3 - num3);
        //获取一食堂分类3--盖饭小炒
        num3 = getCanteenCategoryMale(categories, 3, 5, 3);
        sum3 = getCanteenCategorySum(categories, 3, 5, 3);
        map3.put("male4", num3);
        map3.put("female4", sum3 - num3);
        //获取二食堂分类3--盖饭小炒
        num3 = getCanteenCategoryMale(categories, 4, 1, 3);
        sum3 = getCanteenCategorySum(categories, 4, 1, 3);
        map3.put("male5", num3);
        map3.put("female5", sum3 - num3);
        //获取红房子分类4--干锅
        int num4 = getCanteenCategoryMale(categories, 1, 2, 4);
        int sum4 = getCanteenCategorySum(categories, 1, 2, 4);
        map4.put("male1", num4);
        map4.put("female1", sum4 - num4);
        //获取林间小聚分类4--干锅
        num4 = getCanteenCategoryMale(categories, 2, 6, 4);
        sum4 = getCanteenCategorySum(categories, 2, 6, 4);
        map4.put("male2", num4);
        map4.put("female2", sum4 - num4);
        //获取一食堂分类4--干锅
        num4 = getCanteenCategoryMale(categories, 3, 3, 4);
        sum4 = getCanteenCategorySum(categories, 3, 3, 4);
        map4.put("male3", num4);
        map4.put("female3", sum4 - num4);
        //获取三期分类4--干锅
        num4 = getCanteenCategoryMale(categories, 5, 4, 4);
        sum4 = getCanteenCategorySum(categories, 5, 4, 4);
        map4.put("male4", num4);
        map4.put("female4", sum4 - num4);
        //获取红房子分类5--面食
        int num5 = getCanteenCategoryMale(categories, 1, 1, 5);
        int sum5 = getCanteenCategorySum(categories, 1, 1, 5);
        map5.put("male1", num5);
        map5.put("female1", sum5 - num5);
        //获取林间小聚分类5--面食
        num5 = getCanteenCategoryMale(categories, 2, 1, 5);
        sum5 = getCanteenCategorySum(categories, 2, 1, 5);
        map5.put("male2", num5);
        map5.put("female2", sum5 - num5);
        //获取林间小聚分类5--面食
        num5 = getCanteenCategoryMale(categories, 2, 4, 5);
        sum5 = getCanteenCategorySum(categories, 2, 4, 5);
        map5.put("male3", num5);
        map5.put("female3", sum5 - num5);
        //获取一食堂分类5--面食
        num5 = getCanteenCategoryMale(categories, 3, 1, 5);
        sum5 = getCanteenCategorySum(categories, 3, 1, 5);
        map5.put("male4", num5);
        map5.put("female4", sum5 - num5);
        //获取二食堂分类5--面食
        num5 = getCanteenCategoryMale(categories, 4, 5, 5);
        sum5 = getCanteenCategorySum(categories, 4, 5, 5);
        map5.put("male5", num5);
        map5.put("female5", sum5 - num5);
        //获取三期分类5--面食
        num5 = getCanteenCategoryMale(categories, 5, 2, 5);
        sum5 = getCanteenCategorySum(categories, 5, 2, 5);
        map5.put("male6", num5);
        map5.put("female6", sum5 - num5);
        //获取林间小聚分类6--小吃
        int num6 = getCanteenCategoryMale(categories, 2, 7, 6);
        int sum6 = getCanteenCategorySum(categories, 2, 7, 6);
        map6.put("male1", num6);
        map6.put("female1", sum6 - num6);
        //获取一食堂分类6--小吃
        num6 = getCanteenCategoryMale(categories, 3, 4, 6);
        sum6 = getCanteenCategorySum(categories, 3, 4, 6);
        map6.put("male2", num6);
        map6.put("female2", sum6 - num6);
        //获取二食堂分类6--小吃
        num6 = getCanteenCategoryMale(categories, 4, 6, 6);
        sum6 = getCanteenCategorySum(categories, 4, 6, 6);
        map6.put("male3", num6);
        map6.put("female3", sum6 - num6);
        //获取一食堂分类6--小吃
        num6 = getCanteenCategoryMale(categories, 5, 5, 6);
        sum6 = getCanteenCategorySum(categories, 5, 5, 6);
        map6.put("male4", num6);
        map6.put("female4", sum6 - num6);
        //分类总份数
        int deliverySum1 = getCategoryMale(categories, 1);
        int categorySum1 = getCategorySum(categories, 1);
        map7.put("maleSum1", deliverySum1);
        map7.put("femaleSum1", categorySum1 - deliverySum1);
        deliverySum1 = getCategoryMale(categories, 2);
        categorySum1 = getCategorySum(categories, 2);
        map7.put("maleSum2", deliverySum1);
        map7.put("femaleSum2", categorySum1 - deliverySum1);
        deliverySum1 = getCategoryMale(categories, 3);
        categorySum1 = getCategorySum(categories, 3);
        map7.put("maleSum3", deliverySum1);
        map7.put("femaleSum3", categorySum1 - deliverySum1);
        deliverySum1 = getCategoryMale(categories, 4);
        categorySum1 = getCategorySum(categories, 4);
        map7.put("maleSum4", deliverySum1);
        map7.put("femaleSum4", categorySum1 - deliverySum1);
        deliverySum1 = getCategoryMale(categories, 5);
        categorySum1 = getCategorySum(categories, 5);
        map7.put("maleSum5", deliverySum1);
        map7.put("femaleSum5", categorySum1 - deliverySum1);
        deliverySum1 = getCategoryMale(categories, 6);
        categorySum1 = getCategorySum(categories, 6);
        map7.put("maleSum6", deliverySum1);
        map7.put("femaleSum6", categorySum1 - deliverySum1);
        //拼接返回数据
        result.put(1, map1);
        result.put(2, map2);
        result.put(3, map3);
        result.put(4, map4);
        result.put(5, map5);
        result.put(6, map6);
        result.put(7, map7);

        return result;
    }

    public int getCanteenCategoryMale(ArrayList<Consume> consumes, int canteen, int window, int category) {
        return consumes.parallelStream().filter(Consume -> Consume.getmCanteen() == canteen).
                filter(Consume -> Consume.getmWindow() == window).
                filter(Consume -> Consume.getmCategory() == category).
                mapToInt(Consume::getcMale).sum();
    }

    public int getCategoryMale(ArrayList<Consume> categories, int category) {
        return categories.parallelStream().filter(Consume -> Consume.getmCategory() == category).
                mapToInt(Consume::getcMale).sum();
    }


}

