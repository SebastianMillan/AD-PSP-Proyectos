package org.example;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    void test1(){
        HashSet<Integer> hs = new HashSet<>(List.of(1,2,3,4,5));
        Collection<Integer> c = Collections.emptyList();
        assertFalse(hs.removeAll(c));
    }

    @Test
    void test2(){
        HashSet<Integer> hs = new HashSet<>(List.of(1,2,3,4,5));
        Collection<Integer> c = Collections.unmodifiableCollection(List.of(1));
        assertTrue(hs.removeAll(c));
    }

    @Test
    void test3(){
        HashSet<Integer> hs = new HashSet<>(List.of(1,2,3,4,5));
        Collection<Integer> c = Collections.unmodifiableCollection(List.of(1,2,3,4,5));
        assertTrue(hs.removeAll(c));
    }

    @Test
    void test4(){
        HashSet<Integer> hs = new HashSet<>(Collections.emptyList());
        Collection<Integer> c = Collections.unmodifiableCollection(List.of(1,2,3,4,5));
        assertFalse(hs.removeAll(c));
    }

    @Test
    void test5(){
        HashSet<Integer> hs = new HashSet<>(List.of(6,7,8));
        Collection<Integer> c = Collections.unmodifiableCollection(List.of(1,2,3,4,5));
        assertFalse(hs.removeAll(c));
    }

    @Test
    void test6(){
        HashSet<Integer> hs = new HashSet<>(List.of(1,2,3,4));
        Collection<Integer> c = Collections.unmodifiableCollection(List.of(5,6,7));
        assertFalse(hs.removeAll(c));
    }

}
