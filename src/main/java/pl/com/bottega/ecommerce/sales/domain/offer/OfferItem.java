/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class OfferItem {

    private Product product;

    private int quantity;

    private Discount discount;

    private Money money;


    public OfferItem(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate,
            String productType, int quantity) {
        this(productId, productPrice, productName, productSnapshotDate, productType, quantity, null, null);
    }

    public OfferItem(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate,
            String productType, int quantity, BigDecimal discount, String discountCause) {
        this.money = new Money(productPrice);
        this.product = new Product(productId,productName,productSnapshotDate,productType,new Money(productPrice));
        this.quantity = quantity;
        this.discount = new Discount(discountCause,discount,new Money(productPrice));

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            this.discount.setValue(discountValue.subtract(discount));
        }

    }


    public Product getProduct() {
        return product;
    }

    public Money getMoney() {
        return money;
    }

    public Discount getDiscount() {
        return discount;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity,product,discount,money);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OfferItem other = (OfferItem) obj;
        if (discount == null) {
            if (other.discount != null) {
                return false;
            }
        } else if (!discount.equals(other.discount)) {
            return false;
        }
        if (product.compareTo(((OfferItem) obj).getProduct())!=0){
            return false;
        }
        if (quantity != other.quantity) {
            return false;
        }if (!money.getAmount().equals(((OfferItem) obj).getMoney().getAmount())){
            return false;
        }if (!money.getCurrency().equals(((OfferItem) obj).getMoney().getCurrency())){
            return false;
        }

        return true;
    }

    /**
     *
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (product.sameAs(other.product)){
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (money.getAmount().compareTo(other.getMoney().getAmount()) > 0) {
            max = money.getAmount();
            min = other.getMoney().getAmount();
        } else {
            max = other.getMoney().getAmount();
            min = money.getAmount();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
