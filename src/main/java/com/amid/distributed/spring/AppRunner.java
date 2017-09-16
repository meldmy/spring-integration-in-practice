package com.amid.distributed.spring;

import com.amid.distributed.spring.entity.BankAsset;
import com.amid.distributed.spring.gateway.GatewaySender;
import com.amid.distributed.spring.generator.RandomAssetGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;

import java.util.Set;

import static com.amid.distributed.spring.message.creation.AssetMessageBuilder.buildMessage;

/**
 * @author Dmytro Melnychuk
 */
@Configuration
@ImportResource("integration-context.xml")
class AppRunner implements ApplicationRunner {

    private static final int MESSAGE_QUANTITY = 1_000_000;
    private final GatewaySender gatewaySender;

    @Autowired
    public AppRunner(GatewaySender gatewaySender) {
        this.gatewaySender = gatewaySender;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        generateRandomBankAssets()
                .parallelStream()
                .map(this::createMessage)
                .forEach(gatewaySender::sentMessage);
    }

    private Set<BankAsset> generateRandomBankAssets() {
        return new RandomAssetGenerator().generateRandomBankAssets(MESSAGE_QUANTITY);
    }

    private Message<BankAsset> createMessage(BankAsset asset) {
        return buildMessage(asset);
    }
}