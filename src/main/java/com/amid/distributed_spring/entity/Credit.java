package com.amid.distributed_spring.entity;

/**
 * @author Dmytro Melnychuk
 */
public class Credit extends BankAsset {

    public Credit(int operationId, BankClient client, double sum) {
        super(operationId, client, sum);
    }
}
