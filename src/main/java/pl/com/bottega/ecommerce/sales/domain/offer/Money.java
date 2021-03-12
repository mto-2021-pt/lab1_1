package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money {
    private String currency;
    private BigDecimal amount;

    public Money() {
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int compareTo(Money object) {
        int compareval = this.amount.compareTo(object.getAmount());
        return Integer.compare(compareval, 0);
    }
}