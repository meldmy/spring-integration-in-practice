package com.amid.distributed_spring.entity;

import lombok.Data;

/**
 * @author Dmytro Melnychuk
 */

@Data
public abstract class BankAsset {

    private int operationId;
    private BankClient client;
    private double sum;

    private BankClient createCopyOfBankClient() {
        return new BankClient(client.getClientId(), client.getName(), client.getSurname());
    }
}
