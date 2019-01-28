package com.example.hk2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestGreetingResource {
	
	GreetingResource recource;

	@Before
	public void setUp() throws Exception {
		recource = new GreetingResource();
		GreetingService service = Mockito.mock(GreetingService.class);
		Mockito.when(service.getGreeting(Mockito.matches("Magnus"))).thenReturn("Hello Magnus");
		recource.greetingService = service;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGet() {
		assertEquals(recource.getHello("Magnus"), "Hello Magnus");
	}

}
