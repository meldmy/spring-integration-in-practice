package com.amid.distributed_spring.message.consumer;

import com.amid.distributed_spring.entity.BankAsset;
import com.google.common.base.Joiner;
import org.apache.log4j.Logger;

/**
 * @author Dmytro Melnychuk
 */
public abstract class Processor {

    private final Joiner joiner = Joiner.on(",");

    void printMessage(BankAsset bankAsset, String assetName) {
        getProcessorLogger().info(createMessageForPrint(bankAsset, assetName));
    }

    abstract Logger getProcessorLogger();

    private String createMessageForPrint(BankAsset bankAsset, String assetName) {
        return joiner.join(
                assetName + ": operationId: ", bankAsset.getOperationId(),
                "clientId: ", bankAsset.getClient().getClientId(),
                "sum: ", bankAsset.getSum());
    }
}
