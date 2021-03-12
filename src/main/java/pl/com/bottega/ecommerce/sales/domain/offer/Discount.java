package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
    private String cause;
    private BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public String getCause() {
        return cause;
    }
}
