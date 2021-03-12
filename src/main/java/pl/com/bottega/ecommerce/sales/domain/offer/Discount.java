package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {// discount
    private String discountCause;
    private Money value = new Money();

    public Discount() {
    }

    public BigDecimal getValue() {
        return value.getAmount();
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public void setValue(BigDecimal value) {
        this.value.setAmount(value);
    }

    public void setDiscountCause(String discountCause) {
        this.discountCause = discountCause;
    }

    public BigDecimal getAmount() {
        return value.getAmount();
    }
}