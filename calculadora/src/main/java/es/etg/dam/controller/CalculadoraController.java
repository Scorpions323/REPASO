package es.etg.dam.controller;

import es.etg.dam.model.CalculadoraModel;
import es.etg.dam.exceptions.CalculadoraException;

public class CalculadoraController {

    private final CalculadoraModel model = new CalculadoraModel();

    public String procesar(String operacion) {
        try {
            String[] p = operacion.split(" ");
            return model.calcular(p[0], p[1], p[2]);
        } catch (CalculadoraException e) {
            return e.getMessage();
        }
    }
}