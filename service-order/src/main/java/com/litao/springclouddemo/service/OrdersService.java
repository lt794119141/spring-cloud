package com.litao.springclouddemo.service;


import com.litao.springclouddemo.entity.Orders;


public interface OrdersService {
    /**
     * 根据Id，查询order
     * @param id
     * @return
     */
    public Orders getOrderById(Integer id);
}
