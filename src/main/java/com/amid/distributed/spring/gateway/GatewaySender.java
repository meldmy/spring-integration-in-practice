package com.amid.distributed.spring.gateway;

import com.amid.distributed.spring.entity.BankAsset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

import java.util.Optional;

import static java.util.Optional.empty;

public record GatewaySender(BankOperationsGateway gateway) {

    public void sentMessage(Message<BankAsset> message) {
        getMessageCount(message)
                .ifPresent(count -> {
                    if (count % 5 == 0) gateway.printDevidedByFive(message);
                    else gateway.print(message);
                });
    }

    private Optional<Integer> getMessageCount(Message<BankAsset> i) {
        if (i.getHeaders().get("counter") instanceof Integer counter)
            try {
                return Optional.of(counter);
            } catch (NumberFormatException e) {
                return empty();
            }
        return empty();
    }
}
