package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrianguloTest {

    Triangulo t;
    @BeforeEach
    void generateTriangulo(){
        t= new Triangulo();
    }

    @ParameterizedTest
    @MethodSource("generateValues")
    void testTipoTrianguloByValues(int a, int b, int c, TipoTriangulo resultado){
        assertEquals(t.tipoDeTriangulo(a,b,c), resultado);
    }

    static Stream<Arguments> generateValues(){
        return Stream.of(
                Arguments.arguments(1,1,1,TipoTriangulo.Equilatero),
                Arguments.arguments(0,0,0,TipoTriangulo.NoEsUnTriangulo),
                Arguments.arguments(1,1,0,TipoTriangulo.NoEsUnTriangulo),
                Arguments.arguments(1,0,0,TipoTriangulo.NoEsUnTriangulo),
                Arguments.arguments(1,0,1,TipoTriangulo.NoEsUnTriangulo),
                Arguments.arguments(0,0,1,TipoTriangulo.NoEsUnTriangulo),
                Arguments.arguments(0,1,1,TipoTriangulo.NoEsUnTriangulo),
                Arguments.arguments(0,1,0,TipoTriangulo.NoEsUnTriangulo),
                Arguments.arguments(1,2,1,TipoTriangulo.Isosceles),
                Arguments.arguments(2,1,1,TipoTriangulo.Isosceles),
                Arguments.arguments(1,1,2,TipoTriangulo.Isosceles),
                Arguments.arguments(3,2,1,TipoTriangulo.Escaleno),
                Arguments.arguments(1,2,3,TipoTriangulo.Escaleno),
                Arguments.arguments(2,3,1,TipoTriangulo.Escaleno)
        );
    }

}
