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
    private Discount discount;
    private Money totalCost;

    private int quantity;

    private String currency;

    public Product getProduct() {
        return product;
    }

    public OfferItem(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate,
            String productType, int quantity) {
        this(productId, productPrice, productName, productSnapshotDate, productType, quantity, null, null);
    }

    public OfferItem(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate,
            String productType, int quantity, BigDecimal discount, String discountCause) {
        this.product = new Product(productId, productName, productSnapshotDate, productType, new Money("Zł", productPrice));


        this.quantity = quantity;
        this.discount = new Discount(discountCause, discount);

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.subtract(discount);
        }

        this.totalCost = new Money("Zł", productPrice.multiply(new BigDecimal(quantity)).subtract(discountValue));
    }

    public String getProductId() {
        return product.getId();
    }

    public Money getProductPrice() {
        return product.getPrice();
    }

    public String getProductName() {
        return product.getName();
    }

    public Date getProductSnapshotDate() {
        return product.getSnapshotDate();
    }

    public String getProductType() {
        return product.getType();
    }

    public Money getTotalCost() {
        return totalCost;
    }

    public String getTotalCostCurrency() {
        return currency;
    }

    public Discount getDiscount() {
        return discount;
    }

    public String getDiscountCause() {
        return discount.getCause();
    }

    public int getQuantity() {
        return quantity;
    }





    /**
     *
     * @param other
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (getProductName() == null) {
            if (other.getProductName() != null) {
                return false;
            }
        } else if (!getProductName().equals(other.getProductName())) {
            return false;
        }
        if (getProductPrice() == null) {
            if (other.getProductPrice() != null) {
                return false;
            }
        } else if (!getProductPrice().equals(other.getProductPrice())) {
            return false;
        }
        if (getProductId() == null) {
            if (other.getProductId() != null) {
                return false;
            }
        } else if (!getProductId().equals(other.getProductId())) {
            return false;
        }
        if (getProductType() != other.getProductType()) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.getAmount().compareTo(other.totalCost.getAmount()) > 0) {
            max = totalCost.getAmount();
            min = other.totalCost.getAmount();
        } else {
            max = other.totalCost.getAmount();
            min = totalCost.getAmount();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferItem offerItem = (OfferItem) o;
        return quantity == offerItem.quantity &&
                Objects.equals(product, offerItem.product) &&
                Objects.equals(discount, offerItem.discount) &&
                Objects.equals(totalCost, offerItem.totalCost) &&
                Objects.equals(currency, offerItem.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, discount, totalCost, quantity, currency);
    }
}
