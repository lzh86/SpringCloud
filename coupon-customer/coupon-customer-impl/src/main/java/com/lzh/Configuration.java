package com.lzh;

import com.lzh.loadbalance.CanaryRuleConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

// Configuration注解用于定义配置类
// 类中定义的Bean方法会被AnnotationConfigApplicationContext和AnnotationConfigWebApplicationContext扫描并初始化
@org.springframework.context.annotation.Configuration
@LoadBalancerClients(defaultConfiguration = {CanaryRuleConfiguration.class})
public class Configuration {

    @Bean
    @LoadBalanced
    public WebClient.Builder register() {
        return WebClient.builder();
    }

}
