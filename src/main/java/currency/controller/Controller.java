package currency.controller;

import currency.currencyService.FeignCurrencyService;
import currency.gifService.FeignGifService;
import currency.model.CurrencyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    FeignCurrencyService currencyService;
    @Autowired
    FeignGifService gifService;

    public Controller(FeignCurrencyService currencyService, FeignGifService gifService) {
        this.currencyService = currencyService;
        this.gifService = gifService;
    }

    @GetMapping("/latest/{app_id}")
    public CurrencyData getLatestRates(@RequestParam String appId) {
        return currencyService.getLatestRates(appId);
    }

    @GetMapping("/historical/{date}")
    public CurrencyData getRatesDayBefore(@PathVariable("date") String date, @RequestParam("app_id") String appId) {
        return currencyService.getRatesDayBefore(date, appId);
    }

    @GetMapping("/random/{api_key}/{tag}")
    public ResponseEntity<?> getGif(@RequestParam("api_key") String apiKey, @RequestParam("tag") String tag) {
        return gifService.getGif(apiKey, tag);
    }


}