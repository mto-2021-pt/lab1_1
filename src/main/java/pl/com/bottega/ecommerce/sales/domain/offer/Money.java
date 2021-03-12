package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money implements Comparable{
    private String currency;
    private BigDecimal amount;

    public Money(){
        this(null, null);
    }

    public Money(BigDecimal amount){
        this(amount, null);
    }
    public Money(BigDecimal amount, String currency){
        this.currency = currency;
        this.amount = amount;
    }

    public BigDecimal getAmount(){
        return amount;
    }

    public String getCurrency(){
        return currency;
    }

    @Override
    public int compareTo(Object other){
        if(other == null || other.getClass() != getClass())
            return 0;

        Money oth = (Money)other;

        return amount.compareTo(oth.getAmount());
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

        Money other = (Money) obj;
        if (amount == null) {
            if (other.amount != null) {
                return false;
            }
        } else if (!amount.equals(other.amount)) {
            return false;
        }

        if (currency == null) {
            if (other.currency != null) {
                return false;
            }
        } else if (!currency.equals(other.currency)) {
            return false;
        }

        return true;
    }

    public Money subtract(Money other){
        return new Money(this.amount.subtract(other.getAmount()), currency);
    }

    public Money add(Money other){
        return new Money(this.amount.add(other.getAmount()), currency);
    }

    public Money multiply(BigDecimal value){
        return new Money(amount.multiply(value), currency);
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + (currency == null ? 0 : currency.hashCode());
        result = prime * result + (amount == null ? 0 : amount.hashCode());
        return result;
    }
}
