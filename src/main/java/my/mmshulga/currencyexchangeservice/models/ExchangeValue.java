package my.mmshulga.currencyexchangeservice.models;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ExchangeValue {
    private Long id;
    private String from;
    private String to;
    private BigDecimal multiplier;
}
