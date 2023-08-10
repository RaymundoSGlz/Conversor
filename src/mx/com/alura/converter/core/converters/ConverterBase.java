package mx.com.alura.converter.core.converters;

import javax.swing.*;

public class ConverterBase {
    private int type;

    public ConverterBase(int selectedType) {
        this.type = selectedType;
    }

    public void convert() {
        String amountString = JOptionPane.showInputDialog("Ingrese la cantidad a convertir:");
        double amount = Double.parseDouble(amountString);

        String conversionType = "";
        String[] units = null;

        if (type == 0) {
            CurrencyConverter currencyConverter = new CurrencyConverter();
            conversionType = currencyConverter.getConversionType();
            units = currencyConverter.getUnits();
        } else if (type == 1) {
            TemperatureConverter temperatureConverter = new TemperatureConverter();
            conversionType = temperatureConverter.getConversionType();
            units = temperatureConverter.getUnits();
        }

        String sourceUnit = selectUnit("origen", units, conversionType);
        if (sourceUnit == null) {
            JOptionPane.showMessageDialog(null, "Conversión de " + conversionType + " cancelada.");
            return;
        }

        String targetUnit = selectUnit("destino", units, conversionType);
        if (targetUnit == null) {
            JOptionPane.showMessageDialog(null, "Conversión de " + conversionType + " cancelada.");
            return;
        }

        // Lógica para realizar la conversión con las unidades seleccionadas
        if (type == 0) {
            CurrencyConverter currencyConverter = new CurrencyConverter();
            currencyConverter.convert(amount, sourceUnit, targetUnit);
        } else if (type == 1) {
            TemperatureConverter temperatureConverter = new TemperatureConverter();
            temperatureConverter.convert(amount, sourceUnit, targetUnit);
        }
    }

    private String selectUnit(String type, String[] units, String conversionType) {
        return (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la unidad de " + type + " para la conversión de " + conversionType + ":",
                "Seleccionar Unidad de " + type,
                JOptionPane.PLAIN_MESSAGE,
                null,
                units,
                units[0]
        );
    }
}
