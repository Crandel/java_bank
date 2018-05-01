package com.banktest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
public class BankTestApplication {

	@Value("${server.port}")
	private String server_port;
	@Value("${spring.datasource.url}")
	private String database_url;

	private static final Logger log = LoggerFactory.getLogger(BankTestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BankTestApplication.class, args);
	}
}
