package com.example.controlor;

import com.example.beans.User;
import com.example.service.Test_srvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: MingKing
 * @DayNameFull: 星期三
 * @Date: Create in 14:36 2020/7/8
 */
@RestController
public class Test_controlor {
    @Autowired
    private Test_srvice service;

    @RequestMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") int id){


        User user = service.getUser(id);
        System.out.println(user);
        System.out.println("我是服务2");


        return user;

    }

}
