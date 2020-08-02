package com.prakash.reactive.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.prakash.reactive.domain.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CustomerRepository {

	public Mono<Customer> getCustomer(Long customerId) {
		return Mono.fromCallable(() -> Customer.builder().id(10001).name("Test123").build());
	}

	public Flux<Customer> getCustomers(String name) {
		return Flux.fromStream(streamSupplier);
	}

	private Supplier streamSupplier = () -> {
		List<Customer> custList = new ArrayList<>();
		Stream<Customer> custStreamByname = custList.stream();
		return custStreamByname;
	};
}
