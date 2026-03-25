package es.etg.dam.controller;

import es.etg.dam.model.CalculadoraModel;

public class CalculadoraController {

    private static final CalculadoraModel model = new CalculadoraModel();

    private static final String RESULTADO = "%d";
    private static final String MSG_ERROR = "Error al ejecutar la calculadora";
    private static final int UNO = 1;

    public static void main(String[] args) {
        try {
            if (args.length != UNO) {
                System.exit(UNO);
            }
            ejecutar(args);
        } catch (Exception e) {
            System.exit(UNO);
        }
    }

    public static void ejecutar(String[] args) {
        try {
            int numero = Integer.parseInt(args[0]);
            int resultado = model.cuadrado(numero);
            System.out.println(String.format(RESULTADO, resultado));
        } catch (NumberFormatException e) {
            throw new RuntimeException(MSG_ERROR, e);
        }
    }
}
