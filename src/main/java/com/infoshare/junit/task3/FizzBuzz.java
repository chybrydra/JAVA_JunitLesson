package com.infoshare.junit.task3;

public class FizzBuzz {

    String play(int number) {

        if (number < 0) {
            throw new ArithmeticException("Number cannot be negative!");
        }

        String result = "";

        if (isDivisibleBy(number, 3)) {
            result += "Fizz";
        }

        if (isDivisibleBy(number, 5)) {
            result += "Buzz";
        }

        if (result.length() == 0) {
            return String.valueOf(number);
        } else {
            return result + "!";
        }
    }

    private static boolean isDivisibleBy(int divident, int divisor){
        return divident % divisor == 0;
    }

}
