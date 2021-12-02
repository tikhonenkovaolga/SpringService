package currency.currencyService;

import currency.model.CurrencyData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "exchangerates", url = "https://openexchangerates.org/api/")
public interface FeignCurrencyService {

    @GetMapping("/latest/{app_id}")
    CurrencyData getLatestRates(@RequestParam("app_id") String appId);


    @GetMapping("/historical/{date}/{app_id}")
    CurrencyData getRatesDayBefore(@PathVariable("date") String date, @RequestParam("app_id") String appId);

    boolean isRateIncreased(String codeCurrency);

}
