/**
 * La clase ConverterApp es la clase principal del programa,
 * la cual se encarga de crear una instancia de la clase Converter
 * y de establecer la operación que se realizará al cerrar la ventana de la aplicación.
 *
 * @author Raymundo Gonzalez
 * @version 1.0.0
 * @since 10/08/2023
 * @see Converter
 */
package mx.com.alura.converter;

import javax.swing.JFrame;

import mx.com.alura.converter.core.Converter;

public class ConverterApp {

    public static void main(String[] args) {
        Converter converter = new Converter();
        converter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
