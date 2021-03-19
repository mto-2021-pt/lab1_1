package pl.com.bottega.ecommerce.sales.domain.offer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Discount {

    private String cause;

    private Money value;

}
