package com.amid.distributed_spring.entity;

/**
 * @author Dmytro Melnychuk
 */
public class SavingBonds extends BankAsset {

    public SavingBonds(int operationId, BankClient client, double sum) {
        super(operationId, client, sum);
    }
}
