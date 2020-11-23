package com.lin.canteen.service;

import com.lin.canteen.bean.User;
import com.lin.canteen.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public int insertUser(User user){
        //查询用户名是否存在
        ArrayList<User> userCheck = userMapper.checkUser(user.getUserName());
        if (userCheck.size() != 0){
            return 0;
        }else {
            return userMapper.insertUser(user);
        }
    }

    public int selectUser(String username,String password){
        ArrayList<User> userCheck=userMapper.selectUser(username,password);
        if (userCheck.size()==0){
            return 0;
        }else{
            return 1;
        }
    }
}
