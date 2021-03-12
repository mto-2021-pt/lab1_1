package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private String Id;
    private Money Price;
    private String Name;
    private Date SnapshotDate;
    private String Type;

    public Product(String id, String name, Money price, Date snapshotDate, String type){
        this.Id = id;
        this.Name = name;
        this.Price = price;
        this.SnapshotDate = snapshotDate;
        this.Type = type;
    }

    public String getId() {
        return Id;
    }

    public Money getPrice() {
        return Price;
    }

    public String getName() {
        return Name;
    }

    public Date getSnapshotDate() {
        return SnapshotDate;
    }

    public String getType() {
        return Type;
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
        Product other = (Product) obj;
        if (Id == null) {
            if (other.Id != null) {
                return false;
            }
        } else if (!Id.equals(other.Id)) {
            return false;
        }

        if (Name == null) {
            if (other.Name != null) {
                return false;
            }
        } else if (!Name.equals(other.Name)) {
            return false;
        }

        if (Price == null) {
            if (other.Price != null) {
                return false;
            }
        } else if (!Price.equals(other.Price)) {
            return false;
        }

        if (SnapshotDate == null) {
            if (other.SnapshotDate != null) {
                return false;
            }
        } else if (!SnapshotDate.equals(other.SnapshotDate)) {
            return false;
        }

        if (Type == null) {
            if (other.Type != null) {
                return false;
            }
        } else if (!Type.equals(other.Type)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + (Name == null ? 0 : Name.hashCode());
        result = prime * result + (Price == null ? 0 : Price.hashCode());
        result = prime * result + (Id == null ? 0 : Id.hashCode());
        result = prime * result + (Type == null ? 0 : Type.hashCode());
        return result;
    }
}
