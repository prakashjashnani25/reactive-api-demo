package com.prakash.reactive.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.prakash.reactive.domain.Customer;
import com.prakash.reactive.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class CustomerRouter {

	@Autowired
	private CustomerRepository customerRepos;
	
	@GetMapping(value="/customer/{customerId}")
	public Mono<Customer> getCustomerDetail(@PathVariable Long customerId){
		log.info("Get Customer {}",customerId);
		return customerRepos.getCustomer(customerId);
	}
	
	public Flux<ServerResponse> getCustomerOrder(Long customerId){
		return null;
	}
}
