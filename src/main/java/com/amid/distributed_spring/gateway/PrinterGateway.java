package com.amid.distributed_spring.gateway;

import org.springframework.messaging.Message;

import java.util.concurrent.Future;

/**
 * @author Dmytro Melnychuk
 */
public interface PrinterGateway {

    Future<Message<String>> print(Message<?> message);
}
