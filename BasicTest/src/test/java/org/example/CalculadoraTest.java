package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {
    @Test
    @DisplayName("1+1=2")
    void sumarDosNumeros(){
        Calculadora c = new Calculadora();
        int esperado = 2;
        assertEquals(esperado, c.sumar(1,1));

    }

    @ParameterizedTest
    //@ValueSource
    @CsvSource({
            "1,1,2",
            "0,1,1",
            "-1,1,0"
    })
    void sumarDosNumerosParametrizados(int a, int b, int resultado){
    Calculadora c = new Calculadora();
    assertEquals(resultado, c.sumar(a,b));
    }
}
