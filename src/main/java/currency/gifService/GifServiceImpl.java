package currency.gifService;

import currency.currencyService.FeignCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GifServiceImpl implements FeignGifService{

    private String apiKey = "Y60nrmyBSSumKWbPlJsLiZXgqoWRuV5k";
    private String codeCurrency;
    private FeignCurrencyService currencyService;
    @Autowired
    FeignGifService feignGifService;

    @Override
    public ResponseEntity<?> getGif(String apiKey, String tag) {
        if (currencyService.isRateIncreased(this.codeCurrency)){
            return feignGifService.getGif(this.apiKey, "rich");
        }
        return feignGifService.getGif(this.apiKey, "broke");
    }
}
