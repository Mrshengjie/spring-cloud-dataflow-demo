package com.df.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.dataflow.server.EnableDataFlowServer;

@EnableDataFlowServer
@SpringBootApplication
public class DfServersApplication {

	public static void main(String[] args) {
		SpringApplication.run(DfServersApplication.class, args);
	}
}
