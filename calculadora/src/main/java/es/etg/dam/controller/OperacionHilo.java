package es.etg.dam.controller;

import es.etg.dam.model.CalculadoraModel;
import es.etg.dam.model.ContadorOperaciones;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OperacionHilo extends Thread {

    private final CalculadoraModel model;
    private final ContadorOperaciones contadores;
    private final String operacion;
    private final double n1;
    private final double n2;

    private static final String RESULTADO = "Resultado: %.2f%n";
    private static final String MSG_ERROR = "Ha ocurrido un error: ";
    private static final String MSG_OPCION = "Opción no válida.";

    @Override
    public void run() {
        try {
            double resultado = switch (operacion) {
                case CalculadoraController.CUADRADO -> {
                    contadores.incrementarCuadrado();
                    yield model.cuadrado(n1);
                }
                case CalculadoraController.SUMA -> {
                    contadores.incrementarSuma();
                    yield model.suma(n1, n2);
                }
                case CalculadoraController.RESTA -> {
                    contadores.incrementarResta();
                    yield model.resta(n1, n2);
                }
                case CalculadoraController.MULTIPLICACION -> {
                    contadores.incrementarMultiplicacion();
                    yield model.multiplicacion(n1, n2);
                }
                case CalculadoraController.DIVISION -> {
                    contadores.incrementarDivision();
                    yield model.division(n1, n2);
                }
                default -> throw new IllegalArgumentException(MSG_OPCION);
            };

            System.out.printf(RESULTADO, resultado);

        } catch (Exception e) {
            throw new RuntimeException(MSG_ERROR, e);
        }
    }
}