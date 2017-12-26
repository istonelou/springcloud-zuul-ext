package com.zuul.extend;

import com.zuul.extend.filter.RequestAuthFilter;
import com.zuul.extend.filter.ResponseAppendFilter;
import com.zuul.extend.server.ExtEnableZuulProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author yilong2001
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
@EnableFeignClients
@ExtEnableZuulProxy
public class ExtendGatewayApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExtendGatewayApplication.class);

    @Bean
    public RequestAuthFilter authorizationFilter(){
        return new RequestAuthFilter();
    }

    @Bean
    public ResponseAppendFilter resultFilter() {
        return new ResponseAppendFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(ExtendGatewayApplication.class, args);
    }

}
