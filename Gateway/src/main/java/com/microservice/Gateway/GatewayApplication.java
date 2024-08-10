package com.microservice.Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routerBuilder(RouteLocatorBuilder routeLocatorBuilder){
		return routeLocatorBuilder.routes()
				.route("Phone",r->r.path("/phones/**")
						.uri("http://localhost:8081/"))
				.route("Image",r->r.path("/upload/**","/files/**")
						.uri("http://localhost:8082/"))
				.route("Order",r->r.path("/orders/**")
						.uri("http://localhost:8083/"))
				.route("Security",r->r.path("/auth/**","/info")
						.uri("http://localhost:8084/")).build();
	}
}
