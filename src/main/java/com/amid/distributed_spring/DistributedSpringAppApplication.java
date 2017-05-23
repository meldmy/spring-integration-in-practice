package com.amid.distributed_spring;

import com.amid.distributed_spring.entity.BankAsset;
import com.amid.distributed_spring.generator.RandomAssetGenerator;
import com.amid.distributed_spring.message.gateway.BankOperationsGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Set;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class DistributedSpringAppApplication implements ApplicationRunner {

    private static final int MESSAGE_QUANTITY = 1_000_000;

    @Autowired
    private BankOperationsGateway gateway;

    public static void main(String[] args) {
        SpringApplication.run(DistributedSpringAppApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        generateRandomBankAssets()
                .stream()
                .map(this::sendMessage)
                .forEach(gateway::print);
    }

    private Set<BankAsset> generateRandomBankAssets() {
        return new RandomAssetGenerator().generateRandomBankAssets(MESSAGE_QUANTITY);
    }

    private Message<BankAsset> sendMessage(BankAsset asset) {
        return MessageBuilder
                .withPayload(asset)
                .setHeader("messageId", asset.getOperationId())
                .setHeader("isPrinted", "false")
                .build();
    }
}
