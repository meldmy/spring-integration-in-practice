package com.amid.distributed.spring.service.consumer;

import com.amid.distributed.spring.entity.Credit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class CreditProcessor extends Processor<Credit> {

    private static final Logger LOGGER = LogManager.getLogger(CreditProcessor.class);

    @Override
    Logger getProcessorLogger() {
        return LOGGER;
    }
}
