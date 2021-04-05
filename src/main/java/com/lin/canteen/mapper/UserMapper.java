package com.lin.canteen.mapper;

import com.lin.canteen.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserMapper {

    @Insert("insert into user(userName,passWord,email,birthday,address,auth) " +
            "values(#{userName},#{passWord},#{email},#{birthday},#{address},#{auth}) ")
    int insertUser(User user);

    @Select("select * from user where auth=#{auth} and userName=#{username} and passWord=#{password}")
    ArrayList<User> selectUser(String username,String password,int auth);

    @Select("select * from user where auth=#{auth} and userName=#{username}")
    ArrayList<User> checkUser(String username,int auth);
}
