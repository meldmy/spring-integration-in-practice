package com.amid.distributed.spring.entity;

import lombok.Data;

/**
 * @author Dmytro Melnychuk
 */

@Data
public abstract class BankAsset {

    private int operationId;
    private BankClient client;
    private double sum;
    public abstract String getAssetName();
}
