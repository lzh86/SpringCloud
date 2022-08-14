package com.lzh;

import com.lzh.loadbalance.CanaryRuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaAuditing
//@ComponentScan(basePackages = {"com.lzh"})
@EnableTransactionManagement
//用于扫描Dao @Repository
@EnableJpaRepositories(basePackages = {"com.lzh"})
//用于扫描JPA实体类 @Entity，默认扫本包当下路径
@EntityScan(basePackages = {"com.lzh"})
@EnableDiscoveryClient
@LoadBalancerClient(value = "coupon-template", configuration = CanaryRuleConfiguration.class)
public class CouponCustomerApplication {


    public static void main(String[] args) {
        SpringApplication.run(CouponCustomerApplication.class, args);
    }


}
