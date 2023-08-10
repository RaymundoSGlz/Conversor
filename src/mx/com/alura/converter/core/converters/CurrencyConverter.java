package mx.com.alura.converter.core.converters;

import javax.swing.*;

import mx.com.alura.converter.data.CurrencyData;

public class CurrencyConverter {

    private static final String[] UNITS = { "MXN", "USD", "EUR", "JPY", "GBP", "AUD", "CAD" };
    private static final String CONVERSION_TYPE = "moneda";

    public void convert(double amount, String sourceUnit, String targetUnit) {
        double exchangeRate = CurrencyData.getExchangeRate(sourceUnit, targetUnit);
        double convertedAmount = amount * exchangeRate;

        JOptionPane.showMessageDialog(
                null,
                amount + " " + sourceUnit + " = " + convertedAmount + " " + targetUnit,
                "Resultado de la conversión",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public String[] getUnits() {
        return UNITS;
    }

    public String getConversionType() {
        return CONVERSION_TYPE;
    }

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

