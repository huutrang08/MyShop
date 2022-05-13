package com.rest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.rest.Config.StorageProperties;
import com.rest.Services.StorageServices;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SecurityProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityProjectApplication.class, args);
	}
	
	     @Bean
	  CommandLineRunner init(StorageServices services) {
		  return(args->{
			  services.init();
		  });
	  }

}
