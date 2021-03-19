package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money {
    private String currency = "USD";
    private final BigDecimal amount;

    public Money(String currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Money multiply(BigDecimal multiplier) {
        return new Money(currency, amount.multiply(multiplier));
    }

    public Money subtract(Money money) {
        return new Money(currency, amount.subtract(money.getAmount()));
    }

    int compareTo(Money money) {
        return amount.compareTo(money.getAmount());
    }
}
