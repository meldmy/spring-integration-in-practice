package com.amid.distributed.spring.service.consumer;

import com.amid.distributed.spring.entity.SavingBonds;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class SavingBondsProcessor extends Processor {

    private static final String SAVING_BONDS = "SavingBonds";
    private static final Logger LOGGER = LogManager.getLogger(SavingBondsProcessor.class);

    public void print(Message<?> message) {
        printMessage((SavingBonds) message.getPayload(), SAVING_BONDS);
    }

    @Override
    Logger getProcessorLogger() {
        return LOGGER;
    }
}