package mx.com.alura.converter.core.converters;

import javax.swing.*;

import mx.com.alura.converter.data.TemperatureData;

/**
 * La clase TemperatureConverter se encarga de convertir temperaturas entre diferentes unidades de medida.
 */
public class TemperatureConverter {

    /**
     * Las unidades de medida disponibles para la conversión de temperatura.
     */
    private static final String[] UNITS = { "Celsius", "Fahrenheit", "Kelvin" };

    /**
     * El tipo de conversión que realiza esta clase.
     */
    private static final String CONVERSION_TYPE = "temperatura";

    /**
     * Convierte una cantidad de temperatura de una unidad de medida a otra.
     * @param amount La cantidad de temperatura a convertir.
     * @param sourceUnit La unidad de medida de la cantidad de temperatura a convertir.
     * @param targetUnit La unidad de medida a la que se desea convertir la cantidad de temperatura.
     */
    public void convert(double amount, String sourceUnit, String targetUnit) {
        double convertedAmount = 0;
        TemperatureData temperatureData = new TemperatureData();
        convertedAmount = temperatureData.getResult(amount, sourceUnit, targetUnit);

        JOptionPane.showMessageDialog(
                null,
                amount + " " + sourceUnit + " = " + convertedAmount + " " + targetUnit,
                "Resultado de la conversión",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Obtiene las unidades de medida disponibles para la conversión de temperatura.
     * @return Un arreglo de Strings con las unidades de medida disponibles.
     */
    public String[] getUnits() {
        return UNITS;
    }

    /**
     * Obtiene el tipo de conversión que realiza esta clase.
     * @return El tipo de conversión que realiza esta clase.
     */
    public String getConversionType() {
        return CONVERSION_TYPE;
    }

    /**
     * Muestra un diálogo para que el usuario seleccione la unidad de medida de origen para la conversión de temperatura.
     * @return La unidad de medida de origen seleccionada por el usuario.
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
     * Muestra un diálogo para que el usuario seleccione la unidad de medida de destino para la conversión de temperatura.
     * @return La unidad de medida de destino seleccionada por el usuario.
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
