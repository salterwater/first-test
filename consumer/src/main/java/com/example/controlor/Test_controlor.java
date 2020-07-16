package com.example.controlor;

import com.example.beans.User;
import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @Author: MingKing
 * @DayNameFull: 星期三
 * @Date: Create in 15:07 2020/7/8
 */
@RestController
@DefaultProperties(defaultFallback = "defaltfallback")
public class Test_controlor {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;


    @RequestMapping(value = "/consumer/{id}",method = RequestMethod.GET)
    @HystrixCommand
    public String consumer(@PathVariable int id){


        if(id==6){
            throw new RuntimeException("太忙了呀");
        }


        //通过服务的消费者，调用服务的提供者

        String url="http://user-service/getUser/"+id;

        User u = restTemplate.getForObject(url, User.class);

        Gson gson = new Gson();
        String g = gson.toJson(u);

        //获取eureka中注册的user-service实例列表
//        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("user-service");
//
//        ServiceInstance serviceInstance = serviceInstanceList.get(0);
//
//        url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/getUser/"+id;


        return  g;

    }

    //编写降级逻辑的方法,判定请求失败的时候，马上给用户反馈失败信息
    public String queryByIdFallback(int id){

        String msg = "不好意思，网络拥挤";

        return msg;
    }

    //专门写一个默认的降级逻辑
    public String defaltfallback(){


        return "默认的降级逻辑，对不起";
    }
}
