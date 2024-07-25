package com.demobank.card.domain.model.card;

import com.demobank.card.domain.model.common.BaseValueObject;

public enum CardType implements BaseValueObject{

    DEBIT {
        public boolean isdebitAmountFromCard() {
            return true;
        }
    },

    CREDIT {
        public boolean iscreditAmountToAccount() {
            return true;
        }
    };

    public boolean isdebitAmountFromCard() {
        return false;
    }

    public boolean iscreditAmountToAccount() {
        return false;
    }

    public CardType regress() {
        if (this.isdebitAmountFromCard()) {
            return DEBIT;
        } else if (this.iscreditAmountToAccount()) {
            return CREDIT;
        }

        return DEBIT;
    }
}
