package my.mmshulga.currencyexchangeservice.controllers;

import my.mmshulga.currencyexchangeservice.models.ExchangeValue;
import my.mmshulga.currencyexchangeservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange/")
public class CurrencyExchangeController {

    private final Environment environment;
    private final ExchangeValueRepository exchangeValueRepository;

    @Autowired
    public CurrencyExchangeController(Environment environment, ExchangeValueRepository exchangeValueRepository) {
        this.environment = environment;
        this.exchangeValueRepository = exchangeValueRepository;
    }

    @GetMapping("do")
    public ExchangeValue getExchangeValue(@RequestParam(value = "from") String from,
                                          @RequestParam(value = "to") String to) {

        ExchangeValue ev = exchangeValueRepository.findByFromAndTo(from, to).orElseThrow(NullPointerException::new);
        ev.setPort(Integer.valueOf(environment.getProperty("local.server.port")));

        return ev;
    }
}
