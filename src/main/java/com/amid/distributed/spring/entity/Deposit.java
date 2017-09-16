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
public class Deposit extends BankAsset {
}
