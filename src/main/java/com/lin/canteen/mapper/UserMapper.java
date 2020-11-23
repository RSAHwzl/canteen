package com.lin.canteen.mapper;

import com.lin.canteen.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserMapper {

    @Insert("insert into user(userName,passWord,email,birthday,address) " +
            "values(#{userName},#{passWord},#{email},#{birthday},#{address}) ")
    int insertUser(User user);

    @Select("select * from user where userName=#{username} and passWord=#{password}")
    ArrayList<User> selectUser(String username,String password);

    @Select("select * from user where userName=#{username}")
    ArrayList<User> checkUser(String username);
}
