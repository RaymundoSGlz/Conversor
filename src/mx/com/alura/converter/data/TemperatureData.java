package mx.com.alura.converter.data;

public class TemperatureData {

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
