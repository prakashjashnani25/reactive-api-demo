package com.prakash.reactive.client;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class GreetingWebClient {
	private WebClient greetingClient = WebClient.create("http://localhost:9090");

	/**
	 * Web client can be used to communicate to non reactive , 	blocking services as well
	 * 
	 */
	private Mono<ClientResponse> result = greetingClient.get().uri("/hello").accept(MediaType.APPLICATION_JSON)
			.exchange();
	
	public String getResult() {
		System.out.println("Calling Api");
		Mono<String> response = result.flatMap(res->res.bodyToMono(String.class));
		response.doOnEach(result->System.out.print(result));
		response.doOnError(onError->System.out.println(onError.getMessage()));
		response.block();
		return "Complete";
	}
}
