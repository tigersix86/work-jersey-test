package com.example.hk2;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class AppConfig extends ResourceConfig {
    public AppConfig() {
        register(GreetingResource.class);
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindAsContract(GreetingService.class);
            }
        });
    }
}