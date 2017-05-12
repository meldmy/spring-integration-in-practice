package com.amid.distributed_spring.entity;

/**
 * @author Dmytro Melnychuk
 */
public abstract class BankAsset {

    private final int operationId;
    private final BankClient client;
    private final double sum;

    BankAsset(int operationId, BankClient client, double sum) {

        this.operationId = operationId;
        this.client = client;
        this.sum = sum;
    }

    public int getOperationId() {
        return operationId;
    }

    public BankClient getClient() {
        return createCopyOfBankClient();
    }

    public double getSum() {
        return sum;
    }

    private BankClient createCopyOfBankClient() {
        return new BankClient(client.getClientId(), client.getName(), client.getSurname());
    }
}
