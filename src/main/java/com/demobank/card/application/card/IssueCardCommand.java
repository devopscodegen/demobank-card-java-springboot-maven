package com.demobank.card.application.card;

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
public class IssueCardCommand {
    private BigInteger cardNumber;
    private String cardType;
    private String balanceCurrencyCode;
}
