package es.etg.dam;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import es.etg.dam.model.CalculadoraModel;
import es.etg.dam.exceptions.CalculadoraException;

@DisplayName("Tests CalculadoraS")
public class CalculadoraModelTest {

    private final CalculadoraModel model = new CalculadoraModel();

    @Test
    @DisplayName("Suma")
    void testSuma() throws CalculadoraException {
        assertEquals("7.0", model.calcular("3", "+", "4"));
        assertEquals("-1.0", model.calcular("-3", "+", "2"));
    }

    @Test
    @DisplayName("Resta")
    void testResta() throws CalculadoraException {
        assertEquals("-1.0", model.calcular("3", "-", "4"));
        assertEquals("5.0", model.calcular("2", "-", "-3"));
    }

    @Test
    @DisplayName("Multiplicación")
    void testMultiplicacion() throws CalculadoraException {
        assertEquals("12.0", model.calcular("3", "*", "4"));
        assertEquals("-12.0", model.calcular("-3", "*", "4"));
    }

    @Test
    @DisplayName("División")
    void testDivision() throws CalculadoraException {
        assertEquals("0.75", model.calcular("3", "/", "4"));
        assertEquals("2.5", model.calcular("5", "/", "2"));
    }

    @Test
    @DisplayName("División por 0")
    void testDivisionCero() {
        assertThrows(CalculadoraException.class, () -> {
            model.calcular("10", "/", "0");
        });
    }

    @Test
    @DisplayName("Número inválido")
    void testNumeroInvalido() {
        assertThrows(CalculadoraException.class, () -> {
            model.calcular("a", "+", "3");
        });
    }

    @Test
    @DisplayName("Operación inválida")
    void testOperacionInvalida() {
        assertThrows(CalculadoraException.class, () -> {
            model.calcular("3", "?", "4");
        });
    }
}