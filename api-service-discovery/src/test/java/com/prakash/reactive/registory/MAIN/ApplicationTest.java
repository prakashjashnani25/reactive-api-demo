package com.prakash.reactive.registory.MAIN;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class ApplicationTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	@Test
	public void catalogLoads() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = testRestTemplate.getForEntity("/eureka/apps", Map.class);
		assertEquals(HttpStatus.SC_OK, entity.getStatusCode());
	}

	@Test
	public void adminLoads() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = testRestTemplate.getForEntity("/env", Map.class);
		assertEquals(HttpStatus.SC_OK, entity.getStatusCode());
	}
	
}
