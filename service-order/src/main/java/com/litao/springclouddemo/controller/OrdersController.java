package com.litao.springclouddemo.controller;


import com.litao.springclouddemo.feign.UserFeignClient;
import com.litao.springclouddemo.entity.Orders;
import com.litao.springclouddemo.entity.User;
import com.litao.springclouddemo.service.OrdersService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order/")
@Slf4j
public class OrdersController {

    @Autowired
    private OrdersService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    /**
     * 根据Id查询订单
     * @param id
     * @return
     */
    @RequestMapping("getOrderById")
    @HystrixCommand(fallbackMethod = "getUserByIdFallbackMethod")
    public Orders getOrderById(@RequestParam("id") Integer id){
        Orders order = orderService.getOrderById(id);
        //service-user是被调用服务名称，spring.application.name的名称
        //User user = restTemplate.getForObject("http://service-user/user/getUserById?id="+order.getUserId(), User.class);
        // User user = userFeignClient.getUserById(id);
        User userParam = new User();
        userParam.setId(1);
        User user = userFeignClient.getUserByUser(userParam);
        log.info("user:{}",user);
        order.setUsername(user.getUsername());
        return order;
    }

    public Orders getUserByIdFallbackMethod(Integer id){
        Orders order = orderService.getOrderById(id);
        //service-user是被调用服务名称，spring.application.name的名称
        //User user = restTemplate.getForObject("http://service-user/user/getUserById?id="+order.getUserId(), User.class);
        // User user = userFeignClient.getUserById(id);
        User userParam = new User();
        userParam.setId(1);
        User user = userFeignClient.getUserByUser(userParam);
        log.info("user:{}",user);
        order.setUsername(user.getUsername());
        return order;
    }

}
