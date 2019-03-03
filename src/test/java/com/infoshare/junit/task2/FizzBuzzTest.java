package com.infoshare.junit.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    FizzBuzz fizzBuzz0;

    private static Stream<Integer> dataProvider() {
        return Stream.of(5, 10, 20, 40, 100, 110, 11110);
    }

    private static Stream<Arguments> dataProviderAll() {
        return Stream.of(
                Arguments.arguments(1, "1"),
                Arguments.arguments(3, "Fizz!"),
                Arguments.arguments(5, "Buzz!"),
                Arguments.arguments(15, "FizzBuzz!")
        );
    }

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

    @ParameterizedTest(name="{index} - for {0} should return {1}")
    @MethodSource("dataProvider")
    void shouldReturnBuzzIfDivisibleBy5(int number) {
        String expectedResult = "Buzz!";
        String actualResult = fizzBuzz0.play(number);
        assertEquals(expectedResult, actualResult);
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

    @ParameterizedTest(name="{index} - for {0} should return {1}")
    @MethodSource("dataProviderAll")
    public void shouldReturnExpectedValue(int number, String expectedResult){
        String actualResult = fizzBuzz0.play(number);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name="{index} - for {0} should return {1}")
    @CsvFileSource(resources = "/test_data.csv", delimiter = ';', numLinesToSkip = 1)
    @CsvSource(value = {"110,Buzz!", "204,Fizz!"})
    public void shouldReturnExpectedValueFromCsv(int number, String expectedResult){
        String actualResult = fizzBuzz0.play(number);
        assertEquals(expectedResult, actualResult);
    }
}