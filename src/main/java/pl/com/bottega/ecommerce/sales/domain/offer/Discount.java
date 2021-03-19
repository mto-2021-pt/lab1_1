package pl.com.bottega.ecommerce.sales.domain.offer;

public class Discount {
    private final String cause;
    private final Money value;

    public Discount(String cause, Money value) {
        this.cause = cause;
        this.value = value;
    }

    public String getCause() {
        return cause;
    }

    public Money getValue() {
        return value;
    }
}
