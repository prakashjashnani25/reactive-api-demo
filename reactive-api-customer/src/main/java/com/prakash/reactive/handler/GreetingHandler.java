package com.prakash.reactive.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {

	public Mono<ServerResponse> hello(ServerRequest request)  {
		System.out.println("Inside Hello Sleeping for 10 secs");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue("Hello Reactive World"));
	}

}