package com.shaw.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.shaw.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping(value = "/consumer/payment/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id){
        return orderService.paymentInfoOK(id);
    }

    @GetMapping(value = "/consumer/payment/error")
    public String paymentError(){
        return orderService.paymentError();
    }

}
