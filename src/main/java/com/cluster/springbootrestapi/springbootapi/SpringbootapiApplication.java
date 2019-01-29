package com.cluster.springbootrestapi.springbootapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.cluster.springbootrestapi.springbootapi.")
@SpringBootApplication
@EnableJpaAuditing
public class SpringbootapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootapiApplication.class, args);
	}

}

