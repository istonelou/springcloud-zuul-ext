package com.zuul.extend.server;

import com.netflix.zuul.http.ZuulServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.zuul.ZuulServerAutoConfiguration;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by yilong on 2017/12/25.
 */
@Configuration
@EnableConfigurationProperties({ ZuulProperties.class })
@ConditionalOnClass(ZuulServlet.class)
@ConditionalOnBean(ExtZuulProxyMarkerConfiguration.Marker.class)
// Make sure to get the ServerProperties from the same place as a normal web app would
@Import(ServerPropertiesAutoConfiguration.class)
public class ExtZuulServerAutoConfiguration extends ZuulServerAutoConfiguration {
    @Bean
    public ExtSendErrorFilter sendErrorFilter() {
        return new ExtSendErrorFilter();
    }
}
