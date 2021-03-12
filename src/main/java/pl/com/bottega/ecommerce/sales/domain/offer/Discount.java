package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
    private String cause;
    private Money value;

    public Money getValue() {
        return value;
    }

    public String getCause() {
        return cause;
    }
}
