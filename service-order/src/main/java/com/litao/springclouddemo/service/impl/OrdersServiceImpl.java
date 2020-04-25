package com.litao.springclouddemo.service.impl;

import com.litao.springclouddemo.entity.Orders;
import com.litao.springclouddemo.mapper.OrdersMapper;
import com.litao.springclouddemo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {


    @Autowired
    OrdersMapper orderMapper;

    @Override
    public Orders getOrderById(Integer id) {
        return orderMapper.getOrderById(id);
    }
}
