package com.example.controlor;

import com.example.beans.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Saltwater
 * @DayNameFull: 星期二
 * @Date: Create in 15:37 2020/7/14
 */
@FeignClient("user-service")
@Component
public interface UserClient {

    @GetMapping("/getUser/{id}")
    User consumer(@PathVariable int id);

}
