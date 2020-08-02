package com.prakash.reactive.gateway.config;

import org.springframework.context.annotation.Configuration;

import com.prakash.reactive.gateway.filter.SimpleFilter;

@Configuration
public class GatewayConfig {

	public SimpleFilter simpleFilter() {
		return new SimpleFilter();
	}
}
