package es.etg.dam.controller;

import es.etg.dam.model.LanzadorModel;

public class LanzadorController {

    private final LanzadorModel model = new LanzadorModel();

    private static final String MSG_ERROR = "Error al lanzar el proceso: ";
    private static final String MSG_RESULTADO = "El proceso hijo dice: %s";
    private static final int NUMERO = 5;

    public static void main(String[] args) {
        LanzadorController controller = new LanzadorController();
        try {
            String resultado = controller.model.lanzar(NUMERO);
            System.out.println(String.format(MSG_RESULTADO, resultado));
        } catch (Exception e) {
            throw new RuntimeException(MSG_ERROR, e);
        }
    }
}
