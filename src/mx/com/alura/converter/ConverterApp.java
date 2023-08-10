package mx.com.alura.converter;

import javax.swing.JFrame;

import mx.com.alura.converter.core.Converter;

public class ConverterApp {

    public static void main(String[] args) {
        Converter converter = new Converter();
        converter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
