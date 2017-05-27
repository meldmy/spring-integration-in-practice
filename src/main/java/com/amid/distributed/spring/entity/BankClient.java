package com.amid.distributed.spring.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author Dmytro Melnychuk
 */
@Data
@ToString(includeFieldNames = true)
public class BankClient {
    private int clientId;
    private String name;
    private String surname;

    public BankClient(int clientId, String name, String surname) {
        this.clientId = clientId;
        this.name = name;
        this.surname = surname;
    }
}
