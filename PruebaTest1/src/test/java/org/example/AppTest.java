package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AppTest {

    HashSet<Integer> hs;
    List<Integer> c;

    @BeforeEach
    void setUp(){
        hs= new HashSet<>();
        c= new ArrayList<>();
    }

    @AfterEach
    void tearDown(){
        hs= null;
        c= null;
    }
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    void hashSetSizeLessThanCollectionSize(){
        hs.addAll(List.of(1,2,3,4));
        c.addAll(List.of(1,2,3,5,6,7,8,9));

        //Para que el test esté OK todos los assert deben de estar OK
        /*
        assertTrue(hs.removeAll(c));
        assertEquals(1,hs.size());
        assertTrue(hs.contains(4));
        */

        //Si queremos juntar los diferentes assert para que nos diga si han fallado más de uno a la vez
        assertAll("hashSset",
                ()->assertTrue(hs.removeAll(c)),
                ()-> assertEquals(1,hs.size()),
                ()->assertTrue(hs.contains(4)));
    }

    @Test
    void hashSetSizeGreaterThanCollectionSize(){
        c.addAll(List.of(1,2,3,4));
        hs.addAll(List.of(1,2,3,5,6,7,8,9));
        assertTrue(hs.removeAll(c));
        assertEquals(5,hs.size());
    }

    @Test
    void whenCollectionIsNull(){
        c = null;
        hs.addAll(List.of(1,2,3));
        assertThrows(NullPointerException.class, ()->hs.removeAll(c));
    }

    @ParameterizedTest
    @MethodSource("generateCollectiosWithElements")
    void testWhenBothCollectionsHasSizeGreaterThan0(Set<Integer> hashSet, List<Integer> c, boolean expectedResult, int sizeResult){
        hs.addAll(hashSet);
        assertEquals(expectedResult, hs.removeAll(c));
        assertEquals(sizeResult, hs.size());
    }

    static Stream<Arguments> generateCollectiosWithElements(){
        return Stream.of(
                arguments(Set.of(1,2,3,4), List.of(1,2,3,5,6,7,8), true, 1),
                arguments(Set.of(1,2,3,5,6,7,8), List.of(1,2,3,4), true, 4),
                arguments(Set.of(), List.of(1), false, 0),
                arguments(Set.of(1,2,3,4),List.of(), false, 4)
        );
    }

}
