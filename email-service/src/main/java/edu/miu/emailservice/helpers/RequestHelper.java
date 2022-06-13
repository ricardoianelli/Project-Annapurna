package edu.miu.emailservice.helpers;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class RequestHelper {

    public static String getAuthenticationToken() throws IllegalStateException {
        Optional<HttpServletRequest> originalRequestOptional = getCurrentHttpRequest();
        if (!originalRequestOptional.isPresent()) {
            throw new IllegalStateException("There is not any request to get Auth token from.");
        }

        HttpServletRequest originalRequest = originalRequestOptional.get();
        return originalRequest.getHeader("Authorization");
    }

    private static Optional<HttpServletRequest> getCurrentHttpRequest() {
        return Optional.ofNullable(RequestContextHolder.getRequestAttributes())
                .filter(ServletRequestAttributes.class::isInstance)
                .map(ServletRequestAttributes.class::cast)
                .map(ServletRequestAttributes::getRequest);
    }
}
