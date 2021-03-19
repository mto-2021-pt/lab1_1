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

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
public class OfferItem {

    private int quantity;

    private Money totalCost;

    private Product product;

    private Discount discount;

    public OfferItem(Money totalCost, int quantity, Product product) {
        this(totalCost, quantity, product, null);
    }

    public OfferItem(Money totalCost, int quantity, Product product, Discount discount) {

        Money money = null;
        this.quantity = quantity;
        this.product = product;
        if(discount != null) {
            this.discount = discount;
            money = totalCost.subtract(discount.getValue());
        }
        this.totalCost = Objects.requireNonNullElse(money, totalCost);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (discount == null ? 0 : discount.hashCode());
        result = prime * result + quantity;
        result = prime * result + (totalCost == null ? 0 : totalCost.hashCode());
        return result;
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
        if(!this.product.equals(other.product)) {
            return false;
        }
        if (quantity != other.quantity) {
            return false;
        }
        if (totalCost == null) {
            return other.totalCost == null;
        } else return totalCost.equals(other.totalCost);
    }

    /**
     *
     * @param other
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    boolean sameAs(OfferItem other, double delta) {
        if(!this.product.equals(other.product)) {
            return false;
        }
        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.amount.compareTo(other.totalCost.amount) > 0) {
            max = totalCost.amount;
            min = other.totalCost.amount;
        } else {
            max = other.totalCost.amount;
            min = totalCost.amount;
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
