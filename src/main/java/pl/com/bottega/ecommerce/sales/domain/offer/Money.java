package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money implements Comparable{

    private BigDecimal amount;
    private String currency;

    public Money(BigDecimal amount, String currency) {
        this.currency=currency;
        this.amount=amount;
    }

    public Money(BigDecimal amount) {
        this.amount=amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal multiply(BigDecimal bigDecimal) {
    }

    @Override
    public int compareTo(Object o) {
        if(o == null || o.getClass() != getClass())
            return 0;

        Money oth = (Money)o;

        return amount.compareTo(oth.getAmount());
    }
}
