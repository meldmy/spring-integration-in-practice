package com.amid.distributed.spring.service.consumer;

import com.amid.distributed.spring.entity.Deposit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class DepositProcessor extends Processor<Deposit> {

    private static final Logger LOGGER = LogManager.getLogger(DepositProcessor.class);

    @Override
    Logger getProcessorLogger() {
        return LOGGER;
    }
}