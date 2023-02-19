package com.aniket.demoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(
		basePackages = {"com.aniket.demoapi", "com.aniket.demoapp"}
)
@EntityScan(
		basePackages = {"com.aniket.demoapi"}
)
@EnableJpaRepositories(
		basePackages = {"com.aniket.demoapi"}
)
public class DemoapiApplication {

	public static void main(String[] args) {
	 SpringApplication.run(DemoapiApplication.class, args);
	}

@Bean
	public  RestartEndpoint restartEndpoint(){
		return new RestartEndpoint();
}

}
