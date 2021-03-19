package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money implements Comparable {
    private String currency;
    private double amount;

    public Money(String currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public BigDecimal subtract(Money min) {
    }

    public BigDecimal multiply(BigDecimal valueOf) {
    }
}
