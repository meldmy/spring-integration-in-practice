package com.amid.distributed.spring.service.consumer;

import com.amid.distributed.spring.entity.Credit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class CreditProcessor extends Processor {

    private static final String CREDIT = "Credit";
    private static final Logger LOGGER = LogManager.getLogger(CreditProcessor.class);

    public void print(Message<?> message) {
        printMessage((Credit) message.getPayload(), CREDIT);
    }

    @Override
    Logger getProcessorLogger() {
        return LOGGER;
    }
}
