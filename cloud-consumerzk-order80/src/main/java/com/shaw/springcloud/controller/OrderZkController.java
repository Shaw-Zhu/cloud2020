package com.shaw.springcloud.controller;

import com.shaw.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderZkController {

    public static final String INVOKER_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public CommonResult getPayment(){
        String result = restTemplate.getForObject(INVOKER_URL+"/payment/zk", String.class);
        return new CommonResult(200, "调用成功", result);
    }

}
