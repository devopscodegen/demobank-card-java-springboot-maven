package com.example.bank.card.domain.model.card;

import com.example.bank.card.domain.model.common.BaseValueObject;

public enum CardType implements BaseValueObject{

    DEBIT {
        public boolean isDebit() {
            return true;
        }
    },

    CREDIT {
        public boolean isCredit() {
            return true;
        }
    };

    public boolean isDebit() {
        return false;
    }

    public boolean isCredit() {
        return false;
    }

    public CardType regress() {
        if (this.isDebit()) {
            return DEBIT;
        } else if (this.isCredit()) {
            return CREDIT;
        }

        return DEBIT;
    }
}
