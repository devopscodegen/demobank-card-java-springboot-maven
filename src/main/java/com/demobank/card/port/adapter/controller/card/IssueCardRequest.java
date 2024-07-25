package com.demobank.card.port.adapter.controller.card;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class IssueCardRequest {
    private BigInteger cardNumber;
    private String cardType;
    private String balanceCurrencyCode;
}