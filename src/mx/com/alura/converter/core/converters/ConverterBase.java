/**
 * Esta clase representa un conversor base que puede convertir tanto monedas como temperaturas.
 * Solicita al usuario que ingrese la cantidad a convertir y luego selecciona el tipo de conversión y las unidades.
 * Luego realiza la conversión utilizando las unidades y el tipo de conversión seleccionados.
 */
package mx.com.alura.converter.core.converters;

import javax.swing.*;

public class ConverterBase {
    private int type;

    /**
     * Constructor de la clase ConverterBase.
     * @param selectedType El tipo de conversión seleccionado (0 para moneda, 1 para temperatura).
     */
    public ConverterBase(int selectedType) {
        this.type = selectedType;
    }

    /**
     * Método que realiza la conversión de la cantidad ingresada por el usuario.
     */
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

    /**
     * Método que muestra un diálogo para que el usuario seleccione la unidad de origen o destino para la conversión.
     * @param type El tipo de unidad que se está seleccionando (origen o destino).
     * @param units Las unidades disponibles para la conversión.
     * @param conversionType El tipo de conversión que se está realizando (moneda o temperatura).
     * @return La unidad seleccionada por el usuario.
     */
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
