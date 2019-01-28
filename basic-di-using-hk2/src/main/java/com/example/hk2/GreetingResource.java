package com.example.hk2;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("greeting")
public class GreetingResource {
	
	@Inject
	public GreetingService greetingService;
	
	@GET
	public String getHello(@QueryParam("name") String name) {
		return this.greetingService.getGreeting(name);
	}

}
