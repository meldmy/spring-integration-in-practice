package com.amid.distributed.spring.service.consumer;

import com.amid.distributed.spring.entity.Derivative;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class DerivativeProcessor extends Processor {

    private static final String DERIVATIVE = "Derivative";
    private static final Logger LOGGER = LogManager.getLogger(DerivativeProcessor.class);

    public void print(Message<?> message) {
        printMessage((Derivative) message.getPayload(), DERIVATIVE);
    }

    @Override
    Logger getProcessorLogger() {
        return LOGGER;
    }
}