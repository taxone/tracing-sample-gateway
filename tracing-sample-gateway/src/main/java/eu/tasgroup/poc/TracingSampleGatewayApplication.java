package eu.tasgroup.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Hooks;

@SpringBootApplication
public class TracingSampleGatewayApplication {

	public static void main(String[] args) {
		Hooks.enableAutomaticContextPropagation();

		SpringApplication.run(TracingSampleGatewayApplication.class, args);
	}

}
