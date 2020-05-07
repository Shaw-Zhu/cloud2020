package com.shaw.springcloud.controller;

import com.shaw.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    public PaymentService PaymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id) {
        String infoOK = PaymentService.paymentInfoOK(id);
        return "ServerPort:" + serverPort + "," + infoOK;
    }

    @GetMapping(value = "/error")
    public String paymentError() {

        String error = PaymentService.paymentError();
        log.info(error);
        return "ServerPort:" + serverPort + "," + error;
    }

    @GetMapping(value = "/breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        return PaymentService.paymentCircuitBreaker(id);
    }
}
