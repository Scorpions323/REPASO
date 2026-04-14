package es.etg.dam.exceptions;

public class HashInvalidoException extends CalculadoraException {
    public HashInvalidoException() {
        super("ERROR: datos corruptos");
    }
}