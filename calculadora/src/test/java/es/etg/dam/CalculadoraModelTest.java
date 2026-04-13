package es.etg.dam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import es.etg.dam.model.CalculadoraModel;

@DisplayName("Tests Calculadora")
public class CalculadoraModelTest {

    private final CalculadoraModel model = new CalculadoraModel();

    @Test
    @DisplayName("Suma")
    void testSuma() {
        assertEquals("7.0", model.calcular("3", "+", "4"));
        assertEquals("-1.0", model.calcular("-3", "+", "2"));
    }

    @Test
    @DisplayName("Resta")
    void testResta() {
        assertEquals("-1.0", model.calcular("3", "-", "4"));
        assertEquals("5.0", model.calcular("2", "-", "-3"));
    }

    @Test
    @DisplayName("Multiplicación")
    void testMultiplicacion() {
        assertEquals("12.0", model.calcular("3", "*", "4"));
        assertEquals("-12.0", model.calcular("-3", "*", "4"));
    }

    @Test
    @DisplayName("División")
    void testDivision() {
        assertEquals("0.75", model.calcular("3", "/", "4"));
        assertEquals("2.5", model.calcular("5", "/", "2"));
    }

    @Test
    @DisplayName("División por 0")
    void testDivisionCero() {
        assertEquals("ERROR: no se puede dividir entre 0",
                model.calcular("10", "/", "0"));
    }
}