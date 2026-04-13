package es.etg.dam.model;

public class CalculadoraModel {
    public static final String SUMA = "+";
    public static final String RESTA = "-";
    public static final String MULTIPLICACION = "*";
    public static final String DIVISION = "/";

    public static final String MSG_ERROR_OPERACION = "ERROR: operación no válida";
    public static final String MSG_ERROR_NUMERO = "ERROR: número no válido";
    public static final String MSG_ERROR_DIVISION = "ERROR: no se puede dividir entre 0";

    public String calcular(String num1, String operador, String num2) {

        double n1, n2;

        try {
            n1 = Double.parseDouble(num1);
            n2 = Double.parseDouble(num2);
        } catch (NumberFormatException e) {
            return MSG_ERROR_NUMERO;
        }

        return switch (operador) {
            case SUMA -> String.valueOf(n1 + n2);
            case RESTA -> String.valueOf(n1 - n2);
            case MULTIPLICACION -> String.valueOf(n1 * n2);
            case DIVISION -> n2 != 0 ? String.valueOf(n1 / n2) : MSG_ERROR_DIVISION;
            default -> MSG_ERROR_OPERACION;
        };
    }
}