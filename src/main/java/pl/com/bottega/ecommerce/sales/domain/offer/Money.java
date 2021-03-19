package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money {

	private BigDecimal amount;
	
	private String currency;
	
	public Money(BigDecimal amount) {
		this(amount, "PLN");
	}
	
	public Money(BigDecimal amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (currency == null ? 0 : currency.hashCode());
        result = prime * result + (amount == null ? 0 : amount.hashCode());
        return result;
	}
	
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
        
        if (currency == null) {
            if (other.currency != null) {
                return false;
            }
        } else if (!currency.equals(other.currency)) {
            return false;
        }
        
        if (amount == null) {
            if (other.amount != null) {
                return false;
            }
        } else if (!amount.equals(other.amount)) {
            return false;
        }
        
        return true;
	}
	
	
	public int compareTo(Money other) {	
		if(amount.compareTo(other.amount) > 0) {
			return 1;
		}
		
		if(amount.compareTo(other.amount) < 0) {
			return -1;
		}
		
		return 0;
	}
	
	public Money subtract(Money other) {	
		BigDecimal difference = amount.subtract(other.amount);
		
		return new Money(difference, currency);
	}
	
	public Money multiply(BigDecimal value) {
		BigDecimal product = amount.multiply(value);
		
		return new Money(product, currency);
	}
	
}
