package com.lin.canteen.mapper;

import com.lin.canteen.bean.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ConsumeMapper {

    //查询所有食堂某天消费情况
    @Select("select * from consume a left join menu b on a.mId=b.mId where a.cDate=#{date}")
    ArrayList<Canteen> findCanteenByDate(int date);

    //查询所有食堂某天消费情况
    @Select("select * from consume a left join menu b on a.mId=b.mId where a.cDate in ${dates}")
    ArrayList<Consume> findCanteenAllByDate(String dates);

    //查询各食堂各窗口某天消费情况
    @Results(value = {
            @Result(id = true, property = "mId", column = "mId"),
            @Result(property = "cNum", column = "cNum"),
            @Result(property = "cDate", column = "cDate"),
            @Result(property = "menu", column = "mId", one = @One(select = "com.lin.canteen.mapper.MenuMapper.findMenuByMid"))
    })
    @Select("select cNum,b.mName,b.mPrice,b.mCanteen,b.mWindow from consume a " +
            "left join menu b on a.mId=b.mId where a.cDate=#{date}")
    ArrayList<Window> findCanteenByWindow(int date);

    //查询各窗口销量前十数据
    @Results(value = {
            @Result(id = true, property = "mId", column = "mId"),
            @Result(property = "cNum", column = "cNum"),
            @Result(property = "cDate", column = "cDate"),
            @Result(property = "mId", column = "mId",
                    one = @One(select = "com.lin.canteen.mapper.MenuMapper.findMenuByMid"))
    })
    @Select("select cNum,b.mName from consume a " +
            "left join menu b on a.mId=b.mId " +
            "where a.cDate=#{date} and b.mCanteen=#{canteen} and mWindow=#{window} " +
            "order by cNum desc limit 10")
    ArrayList<Food> findWindowHotByDate(int date, int canteen, int window);

    //查询具体菜某天销售情况
    @Results(value = {
            @Result(id = true, property = "mId", column = "mId"),
            @Result(property = "cNum", column = "cNum"),
            @Result(property = "cDate", column = "cDate"),
            @Result(property = "mId", column = "mId",
                    one = @One(select = "com.lin.canteen.mapper.MenuMapper.findMenuByMid"))
    })
    @Select("select a.cNum,b.mName from consume a " +
            "left join menu b on a.mId=b.mId " +
            "where a.cDate=#{date} and b.mCanteen=#{canteen} and b.mWindow=#{window}")
    ArrayList<Food> findFoodHotByDate(int date, int canteen, int window);

    //查询分类情况
    @Results(value = {
            @Result(id = true, property = "mId", column = "mId"),
            @Result(property = "cNum", column = "cNum"),
            @Result(property = "menu", column = "mId", one = @One(select = "com.lin.canteen.mapper.MenuMapper.findMenuByMid"))
    })
    @Select("select cNum,b.mPrice,b.mCanteen,b.mWindow,b.mCategory from consume a " +
            "left join menu b on a.mId=b.mId where a.cDate=#{date}")
    ArrayList<Category> findCategoryByDate(int date);
}
