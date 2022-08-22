package com.lzh.controller;

import com.alibaba.fastjson.JSON;

import com.lzh.beans.ShoppingCart;
import com.lzh.beans.SimulationOrder;
import com.lzh.beans.SimulationResponse;
import com.lzh.service.CouponCalculationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/calculator")
public class CouponCalculationController {

    @Autowired
    private CouponCalculationService calculationService;

    // 优惠券结算
    @PostMapping("/checkout")
    @ResponseBody
    public ShoppingCart calculateOrderPrice(@RequestBody ShoppingCart settlement) {
        log.info("do calculation: {}", JSON.toJSONString(settlement));
        return calculationService.calculateOrderPrice(settlement);
    }

    // 优惠券列表挨个试算
    // 给客户提示每个可用券的优惠额度，帮助挑选
    @PostMapping("/simulate")
    @ResponseBody
    public SimulationResponse simulate(@RequestBody SimulationOrder simulator) {
        log.info("do simulation: {}", JSON.toJSONString(simulator));
        return calculationService.simulateOrder(simulator);
    }

    /**
     * 模拟http请求
     * @return
     */
    @GetMapping("/httpHello")
    public String httpHello() {
        log.info("http 请求: {}", LocalDateTime.now());
        return "httpHello";
    }

    /**
     * 模拟fegin请求
     * @return
     */
    @GetMapping("/feginHello")
    public String feginHello() {
        log.info("fegin 请求: {}", LocalDateTime.now());
        return "feginHello";
    }
}
