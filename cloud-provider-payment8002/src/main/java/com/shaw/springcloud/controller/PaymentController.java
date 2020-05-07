package com.shaw.springcloud.controller;

import com.shaw.springcloud.entity.CommonResult;
import com.shaw.springcloud.entity.Payment;
import com.shaw.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入数据" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功,serverPort:" + serverPort, result);
        } else {
            return new CommonResult(200, "插入数据失败,serverPort:" + serverPort);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) throws InterruptedException {


//        Thread.sleep(5000);

//        Payment payment = paymentService.getPaymentById(id);
//        if (payment == null) {
//            int age = 40;
//            return new CommonResult(200, "查询数据失败,serverPort:" + serverPort);
//        } else {
            return new CommonResult(200, "查询数据成功,serverPort:" + serverPort);
//        }
    }
}
