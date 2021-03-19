package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {

    private String cause;
    private Money value;

    public Discount(BigDecimal value, String cause) {
        this.cause = cause;
        this.value = new Money(value, cause);
    }

    public Discount(String cause) {
        this.value = new Money(cause);
    }

    public String getCause() {
        return cause;
    }

    public Money getValue() {
        return value;
    }
}
