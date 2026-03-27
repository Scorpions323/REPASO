package es.etg.dam.model;

public class CalculadoraModel {

    private static final String MSG_ERROR = "No se puede dividir entre 0";

    public double cuadrado(double a) {
        return a * a;
    }

    public double suma(double a, double b) {
        return a + b;
    }

    public double resta(double a, double b) {
        return a - b;
    }

    public double multiplicacion(double a, double b) {
        return a * b;
    }

    public double division(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException(MSG_ERROR);
        }
        return a / b;
    }
}
