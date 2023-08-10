package mx.com.alura.converter.core.converters;

import javax.swing.*;

import mx.com.alura.converter.data.CurrencyData;

/**
 * La clase CurrencyConverter se encarga de realizar la conversión de monedas.
 */
public class CurrencyConverter {

    /**
     * Arreglo de unidades de moneda disponibles para la conversión.
     */
    private static final String[] UNITS = { "MXN", "USD", "EUR", "JPY", "GBP", "AUD", "CAD", "KRW", "CNY", "HKD" };

    /**
     * Tipo de conversión que se realiza.
     */
    private static final String CONVERSION_TYPE = "moneda";

    /**
     * Realiza la conversión de una cantidad de una unidad de origen a una unidad de destino.
     * @param amount Cantidad a convertir.
     * @param sourceUnit Unidad de origen.
     * @param targetUnit Unidad de destino.
     */
    public void convert(double amount, String sourceUnit, String targetUnit) {
        double exchangeRate = CurrencyData.getExchangeRate(sourceUnit, targetUnit);
        double convertedAmount = amount * exchangeRate;
        String sourceUnitName = CurrencyData.getCurrencyName(sourceUnit);
        String targetUnitName = CurrencyData.getCurrencyName(targetUnit);

        JOptionPane.showMessageDialog(
                null,
                amount + " " + sourceUnitName + " = " + convertedAmount + " " + targetUnitName,
                "Resultado de la conversión",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Obtiene las unidades de moneda disponibles para la conversión.
     * @return Arreglo de unidades de moneda.
     */
    public String[] getUnits() {
        return UNITS;
    }

    /**
     * Obtiene el tipo de conversión que se realiza.
     * @return Tipo de conversión.
     */
    public String getConversionType() {
        return CONVERSION_TYPE;
    }

    /**
     * Muestra un diálogo para seleccionar la unidad de origen para la conversión.
     * @return Unidad de origen seleccionada.
     */
    public String selectSourceUnit() {
        return (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la unidad de origen para la conversión de " + CONVERSION_TYPE + ":",
                "Seleccionar Unidad de Origen",
                JOptionPane.PLAIN_MESSAGE,
                null,
                UNITS,
                UNITS[0]
        );
    }

    /**
     * Muestra un diálogo para seleccionar la unidad de destino para la conversión.
     * @return Unidad de destino seleccionada.
     */
    public String selectTargetUnit() {
        return (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la unidad de destino para la conversión de " + CONVERSION_TYPE + ":",
                "Seleccionar Unidad de Destino",
                JOptionPane.PLAIN_MESSAGE,
                null,
                UNITS,
                UNITS[0]
        );
    }
}
