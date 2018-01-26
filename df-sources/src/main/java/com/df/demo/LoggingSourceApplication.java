package com.df.demo;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.annotation.Poller;

@EnableBinding(Processor.class)
@SpringBootApplication
public class LoggingSourceApplication {

	@Bean
	@InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1"))
	public MessageSource<Long> timeMessageSource() {
		System.out.println(new Date() + "======================logging-source========================== execued");
		return () -> MessageBuilder.withPayload(new Date().getTime()).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(LoggingSourceApplication.class, args);
	}
}
