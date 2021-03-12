
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    
    private String id;
    
    private String name;

    private Date productSnapshotDate;

    private String type;
    
    private Money price;
    
    public Product(String id, String name, Date productSnapshotDate, String type, Money price)
    {
        this.id=id;
        this.name=name;
        this.productSnapshotDate=productSnapshotDate;
        this.type=type;
        this.price=price;
    }
    
    public String getProductId() {
        return id;
    }

    public String getProductName() {
        return name;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public String getProductType() {
        return type;
    }
    
    public String getProductCurrency()
    {
        return price.getCurrency();
    }
    
    public BigDecimal getProductPrice()
    {
        return price.getAmount();
    }
    
}
