package com.lzh.fegin.fallback;

import com.lzh.beans.ShoppingCart;
import com.lzh.beans.SimulationOrder;
import com.lzh.beans.SimulationResponse;
import com.lzh.fegin.CalculationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CalculationServiceFallback implements CalculationService {
    @Override
    public ShoppingCart checkout(ShoppingCart settlement) {
        log.info("fallback checkout");
        return null;
    }

    @Override
    public SimulationResponse simulate(SimulationOrder simulator) {
        log.info("fallback simulate");
        return null;
    }
}
