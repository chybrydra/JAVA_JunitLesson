package com.infoshare.junit.task3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FizzBuzzTest {

    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void shouldReturnFizzWhenDivisbleBy3(){
        Assertions.assertThat(fizzBuzz.play(6))
                .isNotBlank()
                .isEqualTo("Fizz!");
    }

    @Test
    public void shouldReturnBuzzWhenDivisibleBy5(){
        Assertions.assertThat(fizzBuzz.play(10)).isEqualTo("Buzz!");
    }

    @Test
    public void shouldReturnBuzzWhenDivisibleBy3And5(){
        Assertions.assertThat(fizzBuzz.play(105)).isEqualTo("FizzBuzz!");
    }

    @Test
    public void shouldThrowExceptionForNegativeNumber(){
        int number = -1;
        Assertions.assertThatThrownBy(() -> fizzBuzz.play(number))
                .isInstanceOf(ArithmeticException.class);
    }
}