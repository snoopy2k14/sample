package com.hackerrank.sample;

import com.hackerrank.sample.dto.StringResponse;
import com.hackerrank.sample.repository.SampleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(SampleRepository sampleRepository){

		return args -> {
			sampleRepository.save(new StringResponse("defaultHello","Default Hello World"));
		};

	}
}
