package com.litao.springclouddemo.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfig {
    /**
     * restTemplate发送请求
     * LoadBalanced 注解可以负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 指定负载均衡算法
     * @return
     */
    @Bean
    public IRule iRule(){
        /** 轮询方式选取一个服务，进行访问 **/
        return  new RoundRobinRule();
        /** 随机选取一个服务，进行访问 **/
       //return  new  RandomRule();
        /** 如果一个服务挂了，会尝试几次访问，如果几次访问失败后，下次就跳过失败的服务。 **/
           //     RetryRule
        /** 当高并发时，会选中最空闲当服务 **/
          //              BestAvailableRule
        /** 按照权重访问 **/
          //      WeightedResponseTimeRule
        /** 先过滤清单再轮训 **/
         //               PredicateBasedRule
    }


}
