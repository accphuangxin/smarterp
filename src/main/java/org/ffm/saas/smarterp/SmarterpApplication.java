package org.ffm.saas.smarterp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"org.ffm.saas.smarterp.*.persistence"})
public class SmarterpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmarterpApplication.class, args);
	}

}
