package com.amid.distributed.spring;

import com.amid.distributed.spring.entity.BankAsset;
import com.amid.distributed.spring.generator.RandomAssetGenerator;
import com.amid.distributed.spring.message.creation.AssetMessageBuilder;
import com.amid.distributed.spring.message.gateway.BankOperationsGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;

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
                .parallelStream()
                .map(this::createMessage)
                .forEach(this::sentMessage);
    }

    private void sentMessage(Message<BankAsset> message) {
        if (isDividedByFiveWithoutRemainder(message))
            gateway.printDevidedByFive(message);
        else {
            gateway.print(message);
        }
    }

    private boolean isDividedByFiveWithoutRemainder(Message<BankAsset> i) {
        return getMessageCounter(i) % 5 == 0;
    }

    private int getMessageCounter(Message<BankAsset> i) {
        return Integer.parseInt(i.getHeaders().get("counter").toString());
    }

    private Set<BankAsset> generateRandomBankAssets() {
        return new RandomAssetGenerator().generateRandomBankAssets(MESSAGE_QUANTITY);
    }

    private Message<BankAsset> createMessage(BankAsset asset) {
        return AssetMessageBuilder.buildMessage(asset);
    }

}
