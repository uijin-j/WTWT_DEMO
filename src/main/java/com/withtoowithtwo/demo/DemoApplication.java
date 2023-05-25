package com.withtoowithtwo.demo;

import com.fasterxml.jackson.datatype.hibernate5.jakarta.Hibernate5JakartaModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

/*	@Bean
	Hibernate5JakartaModule hibernate5Module() {
		return new Hibernate5JakartaModule(); // 강제 지연 로딩 설정
	}*/
}
