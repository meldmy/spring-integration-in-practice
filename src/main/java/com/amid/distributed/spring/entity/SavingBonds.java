package com.amid.distributed.spring.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Dmytro Melnychuk
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class SavingBonds extends BankAsset {
    @Override
    public String getAssetName() {
        return "saving-bond";
    }
}
