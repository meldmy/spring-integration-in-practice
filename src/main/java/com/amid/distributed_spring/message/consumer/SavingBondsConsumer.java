package com.amid.distributed_spring.message.consumer;

import com.amid.distributed_spring.entity.SavingBonds;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class SavingBondsConsumer extends Consumer {

    static final String SAVING_BONDS = "SavingBonds";

    public void print(Message<?> message) {
        printMessage((SavingBonds) message.getPayload(), SAVING_BONDS);
    }
}