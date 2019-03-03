package com.infoshare.junit.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    FizzBuzz fizzBuzz0;

    @BeforeEach
    void initData(){
        fizzBuzz0 = new FizzBuzz();
    }

    @ParameterizedTest(name = "{arguments} - should be divisible by 3")
    @ValueSource(ints = {3, 6, 9, 12, 33, 99, 1000002})
    void shouldReturnFizzIfDivisibleBy3(int number) {
        String expectedResult = "Fizz!";
        String actualResult = fizzBuzz0.play(number);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnBuzzIfDivisibleBy5() {
        String result = fizzBuzz0.play(10);
        assertEquals("Buzz!", result);
    }

    @Test
    void shouldReturnFizzBuzzIfDivisibleBy3And5() {
        String result = fizzBuzz0.play(15);
        assertEquals("FizzBuzz!", result);
    }

    @Test
    void shouldReturnItselfIfNeitherDivibleBy3NorBy5() {
        String result = fizzBuzz0.play(16);
        assertEquals("16", result);
    }

    @Test
    public void shouldThrowArithmeticExceptionIfNumberLessThanZero(){
        Assertions.assertThrows(ArithmeticException.class, () -> fizzBuzz0.play(-1));
    }
}