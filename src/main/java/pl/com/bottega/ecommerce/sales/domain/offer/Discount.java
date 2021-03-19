package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {
    private String cause;

    private BigDecimal discount;


    public Discount(String cause, BigDecimal discount) {
        this.cause = cause;
        this.discount = discount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount1 = (Discount) o;
        return Objects.equals(cause, discount1.cause) &&
                Objects.equals(discount, discount1.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cause, discount);
    }

    public String getCause() {
        return cause;
    }

    public BigDecimal getDiscount() {
        return discount;
    }
}
