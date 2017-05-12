package com.amid.distributed_spring.message.consumer;

import com.amid.distributed_spring.entity.Deposit;
import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class DepositProcessor extends Processor {

    private static final String DEPOSIT = "Deposit";
    private static final Logger LOGGER = Logger.getLogger(DepositProcessor.class);

    public void print(Message<?> message) {
        printMessage((Deposit) message.getPayload(), DEPOSIT);
    }

    @Override
    Logger getProcessorLogger() {
        return LOGGER;
    }
}