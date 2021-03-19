package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;

public class Product {
    private String ID;
    private String type;
    private String name;
    private Date snapshotDate;
    private Money productPrice;

    public Product(String ID, String type, String name, Date snapshotDate, Money productPrice) {
        this.ID = ID;
        this.type = type;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.productPrice = productPrice;
    }

    public String getID(){return ID;}
    public String getProductType(){return type;}
    public String getName(){return name;}
    public Date getSnapshotDate(){return snapshotDate;}
    public Money getProductPrice(){return productPrice;}




}
