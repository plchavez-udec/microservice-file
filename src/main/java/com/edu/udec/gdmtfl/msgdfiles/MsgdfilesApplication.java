package com.edu.udec.gdmtfl.msgdfiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsgdfilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsgdfilesApplication.class, args);
	}

}
