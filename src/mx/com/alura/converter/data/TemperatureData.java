package mx.com.alura.converter.data;

/**
 * La clase TemperatureData se utiliza para convertir temperaturas entre diferentes unidades de medida.
 */
public class TemperatureData {

    /**
     * Convierte una cantidad de temperatura de una unidad de medida a otra.
     * @param amount La cantidad de temperatura a convertir.
     * @param sourceUnit La unidad de medida de la cantidad de temperatura proporcionada.
     * @param targetUnit La unidad de medida a la que se debe convertir la cantidad de temperatura.
     * @return La cantidad de temperatura convertida en la unidad de medida especificada.
     */
    public double getResult(double amount, String sourceUnit, String targetUnit) {
        double convertedAmount = 0;
        if (sourceUnit.equals(targetUnit)) {
            convertedAmount = amount;
        } else if (sourceUnit.equals("Celsius")) {
            if (targetUnit.equals("Fahrenheit")) {
                convertedAmount = (amount * 9 / 5) + 32;
            } else if (targetUnit.equals("Kelvin")) {
                convertedAmount = amount + 273.15;
            }
        } else if (sourceUnit.equals("Fahrenheit")) {
            if (targetUnit.equals("Celsius")) {
                convertedAmount = (amount - 32) * 5 / 9;
            } else if (targetUnit.equals("Kelvin")) {
                convertedAmount = (amount + 459.67) * 5 / 9;
            }
        } else if (sourceUnit.equals("Kelvin")) {
            if (targetUnit.equals("Celsius")) {
                convertedAmount = amount - 273.15;
            } else if (targetUnit.equals("Fahrenheit")) {
                convertedAmount = (amount * 9 / 5) - 459.67;
            }
        }
        return convertedAmount;
    }

}
