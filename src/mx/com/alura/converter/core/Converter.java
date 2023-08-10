package mx.com.alura.converter.core;

import javax.swing.*;

import mx.com.alura.converter.core.converters.ConverterBase;

public class Converter extends JFrame {

    public Converter() {
        String[] conversionOptions = { "Monedas", "Temperatura" };

        String selectedOption = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione una opción de conversión:",
                "Convertir",
                JOptionPane.PLAIN_MESSAGE,
                null,
                conversionOptions,
                conversionOptions[0]
        );

        if (selectedOption == null) {
            JOptionPane.showMessageDialog(null, "Programa Cerrado");
            System.exit(0);
        }

        if (selectedOption.equals(conversionOptions[0])) {
            ConverterBase currencyConverter = new ConverterBase(0);
            currencyConverter.convert();
        } else if (selectedOption.equals(conversionOptions[1])) {
            ConverterBase temperatureConverter = new ConverterBase(1);
            temperatureConverter.convert();
        }
    }
}
