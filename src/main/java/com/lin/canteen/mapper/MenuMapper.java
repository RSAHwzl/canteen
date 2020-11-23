package com.lin.canteen.mapper;

import com.lin.canteen.bean.Menu;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MenuMapper {

    @Select("select * from menu where mId= #{mId}")
    ArrayList<Menu> findMenuByMid(int mId);

    @Select("select mId from menu where mId= #{mId}")
    ArrayList<Menu> findMId(int mId);
}
