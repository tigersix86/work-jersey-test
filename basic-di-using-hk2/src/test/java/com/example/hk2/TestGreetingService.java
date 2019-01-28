package com.example.hk2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestGreetingService {
	
	GreetingService service;

	@Before
	public void setUp() throws Exception {
		service = new GreetingService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetGreeting() {
		String name = "Me";
		String greeting = service.getGreeting(name);
		assertEquals(greeting, "Hello " + name);
	}

}
