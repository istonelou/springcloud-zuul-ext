package com.zuul.extend.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yilong on 2017/12/25.
 */
@Configuration
public class ExtZuulProxyMarkerConfiguration {
    @Bean
    public ExtZuulProxyMarkerConfiguration.Marker zuulServerMarkerBean() {
        return new ExtZuulProxyMarkerConfiguration.Marker();
    }

    class Marker {
    }
}
