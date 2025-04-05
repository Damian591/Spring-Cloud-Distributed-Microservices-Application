package lt.vilniustech.dgrigorovic.pirmas;

import lt.vilniustech.dgrigorovic.pirmas.config.TestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableConfigurationProperties(TestConfig.class)
@EnableDiscoveryClient
public class PirmasDarbasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PirmasDarbasApplication.class, args);
	}

}
