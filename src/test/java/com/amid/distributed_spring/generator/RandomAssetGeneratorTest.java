package com.amid.distributed_spring.generator;

import com.amid.distributed_spring.entity.BankAsset;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dmytro Melnychuk
 */
public class RandomAssetGeneratorTest {

    private static final int EXPECTED_ASSET_SIZE = 45;

    @Test
    public void generateRandomBankAsset() {
        Set<BankAsset> assets = new RandomAssetGenerator().generateRandomBankAssets(EXPECTED_ASSET_SIZE);
        assertThat(assets).hasSize(EXPECTED_ASSET_SIZE);
    }
}