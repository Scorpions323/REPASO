package es.etg.dam.model;

import lombok.Getter;
import lombok.Synchronized;

@Getter
public class ContadorOperaciones {
    private int cuadrado = 0;
    private int suma = 0;
    private int resta = 0;
    private int multiplicacion = 0;
    private int division = 0;

    @Synchronized
    public void incrementarCuadrado() {
        cuadrado++;
    }

    @Synchronized
    public void incrementarSuma() {
        suma++;
    }

    @Synchronized
    public void incrementarResta() {
        resta++;
    }

    @Synchronized
    public void incrementarMultiplicacion() {
        multiplicacion++;
    }

    @Synchronized
    public void incrementarDivision() {
        division++;
    }
}