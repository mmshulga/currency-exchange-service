package my.mmshulga.currencyexchangeservice.controllers;

import my.mmshulga.currencyexchangeservice.models.ExchangeValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-exchange/")
public class CurrencyExchangeController {

    @GetMapping("do")
    public ExchangeValue getExchangeValue(@RequestParam(value = "from") String from,
                                          @RequestParam(value = "to") String to) {
        ExchangeValue ev = new ExchangeValue();
        ev.setFrom(from);
        ev.setTo(to);
        ev.setId(1L);
        ev.setMultiplier(BigDecimal.valueOf(65));

        return ev;
    }
}
