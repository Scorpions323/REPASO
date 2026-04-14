package es.etg.dam.exceptions;

public class MensajeVacioException extends CalculadoraException {
    public MensajeVacioException() {
        super("ERROR: mensaje vacío");
    }
}