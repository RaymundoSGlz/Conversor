package mx.com.alura.converter.data;

public class CurrencyData {

    public static double getExchangeRate(String sourceCurrency, String targetCurrency) {
        
        if (sourceCurrency == targetCurrency) {
            return 1;
        } else
        if (sourceCurrency.equals("MXN") && targetCurrency.equals("USD")) {
            return 0.052;
        } else if (sourceCurrency.equals("USD") && targetCurrency.equals("MXN")) {
            return 19.23;
        } else if (sourceCurrency.equals("MXN") && targetCurrency.equals("EUR")) {
            return 0.044;
        } else if (sourceCurrency.equals("EUR") && targetCurrency.equals("MXN")) {
            return 22.78;
        } else if (sourceCurrency.equals("USD") && targetCurrency.equals("EUR")) {
            return 0.85;
        } else if (sourceCurrency.equals("EUR") && targetCurrency.equals("USD")) {
            return 1.18;
        } else {
            return -1;
        }

    }
    
}
