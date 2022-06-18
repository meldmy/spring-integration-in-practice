package com.amid.distributed.spring.service.consumer;

import com.amid.distributed.spring.entity.Deposit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class DepositProcessor extends Processor {

    private static final String DEPOSIT = "Deposit";
    private static final Logger LOGGER = LogManager.getLogger(DepositProcessor.class);

    public void print(Message<?> message) {
        printMessage((Deposit) message.getPayload(), DEPOSIT);
    }

    @Override
    Logger getProcessorLogger() {
        return LOGGER;
    }
}