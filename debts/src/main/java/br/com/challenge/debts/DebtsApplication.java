package br.com.challenge.debts;

import br.com.challenge.core.property.JwtConfiguration;
import br.com.challenge.debts.endpoint.entity.Debts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(value = JwtConfiguration.class)
@ComponentScan("br.com.challenge")
public class DebtsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DebtsApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Debts.class);
	}
}
