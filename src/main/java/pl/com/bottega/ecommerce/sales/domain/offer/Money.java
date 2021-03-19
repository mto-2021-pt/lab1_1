package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money {
    private String currency;
    private BigDecimal amount;

    Money(String currency, BigDecimal amount){
        this.currency = currency;
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int compareTo(Money totalCost) {
        if (this.currency.equals(totalCost.currency) && this.amount.equals(totalCost.amount)) return 0;
        return this.amount.compareTo(totalCost.amount);
    }
}
