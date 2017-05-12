package com.amid.distributed_spring.entity;

/**
 * @author Dmytro Melnychuk
 */
public final class BankClient {
    private final int clientId;
    private final String name;
    private final String surname;

    public BankClient(int clientId, String name, String surname) {
        this.clientId = clientId;
        this.name = name;
        this.surname = surname;
    }

    public int getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
