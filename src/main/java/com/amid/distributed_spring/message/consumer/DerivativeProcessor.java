package com.amid.distributed_spring.message.consumer;

import com.amid.distributed_spring.entity.Derivative;
import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class DerivativeProcessor extends Processor {

    private static final String DERIVATIVE = "Derivative";
    private static final Logger LOGGER = Logger.getLogger(DerivativeProcessor.class);

    public void print(Message<?> message) {
        printMessage((Derivative) message.getPayload(), DERIVATIVE);
    }

    @Override
    Logger getProcessorLogger() {
        return LOGGER;
    }
}