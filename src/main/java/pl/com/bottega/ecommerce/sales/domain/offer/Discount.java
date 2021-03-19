package pl.com.bottega.ecommerce.sales.domain.offer;

public class Discount {
    private String Cause;

    public Discount(String cause, double value) {
        Cause = cause;
    }

    public String getCause() {
        return Cause;
    }

}
