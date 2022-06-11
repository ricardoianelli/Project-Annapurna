package edu.miu.loginservice.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

	private String secretKey;

	private long validityInMilliseconds;
}
