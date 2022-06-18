package com.amid.distributed.spring.service.consumer;

import com.amid.distributed.spring.entity.BankAsset;
import com.google.common.base.Joiner;
import org.apache.logging.log4j.Logger;

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
