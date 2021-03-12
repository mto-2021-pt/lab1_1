package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {// product
    private String id;
    private Money price = new Money();
    private String name;
    private Date snapshotDate;
    private String type;

    public Product() {
    }

    public String getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price.getAmount();
    }

    public String getName() {
        return name;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price.setAmount(price);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSnapshotDate(Date snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return price.getAmount();
    }
}