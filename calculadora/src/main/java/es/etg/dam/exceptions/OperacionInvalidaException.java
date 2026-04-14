package es.etg.dam.exceptions;

public class OperacionInvalidaException extends CalculadoraException {
    public OperacionInvalidaException() {
        super("ERROR: operación no válida");
    }
}