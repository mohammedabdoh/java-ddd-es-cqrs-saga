package com.mabdoh.domain.valueobject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    private final BigDecimal ammount;

    public Money(BigDecimal ammount) {
        this.ammount = ammount;
    }

    public boolean isGreaterThanZero() {
        return ammount != null && ammount.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean isGreaterThan(Money money) {
        return ammount != null && ammount.compareTo(money.getAmmount()) > 0;
    }

    public Money add(Money money) {
        BigDecimal newAmount = setScale(ammount.add(money.getAmmount()));
        return new Money(newAmount);
    }

    public Money subtract(Money money) {
        BigDecimal newAmount = setScale(ammount.subtract(money.getAmmount()));
        return new Money(newAmount);
    }

    public Money multiply(Money money) {
        BigDecimal newAmount = setScale(ammount.multiply(money.getAmmount()));
        return new Money(newAmount);
    }

    public BigDecimal getAmmount() {
        return this.ammount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Money)) {
            return false;
        }
        Money money = (Money) o;
        return Objects.equals(ammount, money.ammount);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ammount);
    }

    private BigDecimal setScale(BigDecimal input) {
        return input.setScale(2, RoundingMode.HALF_EVEN);
    }
}
