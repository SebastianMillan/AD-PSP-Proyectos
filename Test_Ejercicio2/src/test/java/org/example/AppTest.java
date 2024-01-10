package org.example;

import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.AfterEach;
import com.badlogic.gdx.utils.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Array<Integer> c1;
    Array<Integer> c2;

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @BeforeEach
    void setUp() {
        c1 = new Array<>();
        c2 = new Array<>();
    }

    @AfterEach
    void tearDown() {
        c1 = null;
        c2 = null;
    }

    @ParameterizedTest
    @MethodSource("generateCollectiosWithElements")
    void testWhenCollectionContainsSomething(Array<Integer> c1Generated, Integer value, boolean identity, boolean result) {
        c1.addAll(c1Generated);
        assertEquals(c1.contains(value, identity), result);
    }

    static Stream<Arguments> generateCollectiosWithElements() {
        return Stream.of(
                Arguments.arguments(Array.with(1, 2, 3), null, false, false),
                Arguments.arguments(Array.with(null, null, null), null, false, true),
                Arguments.arguments(Array.with(1, 2, 3), 1, false, true),
                Arguments.arguments(Array.with(1, 2, 3), 0, true, false),
                Arguments.arguments(Array.with(1, 2, 3), -1, false, false),
                Arguments.arguments(Array.with(1), null, true, false),
                Arguments.arguments(Array.with(2, 3, 4), 1, true, false),
                Arguments.arguments(Array.with(), 1, false, false),
                Arguments.arguments(Array.with(), 0, false, false),
                Arguments.arguments(Array.with(), null, true, false)
        );
    }

    @Test
    void testWhenCollectionIsNull(){
        c1=null;
        assertThrows(NullPointerException.class, ()->c1.contains(1, true));
    }

}