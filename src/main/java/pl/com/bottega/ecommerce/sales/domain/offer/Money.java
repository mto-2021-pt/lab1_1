package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money implements Comparable<Money> {
    private int currency;
    private BigDecimal amount;

    public Money(int currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Money(BigDecimal amount) {
        this.currency = 0;
        this.amount = amount;
    }

    @Override
    public int compareTo(Money o) {
        return this.amount.compareTo(o.amount);
    }

    public int getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
