package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;

public class Product {
    private String id;

    private String type;

    private String name;

    private Date snapshotDate;

    private Money price;

    Product(String id, String type, String name, Date snapshotDate, Money price){
        this.id = id;
        this.type = type;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.price = price;
    }

    public String getProductId() {
        return id;
    }

    public String getProductName() {
        return name;
    }

    public Date getProductSnapshotDate() {
        return snapshotDate;
    }

    public String getProductType() {
        return type;
    }

    public Money getPrice() {
        return price;
    }
}
