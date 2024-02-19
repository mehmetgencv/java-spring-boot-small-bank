package com.mehmetgenc.bank.entity;

import com.mehmetgenc.bank.enums.EnumAccountType;
import com.mehmetgenc.bank.enums.EnumCurrencyType;
import com.mehmetgenc.bank.enums.EnumStatus;
import com.mehmetgenc.bank.general.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Creation Date: 18.02.2024
 *
 * @author: mehmetgenc
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "ACCOUNT")
public class Account extends BaseEntity {

    @Id
    @SequenceGenerator(name = "Account", sequenceName = "ACCOUNT_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Account")
    private Long id;

    @Column(name = "IBAN_NO", length = 30)
    private String ibanNo;

    @Column(name = "CURRENT_BALANCE", precision = 19, scale = 2)
    private BigDecimal currentBalance;

    @Enumerated(EnumType.STRING)
    @Column(name = "ACCOUNT_TYPE", length = 30)
    private EnumAccountType accountType;

    @Enumerated(EnumType.STRING)
    @Column(name = "CURRENCY_TYPE", length = 30)
    private EnumCurrencyType currencyType;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 30)
    private EnumStatus status;


}
