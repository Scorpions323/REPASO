package es.etg.dam.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import es.etg.dam.model.CalculadoraModel;

public class CalculadoraController {

    private static final CalculadoraModel model = new CalculadoraModel();
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final String MSG_MENU = """
            Menu:
            1. Cuadrado
            2. Suma
            3. Resta
            4. Multiplicación
            5. División
            0. Salir
            Elige una opción: """;
    private static final String CUADRADO = "Cuadrado: %.0f%n";
    private static final String SUMA = "Suma: %.0f%n";
    private static final String RESTA = "Resta: %.0f%n";
    private static final String MULTIPLICACION = "Multiplicación: %.0f%n";
    private static final String DIVISION = "División: %.0f%n";

    private static final String SALIR = "Saliendo...";
    private static final String MSG_ERROR = "Opción inválida";

    public static void main(String[] args) throws IOException {
        String op;
        do {
            System.out.print(MSG_MENU);
            op = reader.readLine().trim();

            switch (op) {
                case "1" -> {
                    try {
                        System.out.print("Número: ");
                        String num = reader.readLine().trim();
                        double n = Double.parseDouble(num);
                        System.out.printf(CUADRADO, model.cuadrado(n));
                    } catch (NumberFormatException e) {
                        System.out.println("Error: introduce un número válido.");
                    }
                }
                case "2" -> operarBinaria(SUMA, "suma");
                case "3" -> operarBinaria(RESTA, "resta");
                case "4" -> operarBinaria(MULTIPLICACION, "multiplicacion");
                case "5" -> operarBinaria(DIVISION, "division");
                case "0" -> System.out.println(SALIR);
                default -> System.out.println(MSG_ERROR);
            }
        } while (!op.equals("0"));
    }

    private static void operarBinaria(String formato, String tipo) throws IOException {
        try {
            System.out.print("Número 1: ");
            String num1 = reader.readLine().trim();
            System.out.print("Número 2: ");
            String num2 = reader.readLine().trim();

            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);

            double resultado = switch (tipo) {
                case "suma" -> model.suma(n1, n2);
                case "resta" -> model.resta(n1, n2);
                case "multiplicacion" -> model.multiplicacion(n1, n2);
                case "division" -> model.division(n1, n2); // aquí puede saltar IllegalArgumentException
                default -> 0;
            };

            System.out.printf(formato, resultado);
        } catch (NumberFormatException e) {
            System.out.println("Error: introduce números válidos.");
        } catch (IllegalArgumentException e) {
            // 👉 aquí capturas "No se puede dividir por 0"
            System.out.println("Error: " + e.getMessage());
        }
        // Al salir del método, el bucle do-while de main sigue y vuelve al menú
    }
}
