package com.demobank.card.domain.model.card;

import org.jmolecules.ddd.annotation.AggregateRoot;

import com.demobank.card.domain.model.account.AccountId;
import com.demobank.card.domain.model.common.BaseAggregateRoot;

import jakarta.annotation.Nullable;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="cards")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString
@AggregateRoot
public class Card extends BaseAggregateRoot<Card, CardNumber> {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private CardNumber cardNumber;
    private CardType cardType;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(
            name="id", 
            column=@jakarta.persistence.Column(name="account_id"))
    })
    private AccountId accountId;
    public Card(CardNumber cardNumber, CardType cardType, AccountId accountId) {
        super();
        this.setCardNumber(cardNumber);
        this.setCardType(cardType);
        this.setAccountId(accountId);
        registerEvent(new CardIssued(this));
    }

    @Nullable
	@Override
	public CardNumber getId() {
		return this.getCardNumber();
	}
	@Transient
	@Override
	public boolean isNew() {
		return null == this.getId();
	}
}
