package com.amid.distributed_spring.entity;

/**
 * @author Dmytro Melnychuk
 */
public class Derivative extends BankAsset {

    public Derivative(int operationId, BankClient client, double sum) {
        super(operationId, client, sum);
    }
}
