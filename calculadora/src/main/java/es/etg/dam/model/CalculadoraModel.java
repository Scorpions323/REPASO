package es.etg.dam.model;

import es.etg.dam.exceptions.*;

public class CalculadoraModel {
    public static final String SUMA = "+";
    public static final String RESTA = "-";
    public static final String MULTIPLICACION = "*";
    public static final String DIVISION = "/";

    public String calcular(String num1, String operador, String num2) throws CalculadoraException {

        double n1, n2;

        try {
            n1 = Double.parseDouble(num1);
            n2 = Double.parseDouble(num2);
        } catch (NumberFormatException e) {
            throw new NumeroInvalidoException();
        }

        return switch (operador) {
            case SUMA -> String.valueOf(n1 + n2);
            case RESTA -> String.valueOf(n1 - n2);
            case MULTIPLICACION -> String.valueOf(n1 * n2);
            case DIVISION -> {
                if (n2 == 0)
                    throw new DivisionPorCeroException();
                yield String.valueOf(n1 / n2);
            }
            default -> throw new OperacionInvalidaException();
        };
    }
}