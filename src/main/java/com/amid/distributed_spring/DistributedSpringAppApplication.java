package com.amid.distributed_spring;

import com.amid.distributed_spring.service.PrinterService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Configuration
public class DistributedSpringAppApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(DistributedSpringAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("key", "value");
        MessageHeaders headers = new MessageHeaders(map);
        Message<String> message = new GenericMessage<>("Let's integrate", headers);

        PrinterService service = new PrinterService();
        service.print(message);
    }
}
