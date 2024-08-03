package com.example.bank.card.domain.model.card;

import java.util.Date;

import org.jmolecules.event.annotation.DomainEvent;

import com.example.bank.card.domain.model.account.transaction.Transaction;
import com.example.bank.card.domain.model.common.BaseDomainEvent;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@DomainEvent
public class AmountDebitedFromCard extends BaseDomainEvent {
    private Transaction transaction;

    public AmountDebitedFromCard(Transaction transaction) {
        super();
        this.setTransaction(transaction);
        this.setEventVersion(1);
        this.setOccurredOn(new Date());
        this.setEventType(this.getClass().getName());
    }
}
