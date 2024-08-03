package com.example.bank.card.domain.model.account;

import org.jmolecules.architecture.hexagonal.Port;
import org.jmolecules.ddd.annotation.Service;

import com.example.bank.card.domain.model.account.transaction.Transaction;
import com.example.bank.card.domain.model.currency.CurrencyCode;
import com.example.bank.card.domain.model.money.Money;

@Service
@Port
public interface AccountService {

    public void openAccount(AccountId accountId, AccountType accountType, CurrencyCode balanceCurrencyCode);

	public Transaction debitAmountFromAccount(AccountId accountId, Money amount);
}
