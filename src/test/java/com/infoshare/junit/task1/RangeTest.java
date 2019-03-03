package com.infoshare.junit.task1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {

    Range range0;

    @BeforeAll
    public static void initAll(){
        System.out.println("Before all");
    }

    @BeforeEach
    public void initRanges(){
        range0= new Range(10, 20);
    }

    @Test
    public void shouldReturnTrueIfNumberInRange() {
        boolean result = range0.isInRange(10);
        assertTrue(result, "Number is out of range!");
        result = range0.isInRange(20);
        assertTrue(result, "Number is out of range!");
    }

    @Test
    public void shouldReturnFalseIfNumberNotInRange(){
        boolean result = range0.isInRange( 9);
        assertFalse(result, "Number is in range!");
        result = range0.isInRange( 21);
        assertFalse(result, "Number is in range!");
    }
}