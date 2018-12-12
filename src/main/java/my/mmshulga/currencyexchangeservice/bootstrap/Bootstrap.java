package my.mmshulga.currencyexchangeservice.bootstrap;

import my.mmshulga.currencyexchangeservice.models.ExchangeValue;
import my.mmshulga.currencyexchangeservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Bootstrap implements CommandLineRunner {
    private final ExchangeValueRepository exchangeValueRepository;

    @Autowired
    public Bootstrap(ExchangeValueRepository exchangeValueRepository) {
        this.exchangeValueRepository = exchangeValueRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        ExchangeValue eurToRub = new ExchangeValue();
        eurToRub.setFrom("EUR");
        eurToRub.setTo("RUB");
        eurToRub.setMultiplier(BigDecimal.valueOf(75));
        exchangeValueRepository.save(eurToRub);

        ExchangeValue eurToUsd = new ExchangeValue();
        eurToUsd.setFrom("EUR");
        eurToUsd.setTo("USD");
        eurToUsd.setMultiplier(BigDecimal.valueOf(1.1));
        exchangeValueRepository.save(eurToUsd);

        ExchangeValue usdToRub = new ExchangeValue();
        usdToRub.setFrom("USD");
        usdToRub.setTo("RUB");
        usdToRub.setMultiplier(BigDecimal.valueOf(66));
        exchangeValueRepository.save(usdToRub);
    }
}
