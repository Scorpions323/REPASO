package es.etg.dam.exceptions;

public class NumeroInvalidoException extends CalculadoraException {
    public NumeroInvalidoException() {
        super("ERROR: número no válido");
    }
}