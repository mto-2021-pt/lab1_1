package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {

    private String Cause;
    private BigDecimal value;
    private Money money;

    public Discount(String cause, BigDecimal value, Money money) {
        Cause = cause;
        this.value = value;
        this.money = money;
    }

    public String getCause() {
        return Cause;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Money getMoney() {
        return money;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
