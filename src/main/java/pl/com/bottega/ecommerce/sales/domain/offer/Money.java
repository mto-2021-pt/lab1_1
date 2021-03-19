package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money {


    private BigDecimal amount;

    private String currency;

    public Money(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal subtract(BigDecimal min) {
        this.amount -= min;
        return this.getAmount();
    }

    public BigDecimal multiply(BigDecimal multiplyValue) {
        return this.amount *= multiplyValue;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
