package com.shaw.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.shaw.springcloud.service.impl.OrderServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = OrderServiceImpl.class)
public interface OrderService {

    @GetMapping(value = "/payment/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/error")
    public String paymentError();
}
