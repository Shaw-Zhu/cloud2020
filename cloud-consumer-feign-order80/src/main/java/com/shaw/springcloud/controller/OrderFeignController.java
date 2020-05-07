package com.shaw.springcloud.controller;

import com.shaw.springcloud.entity.CommonResult;
import com.shaw.springcloud.entity.Payment;
import com.shaw.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) throws InterruptedException {
        CommonResult commonResult = paymentFeignService.getPaymentById(id);
        if (commonResult == null) {
            int age = 40;
            return new CommonResult(200, "查询数据失败,serverPort:" + serverPort);
        } else {
            return new CommonResult(200, "查询数据成功,serverPort:" + serverPort, commonResult);
        }
    }
}
