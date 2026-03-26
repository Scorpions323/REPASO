package es.etg.dam;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import es.etg.dam.model.CalculadoraModel;

@DisplayName("Tests CalculadoraModel")
public class CalculadoraModelTest {
    private final CalculadoraModel model = new CalculadoraModel();

    @Test
    @DisplayName("Cuadrado")
    void testCuadrado() {
        assertEquals(25.0, model.cuadrado(5.0));
        assertEquals(0.0, model.cuadrado(0.0));
        assertEquals(9.0, model.cuadrado(-3.0));
    }

    @Test
    @DisplayName("Suma")
    void testSuma() {
        assertEquals(7.0, model.suma(3.0, 4.0));
        assertEquals(-1.0, model.suma(-3.0, 2.0));
    }

    @Test
    @DisplayName("Resta")
    void testResta() {
        assertEquals(-1.0, model.resta(3.0, 4.0));
        assertEquals(5.0, model.resta(2.0, -3.0));
    }

    @Test
    @DisplayName("Multiplicación")
    void testMultiplicacion() {
        assertEquals(12.0, model.multiplicacion(3.0, 4.0));
        assertEquals(-12.0, model.multiplicacion(-3.0, 4.0));
    }

    @Test
    @DisplayName("División")
    void testDivisionNormal() {
        assertEquals(0.75, model.division(3.0, 4.0));
        assertEquals(2.5, model.division(5.0, 2.0));
    }

    @Test
    @DisplayName("División por 0")
    void testDivisionCero() {
        assertThrows(IllegalArgumentException.class,
                () -> model.division(10.0, 0.0));
    }
}