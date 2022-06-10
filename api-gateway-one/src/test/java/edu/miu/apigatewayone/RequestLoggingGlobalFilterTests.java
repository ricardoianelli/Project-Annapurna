package edu.miu.apigatewayone;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RequestLoggingGlobalFilterTests {

    RequestLoggingGlobalFilter requestLoggingGlobalFilter = new RequestLoggingGlobalFilter();

    @Test
    public void UponReceivingARequest_ShouldLogItsInfo() {

        ServerWebExchange exchangeMock = mock(ServerWebExchange.class);
        ServerHttpRequest requestMock = mock(ServerHttpRequest.class);
        RequestPath requestPathMock = mock(RequestPath.class);

        when(requestPathMock.toString()).thenReturn("/api/v1/users");
        when(requestMock.getPath()).thenReturn(requestPathMock);
        when(requestMock.getMethod()).thenReturn(HttpMethod.GET);

        assertDoesNotThrow(() -> requestLoggingGlobalFilter.logRequestInformation(exchangeMock));
    }
}
