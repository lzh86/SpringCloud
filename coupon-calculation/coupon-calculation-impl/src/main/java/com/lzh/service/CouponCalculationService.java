package com.lzh.service;


import com.lzh.beans.ShoppingCart;
import com.lzh.beans.SimulationOrder;
import com.lzh.beans.SimulationResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface CouponCalculationService {

    ShoppingCart calculateOrderPrice(@RequestBody ShoppingCart cart);

    SimulationResponse simulateOrder(@RequestBody SimulationOrder cart);
}
