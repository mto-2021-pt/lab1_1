package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money {

    private String currency;

    private BigDecimal amount;

    public Money(String currency) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getTotalCostCurrency() {
        return currency;
    }

}
