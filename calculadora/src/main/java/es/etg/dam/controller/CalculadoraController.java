package es.etg.dam.controller;

import es.etg.dam.model.CalculadoraModel;

public class CalculadoraController {

    private final CalculadoraModel model = new CalculadoraModel();

    public String procesar(String operacion) {

        String[] partes = operacion.trim().split(" ");

        if (partes.length != 3) {
            return CalculadoraModel.MSG_ERROR_OPERACION;
        }

        return model.calcular(partes[0], partes[1], partes[2]);
    }
}