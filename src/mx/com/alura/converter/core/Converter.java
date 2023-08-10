/**
 * Esta clase representa una aplicación de conversión de monedas y temperaturas.
 * Extiende JFrame y contiene un bucle while que muestra un cuadro de diálogo para seleccionar el tipo de conversión.
 * El usuario puede elegir entre conversión de monedas y de temperaturas.
 * La opción seleccionada se utiliza para crear una instancia de la clase ConverterBase y llamar a su método convert.
 * El programa continúa ejecutándose hasta que el usuario elige salir.
 */
package mx.com.alura.converter.core;

import javax.swing.*;

import mx.com.alura.converter.core.converters.ConverterBase;

public class Converter extends JFrame {

    /**
     * El constructor de la clase Converter muestra un cuadro de diálogo para
     * seleccionar el tipo de conversión. El usuario puede elegir entre conversión
     * de monedas y de temperaturas. La opción seleccionada se utiliza para crear
     * una instancia de la clase ConverterBase y llamar a su método convert. El
     * programa continúa ejecutándose hasta que el usuario elige salir.
     */
    public Converter() {
        boolean continueProgram = true;
        while (continueProgram) {
            String[] conversionOptions = { "Monedas", "Temperatura" };

            String selectedOption = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción de conversión:",
                    "Convertir",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    conversionOptions,
                    conversionOptions[0]);

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
            int continuar = JOptionPane.showConfirmDialog(null, "¿Deseas continuar usando el programa?", "",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (continuar == JOptionPane.NO_OPTION || continuar == JOptionPane.CANCEL_OPTION) {
                continueProgram = false;
                JOptionPane.showMessageDialog(null, "Programa Finalizado");
            }
        }
    }
}
