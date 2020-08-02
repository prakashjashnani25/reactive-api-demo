package com.prakash.reactive.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.prakash.reactive.handler.GreetingHandler;

@Configuration
public class GreetingRouter {

	/**
	 * The router Listen for a traffic on "/hello path and return the response of reactive handeler
	 * @param greetingHandeler
	 * @return
	 */
	@Bean
	public RouterFunction<ServerResponse> route(GreetingHandler greetingHandeler) {
		return RouterFunctions.route(
				RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
				greetingHandeler::hello);
	}
}
