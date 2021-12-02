package currency.model;

import java.util.Map;

public class CurrencyData {
    private String declaimer;
    private String license;
    private long timeStamp;
    private String baseCurrency;
    private Map<String, Double> rates;

    public void setDeclaimer(String declaimer) {
        this.declaimer = declaimer;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public String getDeclaimer() {
        return declaimer;
    }

    public String getLicense() {
        return license;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public Map<String, Double> getRates() {
        return rates;
    }
}
