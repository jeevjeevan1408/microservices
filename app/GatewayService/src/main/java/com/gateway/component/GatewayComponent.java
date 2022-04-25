
package com.gateway.component;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component

@Slf4j
public class GatewayComponent implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("*******************");
		log.info("In gateway service");

		ServerHttpRequest req = exchange.getRequest();
		HttpHeaders headers = req.getHeaders();

		headers.forEach((key, value) -> {
			log.info("{} : {}", key, value.stream().collect(Collectors.joining(", ")));
		});

		if (req.getMethod().equals(HttpMethod.DELETE)) {
			throw new MethodNotAllowedException(req.getMethod().name(),
					Arrays.asList(HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT));
		}

		return chain.filter(exchange);
	}

}
