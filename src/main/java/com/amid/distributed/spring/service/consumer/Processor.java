package com.amid.distributed.spring.service.consumer;

import com.amid.distributed.spring.entity.BankAsset;
import com.amid.distributed.spring.entity.SavingBonds;
import com.google.common.base.Joiner;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public abstract class Processor<T extends BankAsset> {

    private final Joiner joiner = Joiner.on(",");

    public void printMessage(Message<T> message) {
        getProcessorLogger().info(createMessageForPrint(message.getPayload()));
    }

    <E> void printError(E bankAsset) {
        getProcessorLogger().info("Error with processing:" + bankAsset);
    }

    abstract Logger getProcessorLogger();

    private String createMessageForPrint(T bankAsset) {
        return joiner.join(
                "assetName: ", bankAsset.getAssetName(),
                "operationId: ", bankAsset.getOperationId(),
                "clientId: ", bankAsset.getClient().clientId(),
                "sum: ", bankAsset.getSum(),
                "operation");
    }
}
