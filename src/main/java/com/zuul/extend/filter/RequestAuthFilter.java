package com.zuul.extend.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_ERROR_FILTER_ORDER;

/**
 * @author yilong2001
 */
public class RequestAuthFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestAuthFilter.class);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SEND_ERROR_FILTER_ORDER + 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        if (true) {
            RequestContext ctx = RequestContext.getCurrentContext();
            setSuccess(ctx);
            return null;
        }
        return null;
    }

    private void setSuccess(RequestContext ctx) {
        LOGGER.info("Authentication success !");
        ctx.setSendZuulResponse(true);
        ctx.setResponseStatusCode(200);
    }
}
