package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money implements Comparable {

    private String currency;

    private BigDecimal amount;

    public Money(String currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }

    @Override
    public int compareTo(Object o) {
        Money money = (Money)o;
        return this.amount.compareTo(money.amount);
    }

    public Money subtract(Money money){
        return new Money(this.currency, this.amount.subtract(money.amount));
    }

    public Money multiply(BigDecimal multiplier){
        return new Money(this.currency, this.amount.multiply(multiplier));
    }
}
