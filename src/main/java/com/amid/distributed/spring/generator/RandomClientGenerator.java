package com.amid.distributed.spring.generator;

import com.amid.distributed.spring.entity.BankClient;
import com.google.common.io.BaseEncoding;

import java.util.Random;

/**
 * @author Dmytro Melnychuk
 */
class RandomClientGenerator {
    private static final int MAX_ID = 1_000_500;
    private static final int NAME_LENGTH = 7;
    private static final int SURNAME_LENGTH = 13;
    private final Random random = new Random();

    BankClient generate() {
        return new BankClient(randomId(), randomAlphanumeric(NAME_LENGTH), randomAlphanumeric(SURNAME_LENGTH));
    }

    private String randomAlphanumeric(int length) {
        final byte[] buffer = new byte[length];
        random.nextBytes(buffer);
        return BaseEncoding.base64Url().omitPadding().encode(buffer);
    }

    private int randomId() {
        return random.nextInt(MAX_ID);
    }
}
