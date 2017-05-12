package com.amid.distributed_spring.message.consumer;

import com.amid.distributed_spring.entity.BankAsset;
import com.google.common.base.Joiner;
import org.apache.log4j.Logger;

/**
 * @author Dmytro Melnychuk
 */
public class Consumer {

    private final Joiner joiner = Joiner.on(",");
    private final Logger log = Logger.getLogger(CreditConsumer.class);

    void printMessage(BankAsset bankAsset, String assetName) {
        log.info(createMessageForPrint(bankAsset, assetName));
    }

    private String createMessageForPrint(BankAsset bankAsset, String assetName) {
        return joiner.join(
                assetName + ": operationId: ", bankAsset.getOperationId(),
                "clientId: ", bankAsset.getClient().getClientId(),
                "sum: ", bankAsset.getSum());
    }
}
