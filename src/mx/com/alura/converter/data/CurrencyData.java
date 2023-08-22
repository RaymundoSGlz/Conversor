package mx.com.alura.converter.data;

import java.util.Map;
import java.util.HashMap;

/**
 * La clase CurrencyData almacena los tipos de cambio entre las divisas y el peso mexicano, así como los nombres de las divisas.
 */
public class CurrencyData {
    // Mapa que almacena los tipos de cambio entre las divisas y el peso mexicano
    private static final Map<String, Double> exchangeRates = new HashMap<>();
    // Bloque estático para inicializar el mapa con los valores
    static {
        exchangeRates.put("USD", 0.058);
        exchangeRates.put("EUR", 0.049);
        exchangeRates.put("JPY", 6.35);
        exchangeRates.put("GBP", 0.042);
        exchangeRates.put("AUD", 0.079);
        exchangeRates.put("CAD", 0.073);
        exchangeRates.put("KRW", 66.64);
        exchangeRates.put("CNY", 0.37);
        exchangeRates.put("HKD", 0.45);
    }

    /**
     * Devuelve el tipo de cambio entre dos divisas.
     * @param sourceCurrency La divisa de origen.
     * @param targetCurrency La divisa de destino.
     * @return El tipo de cambio entre las dos divisas.
     */
    public static double getExchangeRate(String sourceCurrency, String targetCurrency) {
        if (sourceCurrency.equals(targetCurrency)) {
            return 1;
        }
        if (sourceCurrency.equals("MXN")) {
            return exchangeRates.get(targetCurrency);
        } else if (targetCurrency.equals("MXN")) {
            return 1 / exchangeRates.get(sourceCurrency);
        } else {
            return exchangeRates.get(targetCurrency) / exchangeRates.get(sourceCurrency);
        }
    }
    // Método que devuelve los nombres de las divisas
    private static final Map<String, String> currencyNames = new HashMap<>();
    // Bloque estático para inicializar el mapa con los valores
    static {
        currencyNames.put("MXN", "Pesos Mexicanos");
        currencyNames.put("USD", "Dólares Estadounidenses");
        currencyNames.put("EUR", "Euros");
        currencyNames.put("JPY", "Yenes Japoneses");
        currencyNames.put("GBP", "Libras Esterlinas");
        currencyNames.put("AUD", "Dólares Australianos");
        currencyNames.put("CAD", "Dólares Canadienses");
        currencyNames.put("KRW", "Won's Surcoreanos");
        currencyNames.put("CNY", "Yuan's Chinos");
        currencyNames.put("HKD", "Dólares de Hong Kong");
    }

    /**
     * Devuelve el nombre de una divisa.
     * @param currency La divisa de la que se quiere obtener el nombre.
     * @return El nombre de la divisa.
     */
    public static String getCurrencyName(String currency) {
        return currencyNames.get(currency);
    }

}