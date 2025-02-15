package org.online.queue.onlinequeuesecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OnlineQueueSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineQueueSecurityApplication.class, args);
	}

}
