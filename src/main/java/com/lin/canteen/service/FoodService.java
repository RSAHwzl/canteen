package com.lin.canteen.service;

import com.lin.canteen.bean.Food;
import com.lin.canteen.mapper.ConsumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class FoodService {
    @Autowired
    ConsumeMapper consumeMapper;

    //获取某食堂某窗口销量前十菜品
    public ArrayList<Food> getHotFoodByDate(int date, int canteen, int window){
        return consumeMapper.findWindowHotByDate(date,canteen,window);
    }

    //获取某食堂具体菜品销售量
    public HashMap<Integer,HashMap<String,Integer>> getHotFoodByWeek(int date,int canteen,int window,String[] names){
        HashMap<Integer,HashMap<String,Integer>> result = new HashMap<>();
        for(int i=0;i<7;i++){
            HashMap<String,Integer> food=new HashMap<>();
            ArrayList<Food> foods=new ArrayList<>();
            foods=consumeMapper.findFoodHotByDate(date,canteen,window);
            int sum1 = foods.stream().filter(Food -> Food.getmName().equals(names[0])).
                    mapToInt(Food::getcNum).sum();
            int sum2 = foods.stream().filter(Food -> Food.getmName().equals(names[1])).
                    mapToInt(Food::getcNum).sum();
            int sum3 = foods.stream().filter(Food -> Food.getmName().equals(names[2])).
                    mapToInt(Food::getcNum).sum();
            food.put(names[0],sum1);
            food.put(names[1],sum2);
            food.put(names[2],sum3);
            result.put(date,food);
            //计算前一天
            date=date-86400;
        }
        return result;
    }

}
