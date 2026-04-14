package es.etg.dam.exceptions;

public class FormatoInvalidoException extends CalculadoraException {
    public FormatoInvalidoException() {
        super("ERROR: formato incorrecto");
    }
}