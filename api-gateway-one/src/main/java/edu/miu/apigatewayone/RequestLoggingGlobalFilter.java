package edu.miu.apigatewayone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class RequestLoggingGlobalFilter
        implements GlobalFilter, Ordered {

    final Logger logger =
            LoggerFactory.getLogger(RequestLoggingGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logRequestInformation(exchange);
        return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> logResponseInformation(exchange, stopWatch)));
    }

    public void logRequestInformation(ServerWebExchange exchange) {
        try {
            ServerHttpRequest request = exchange.getRequest();
            String logMessage = "Request: " +
                    request.getMethod() +
                    " - " +
                    request.getPath();

            logger.info(logMessage);
        } catch (Exception ex) {
            logger.error("There was an exception logging a request: " + ex);
        }

    }

    public void logResponseInformation(ServerWebExchange exchange, StopWatch currentStopWatch) {
        try {
            currentStopWatch.stop();
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();
            String logMessage = "Response: " +
                    "[" +
                    response.getStatusCode() +
                    "] " +
                    request.getMethod() +
                    " - " +
                    request.getPath() +
                    " - " +
                    currentStopWatch.getTotalTimeMillis() +
                    " ms.";

            logger.info(logMessage);
        } catch (Exception ex) {
            logger.error("There was an exception logging a response: " + ex);
        }
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
