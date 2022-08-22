package com.lzh.fegin.fallback;

import com.lzh.fegin.HelloBackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloBackServiceFallback implements HelloBackService {

    @Override
    public String feginHello() {
        log.info("fallback feginHello");
        return "fallback feginHello";
    }
}
