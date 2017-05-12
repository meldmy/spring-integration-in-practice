package com.amid.distributed_spring.entity;

/**
 * @author Dmytro Melnychuk
 */
public class Deposit extends BankAsset {

    public Deposit(int operationId, BankClient client, double sum) {
        super(operationId, client, sum);
    }
}
