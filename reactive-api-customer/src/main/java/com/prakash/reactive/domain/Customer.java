package com.prakash.reactive.domain;

import java.util.Set;

import lombok.Builder;

@Builder
public class Customer {

	private String name;
	
	private  long id;
	
	private Set<Order> custOrder;
}
