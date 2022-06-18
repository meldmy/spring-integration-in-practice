package com.amid.distributed.spring.generator;

import com.amid.distributed.spring.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

import static com.google.common.collect.ImmutableSet.copyOf;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newLinkedHashSet;
import static java.util.Optional.empty;
import static java.util.Optional.of;

/**
 * @author Dmytro Melnychuk
 */
public class RandomAssetGenerator {

    private static final Random RANDOM = new Random();
    private static final int MAX_ID = 2_000_000_000;
    private static final int MAX_SUM = 50_000_000;
    private static final RandomClientGenerator clientGenerator = new RandomClientGenerator();
    private final Logger log = LogManager.getLogger(RandomAssetGenerator.class);

    public Set<BankAsset> generateRandomBankAssets(int assetSize) {
        List<Class<? extends BankAsset>> assetClasses = getAvailableBankAssetClasses();
        return copyOf(generateBankAssets(assetSize, assetClasses));
    }

    private ArrayList<Class<? extends BankAsset>> getAvailableBankAssetClasses() {
        return newArrayList(Credit.class, Deposit.class, Derivative.class, SavingBonds.class);
    }

    private Set<BankAsset> generateBankAssets(int assetSize, List<Class<? extends BankAsset>> assetClasses) {
        Set<BankAsset> generatedBankAssets = newLinkedHashSet();
        int iteration = 0;
        while (iteration++ < assetSize) {
            Optional<BankAsset> asset = createRandomBankAsset(assetClasses);
            asset.ifPresent(bankAsset -> generatedBankAssets.add(addRandomAssetData(bankAsset)));
        }
        return generatedBankAssets;
    }

    private BankAsset addRandomAssetData(BankAsset asset) {
        asset.setOperationId(randomId());
        asset.setClient(randomClient());
        asset.setSum(randomSum());
        return asset;
    }

    private BankClient randomClient() {
        return clientGenerator.generate();
    }

    private int randomId() {
        return RANDOM.nextInt(MAX_ID);
    }

    private int randomSum() {
        return RANDOM.nextInt(MAX_SUM);
    }

    private Optional<BankAsset> createRandomBankAsset(List<Class<? extends BankAsset>> assetClasses) {
        Class<? extends BankAsset> assetClass = assetClasses.get(RANDOM.nextInt(assetClasses.size()));
        return tryToCreateRandomBankAsset(assetClass);
    }

    private Optional<BankAsset> tryToCreateRandomBankAsset(Class<? extends BankAsset> assetClass) {
        try {
            return of(assetClass.newInstance());
        } catch (ReflectiveOperationException e) {
            log.info("Creation of" + assetClass.getSimpleName() + " is failed");
            return empty();
        }
    }
}
