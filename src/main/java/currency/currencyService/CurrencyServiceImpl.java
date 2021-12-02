package currency.currencyService;

import currency.model.CurrencyData;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Service
public class CurrencyServiceImpl implements FeignCurrencyService {
    private CurrencyData currencyData;
    private String appId = "5b391bd1010347efbb4c112175c05f47";

    FeignCurrencyService feignCurrencyService;

    @Override
    public CurrencyData getLatestRates(String appId) {
        currencyData = feignCurrencyService.getLatestRates(this.appId);
        return currencyData;
    }

    @Override
    public CurrencyData getRatesDayBefore(String date, String appId) {
        String dayBeforeDate = getDate(this.currencyData.getTimeStamp());
        return feignCurrencyService.getRatesDayBefore(dayBeforeDate, this.appId);
    }

    @Override
    public boolean isRateIncreased(String codeCurrency) {
        Double latestRate = 0.0;
        Double historicalRate = 0.0;
        Map<String, Double> rates = getLatestRates(this.appId).getRates();
        if (rates.containsKey(codeCurrency)) {
            latestRate = rates.get(codeCurrency);
        }
        Map<String, Double> yesterdayRates = getRatesDayBefore(getDate(this.currencyData.getTimeStamp()), this.appId).getRates();
        if (yesterdayRates.containsKey(codeCurrency)) {
            historicalRate = yesterdayRates.get(codeCurrency);
        }
        return latestRate >= historicalRate;
    }

    public String getDate(long unix) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date latestDate = new Date(unix * 1000);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(latestDate);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return simpleDateFormat.format(latestDate);
    }


}
