package com.prakash.reactive.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleFilter extends ZuulFilter {@Override
	public Object run() throws ZuulException {
		log.info("Inside Simple Filter");
		RequestContext context=RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		log.info("{} Request To {}",request.getMethod(),request.getRequestURL().toString());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
