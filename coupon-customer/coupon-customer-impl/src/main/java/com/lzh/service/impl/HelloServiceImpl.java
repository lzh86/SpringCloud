package com.lzh.service.impl;

import com.lzh.fegin.CalculationService;
import com.lzh.fegin.HelloBackService;
import com.lzh.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Service
@Slf4j
public class HelloServiceImpl implements HelloService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Resource
    private CalculationService calculationService;

    @Resource
    private HelloBackService helloBackService;

    /**
     * httpHello
     *
     * @return
     */
    @Override
    public String httpHello() {
        String result = null;
        Mono<String> mono = webClientBuilder.build().get().uri("http://coupon-calculation/calculator/httpHello")
                .retrieve() // 获取响应体
                .bodyToMono(String.class);//响应数据类型转换
         //result = blockResult.block();
        mono.subscribe(HelloServiceImpl::handleResponse);
        log.info("返回结果是:{},我已经提前输出",result);

//        try {
//            String url = "http://coupon-calculation/calculator/httpHello";
//            result = null;
//            CloseableHttpResponse response = null;
//            CloseableHttpClient httpclient = HttpClients.createDefault();
//
//            URIBuilder builder = new URIBuilder(url);
//            URI uri = builder.build();
//            // 创建http GET请求
//            HttpGet httpGet = new HttpGet(uri);
//            // 执行请求
//            response = httpclient.execute(httpGet);
//            if (response.getStatusLine().getStatusCode() == 200) {
//                result = EntityUtils.toString(response.getEntity(), "UTF-8");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return result;
    }

    /**
     * feginHello
     *
     * @return
     */
    @Override
    public String feginHello() {
        return helloBackService.feginHello();
    }

    private static void handleResponse(String result){
        log.info("异步非阻塞输出结果:{}",result);
    }
}
