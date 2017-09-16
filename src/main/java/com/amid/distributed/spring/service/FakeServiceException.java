package com.amid.distributed.spring.service;

/**
 * @author Dmytro Melnychuk
 */
class FakeServiceException extends RuntimeException {
    FakeServiceException() {
        super("This is error");
    }
}
