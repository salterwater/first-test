package com.example.dao;

import com.example.beans.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Author: MingKing
 * @DayNameFull: 星期三
 * @Date: Create in 14:36 2020/7/8
 */
@Component
public interface Test_dao {

    @Select("select * from users where id=#{id}")
    User getUser(int id);
}
