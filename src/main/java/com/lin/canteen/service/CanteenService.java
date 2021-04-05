package com.lin.canteen.service;

import com.lin.canteen.bean.Window;
import com.lin.canteen.mapper.ConsumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CanteenService {

    @Autowired
    ConsumeMapper consumeMapper;
    //窗口id
    private int[] windowTag={1,2,3,4,5,6,7};

    /**
     * 返回各食堂各窗口某天消费额
     */
    public HashMap<Integer,HashMap<Integer,Double>> getWindowSumByDate(int date,int num,int canteen){
        //返回数据集合
        HashMap<Integer,HashMap<Integer,Double>> map=new HashMap<>();
        //七天
        for(int i=0;i<7;i++){
            ArrayList<Window> window = consumeMapper.findCanteenByWindow(date);
            HashMap<Integer,Double> hfz=new HashMap<>();
            //计算canteen食堂各窗口num的该天消费额
            for(int j=1;j<num;j++){
                int t=j-1;
                double sum=window.parallelStream().filter(Window->Window.getmCanteen()==canteen)
                        .filter(Window->Window.getmWindow()==windowTag[t])
                        .mapToDouble(Window::getmSum).sum();
                sum=new BigDecimal(sum).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                hfz.put(j,sum);
                //该天所有数据
                map.put(date,hfz);
            }
            //计算前一天
            date=date-86400;
        }
        return map;
    }
}

