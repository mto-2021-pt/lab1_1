package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
    
    private Money value;
    
    private String cause;
    
    public Discount(Money value, String cause)
    {
        this.value=value;
        this.cause=cause;
    }
    
    public String getDiscountCurrency()
    {
        return value.getCurrency();
    }
    
    public BigDecimal getDiscountValue()
    {
        return value.getAmount();
    }
    
    public String getDiscountCause()
    {
        return cause;
    }
}
