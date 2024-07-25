package com.demobank.card.domain.model.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demobank.card.domain.model.account.AccountId;
import com.demobank.card.domain.model.account.AccountService;
import com.demobank.card.domain.model.account.AccountType;
import com.demobank.card.domain.model.account.transaction.Transaction;
import com.demobank.card.domain.model.currency.CurrencyCode;
import com.demobank.card.domain.model.money.Money;

import java.math.BigInteger;

@Service
@org.jmolecules.ddd.annotation.Service
public class CardService {

    @Autowired
    private AccountService accountService;

    public Card issueCard(CardNumber cardNumber, CardType cardType, CurrencyCode currencyCode) {

        AccountId accountId = new AccountId(
            cardNumber.getNumber()
            .add(
                BigInteger.valueOf(1000000)
            )
        );
        this.accountService.openAccount(
            accountId,
            AccountType.valueOf("CARD"),
            currencyCode
        );
        Card card = new Card(
            cardNumber,
            cardType,
            accountId
        );
        return card;
    }

    public Transaction debitAmountFromCard(Card card, Money amount) {
        return this.accountService.debitAmountFromAccount(card.getAccountId(), amount);
    }
}
