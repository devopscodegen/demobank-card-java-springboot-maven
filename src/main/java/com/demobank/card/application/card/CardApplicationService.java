package com.demobank.card.application.card;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demobank.card.domain.model.account.transaction.Transaction;
import com.demobank.card.domain.model.card.Card;
import com.demobank.card.domain.model.card.CardNumber;
import com.demobank.card.domain.model.card.CardRepository;
import com.demobank.card.domain.model.card.CardService;
import com.demobank.card.domain.model.card.CardType;
import com.demobank.card.domain.model.currency.CurrencyCode;
import com.demobank.card.domain.model.money.Money;

@Service
@Application
public class CardApplicationService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardService cardService;

    @Transactional
    public Card issueCard(IssueCardCommand issueCardCommand) {
        Card card = this.cardService.issueCard(
            new CardNumber(issueCardCommand.getCardNumber()),
            CardType.valueOf(issueCardCommand.getCardType()),
            CurrencyCode.valueOf(issueCardCommand.getBalanceCurrencyCode())
        );
        
        card = this.cardRepository.save(card);

        return card;
    }
    @Transactional
    public Transaction debitAmountFromCard(DebitAmountFromCardCommand debitAmountFromCardCommand) {

        Card card = this.cardRepository.findById(new CardNumber(debitAmountFromCardCommand.getCardNumber())).get();

        Money amount = new Money(
            debitAmountFromCardCommand.getAmount(), 
            CurrencyCode.valueOf(debitAmountFromCardCommand.getCurrencyCode())
        );
        return this.cardService.debitAmountFromCard(
            card,
            amount
        );
    }
}
