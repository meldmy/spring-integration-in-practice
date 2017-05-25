package com.amid.distributed_spring.message.creation;

import com.amid.distributed_spring.entity.BankAsset;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author Dmytro Melnychuk
 */
public class AssetMessageBuilder {
    private static int counter = 0;

    private AssetMessageBuilder() {
    }

    public static Message<BankAsset> buildMessage(BankAsset asset) {
        return getBuilderWithHeadersAndPayload(asset)
                .setHeader("counter", counter++)
                .build();
    }

    private static MessageBuilder<BankAsset> getBuilderWithHeadersAndPayload(BankAsset asset) {
        return getBuilderWithPayload(asset)
                .setHeader("messageId", asset.getOperationId())
                .setHeader("isPrinted", "false");
    }

    private static MessageBuilder<BankAsset> getBuilderWithPayload(BankAsset asset) {
        return MessageBuilder
                .withPayload(asset);
    }
}
