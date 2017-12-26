package com.zuul.extend.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_RESPONSE_FILTER_ORDER;

public class ResponseAppendFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseAppendFilter.class);

    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpServletResponse response = context.getResponse();
        context.getResponseStatusCode();

        if (true) {
            //TODO: (1)如果这里抛出异常，或者目标服务抛出异常
            throw new RuntimeException("for zuul crash demo");
        }

        Throwable throwable = context.getThrowable();

        if (throwable != null){
            String results = "{'result' : '" + throwable.getMessage() + "'}";
            context.setResponseBody(results);
        }
        return null;
    }
}
