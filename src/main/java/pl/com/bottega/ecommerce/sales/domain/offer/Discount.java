package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
    private String cause;
    private BigDecimal value;

    public Discount(String cause, BigDecimal value) {
        this.cause = cause;
        this.value = value;
    }

    public String getCause() {
        return cause;
    }

    public BigDecimal getValue() {
        return value;
    }
}
