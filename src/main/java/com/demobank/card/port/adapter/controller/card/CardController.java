package com.demobank.card.port.adapter.controller.card;

import java.math.BigInteger;

import org.jmolecules.architecture.hexagonal.Adapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demobank.card.application.card.CardApplicationService;
import com.demobank.card.application.card.DebitAmountFromCardCommand;
import com.demobank.card.application.card.IssueCardCommand;
import com.demobank.card.domain.model.account.transaction.Transaction;
import com.demobank.card.domain.model.card.Card;
import com.demobank.card.port.adapter.controller.card.transaction.TransactionRequest;
import com.demobank.card.port.adapter.controller.card.transaction.TransactionResponse;

@RestController
@RequestMapping("/api/v1/card")
@Adapter
public class CardController {
    @Autowired
    private CardApplicationService cardApplicationService;

    @PostMapping("/{cardNumber}")
    public IssueCardResponse issueCard(@PathVariable BigInteger cardNumber, @RequestBody IssueCardRequest request) {
        Card card = this.cardApplicationService.issueCard(
            new IssueCardCommand(
                cardNumber,
                request.getCardType(),
                request.getBalanceCurrencyCode()
            )
        );
        
        return new IssueCardResponse(
            card.getAccountId().getId(),
            "SUCCESS");
    }

    @PostMapping("/{cardNumber}/debit")
    public TransactionResponse debitAmountFromCard(@PathVariable BigInteger cardNumber, @RequestBody TransactionRequest request) {
        Transaction transaction = this.cardApplicationService.debitAmountFromCard(
            new DebitAmountFromCardCommand(
                cardNumber,
                request.getAmount(), 
                request.getCurrencyCode()));
                
        return new TransactionResponse(
            transaction.getTransactionStatus().toString(), 
            transaction.getTransactionId().getId(),
            transaction.getNewBalance().getAmount(), 
            transaction.getNewBalance().getCurrencyCode().toString()
        );
    }
}