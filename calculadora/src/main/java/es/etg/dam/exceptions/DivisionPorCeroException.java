package es.etg.dam.exceptions;

public class DivisionPorCeroException extends CalculadoraException {
    public DivisionPorCeroException() {
        super("ERROR: no se puede dividir entre 0");
    }
}