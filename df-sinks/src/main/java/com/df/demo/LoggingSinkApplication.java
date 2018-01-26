package com.df.demo;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

@EnableBinding(Sink.class)
@SpringBootApplication
public class LoggingSinkApplication {

	@MessageEndpoint
	public static class LoggingMessageEndpoint {
		@ServiceActivator(inputChannel = Sink.INPUT)
		public void logIncomingMessages(@Payload String msg, @Headers Map<String, Object> headers) {
			System.out.println("logging-sink**************" + msg);
			headers.entrySet().forEach(e -> System.out.println(e.getKey() + '=' + e.getValue()));
		}
	}

	@StreamListener(Sink.INPUT)
	public void loggerSink(String date) {
		System.out.println("logging-sink Received: " + date);
	}

	public static void main(String[] args) {
		SpringApplication.run(LoggingSinkApplication.class, args);
	}
}
