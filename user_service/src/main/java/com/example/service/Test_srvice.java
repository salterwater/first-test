package com.example.service;

import com.example.beans.User;
import com.example.dao.Test_dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: MingKing
 * @DayNameFull: 星期三
 * @Date: Create in 14:36 2020/7/8
 */
@Service
public class Test_srvice {

    @Autowired
    private Test_dao dao;


    public User getUser(int id) {

        return dao.getUser(id);

    }
}
