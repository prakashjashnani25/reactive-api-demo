package com.prakash.reactive.MAIN;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.prakash.reactive.client.GreetingWebClient;


/**
 * Spring Boot Application -Adds all of the following -
 * 	1. Configuration - Tags the class as the source of a bean defination for the application context.
 *  2. Enable Auto Configuration - Tells The Spring boot to start adding beans based on class path
 *                              settings ,and various property settings e.g. is spring web mvc
 *                              is in class path, the annotation flag this as a Web application
 *                              and activates key behavior such as disppatcher servlet
 *  3.Component Scan - Tells Spring to look for other componets and configuration in package specified
 * @author Prakash
 *
 */

@EnableEurekaClient
@SpringBootApplication(scanBasePackages= {"com.prakash.reactive","com.prakash.reactive.handler","com.prakash.reactive.router"})
public class Application {

	public static void main(String ...args) {
		SpringApplication.run(Application.class, args);
		 
		GreetingWebClient webClient=new GreetingWebClient();
		System.out.println(webClient.getResult());
	}
}
