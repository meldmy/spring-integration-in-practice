package com.amid.distributed.spring.gateway;

import com.amid.distributed.spring.entity.BankAsset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

public class GatewaySender {

    private final BankOperationsGateway gateway;

    @Autowired
    public GatewaySender(BankOperationsGateway gateway) {
        this.gateway = gateway;
    }

    public void sentMessage(Message<BankAsset> message) {
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
        var counterValue = i.getHeaders().get("counter").toString();
        return Integer.parseInt(counterValue);
    }
}
