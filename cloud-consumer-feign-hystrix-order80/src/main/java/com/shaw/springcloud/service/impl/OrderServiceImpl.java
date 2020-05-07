package com.shaw.springcloud.service.impl;

import com.shaw.springcloud.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public String paymentInfoOK(Integer id) {
        return "---------------- OK";
    }

    @Override
    public String paymentError() {
        return "---------------error";
    }
}
