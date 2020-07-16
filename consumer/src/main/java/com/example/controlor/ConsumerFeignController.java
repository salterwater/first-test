package com.example.controlor;

import com.example.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Saltwater
 * @DayNameFull: 星期二
 * @Date: Create in 15:46 2020/7/14
 */
@RestController
public class ConsumerFeignController {


    @Autowired
    private UserClient userClient;


    @RequestMapping(value = "/test/{id}",method = RequestMethod.GET)
    public User consumer(@PathVariable int id){

        User u = userClient.consumer(id);

        System.out.println(u);

        return u;
    }

}
