package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;

public class Product implements Comparable<Product>{
    private String id;
    private String name;
    private Date SnapshotDate;
    private String Type;
    private Money money;


    public Product(String id, String name, Date snapshotDate, String type, Money money) {
        this.id = id;
        name = name;
        SnapshotDate = snapshotDate;
        Type = type;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getSnapshotDate() {
        return SnapshotDate;
    }

    public String getType() {
        return Type;
    }

    public Money getMoney() {
        return money;
    }

    @Override
    public int compareTo(Product o) {
        if(  (id.equals(o.getId()) )&&(name.equals(o.getName()))&&(getSnapshotDate().equals(o.getSnapshotDate()))&&(getType().equals(o.getType()))&&(money.equals(o.getMoney()))  ){
            return 0;
        }
        return 1;
    }

    public boolean sameAs(Product other) {
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }

        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
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
}
