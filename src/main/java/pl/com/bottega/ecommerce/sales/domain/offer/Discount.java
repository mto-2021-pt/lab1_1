package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
    private String discountCause;
    private Money value;


    public Discount(String discountCause, Money money) {
        this.discountCause = discountCause;
        this.value = value;
    }


    public String getDiscountCause() {
        return discountCause;
    }

    public Money getValue() {
        return value;
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Discount other = (Discount) obj;
        if (discountCause == null) {
            if (other.discountCause != null) {
                return false;
            }
        } else if (!discountCause.equals(other.discountCause)) {
            return false;
        }

        if (value == null) {
            if (other.value != null) {
                return false;
            }
        } else if (!value.equals(other.value)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + (discountCause == null ? 0 : discountCause.hashCode());
        result = prime * result + (value == null ? 0 : value.hashCode());
        return result;
    }


}
