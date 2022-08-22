package com.lzh.fegin;


import com.lzh.fegin.fallback.HelloBackServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "coupon-calculation", path = "/calculator",fallback = HelloBackServiceFallback.class)
public interface HelloBackService {

    @GetMapping("/feginHello")
    String feginHello();
}
