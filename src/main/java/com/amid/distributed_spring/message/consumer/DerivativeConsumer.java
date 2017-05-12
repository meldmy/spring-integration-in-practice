package com.amid.distributed_spring.message.consumer;

import com.amid.distributed_spring.entity.Derivative;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class DerivativeConsumer extends Consumer {

    static final String DERIVATIVE = "Derivative";

    public void print(Message<?> message) {
        printMessage((Derivative) message.getPayload(), DERIVATIVE);
    }
}