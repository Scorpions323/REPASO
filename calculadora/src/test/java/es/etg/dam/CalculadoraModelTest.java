package es.etg.dam;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import es.etg.dam.model.CalculadoraModel;

@DisplayName("Tests CalculadoraModel")
public class CalculadoraModelTest {

    private final CalculadoraModel model = new CalculadoraModel();

    @Test
    @DisplayName("5 al cuadrado es 25")
    void cuadrado_5_retorna25() {
        assertEquals(25, model.cuadrado(5));
    }

    @Test
    @DisplayName("0 al cuadrado es 0")
    void cuadrado_0_retorna0() {
        assertEquals(0, model.cuadrado(0));
    }

    @Test
    @DisplayName("(-3) al cuadrado es 9")
    void cuadrado_negativo3_retorna9() {
        assertEquals(9, model.cuadrado(-3));
    }
}