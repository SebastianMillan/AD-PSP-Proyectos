package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTest {

    @BeforeAll
    static void initAll(){
        System.out.println("Al principio de todo");
    }

    @BeforeEach
    void init(){
        System.out.println("Antes de un test");
    }

    @Test
    void test1(){
        System.out.println("test1");
        assertTrue(true);
    }

    @Test
    void test2(){
        System.out.println("test2");
    }

    @Test
    @Disabled
    void test3(){
        System.out.println("Deshabilitado");
    }

    @AfterEach
    void tearDown(){
        System.out.println("Despues de un test");
    }

    @AfterAll
    static void tearDownAll(){
        System.out.println("Al final de todo");
    }

}
