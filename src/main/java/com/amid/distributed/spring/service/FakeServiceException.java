package com.amid.distributed.spring.service;

/**
 * @author Dmytro Melnychuk
 */
class FakeServiceException extends RuntimeException {
    FakeServiceException(String s) {
        super(s);
    }
}
