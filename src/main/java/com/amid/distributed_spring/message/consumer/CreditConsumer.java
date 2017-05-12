package com.amid.distributed_spring.message.consumer;

import com.amid.distributed_spring.entity.Credit;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class CreditConsumer extends Consumer {

    static final String CREDIT = "Credit";

    public void print(Message<?> message) {
        printMessage((Credit) message.getPayload(), CREDIT);
    }
}
