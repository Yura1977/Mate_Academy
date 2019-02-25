package com.calculator;

import java.util.Scanner;

class ArabRomeCalculator {
    void run() {
        int[] numbers = new int[10];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        String value1 = scanner.nextLine();
        numbers[0] = (!isDecimal(value1) ? getDecimalNumber(value1) : Integer.parseInt(value1));
        System.out.print("Enter second number: ");
        String value2 = scanner.nextLine();
        numbers[1] = (isDecimal(value2) ? Integer.parseInt(value2) : getDecimalNumber(value2));

        if (numbersAreOfDifferentType(value1, value2)) {
            System.out.println("Number have to be the same type!");
            return;
        }
        Operation expression = new Operation() {
            @Override
            public int calculate(int value11, int value21) {
                return ((value11 * value21) + value11 - value21) / value11;
            }
        };
        int result = expression.calculate(numbers[0], numbers[1]);
        System.out.print(value1 + ", " + value2 + " = ");
        System.out.println(isDecimal(value1) ? result : getRomeNumber(result));
    }

    private int getDecimalNumber(String number) {
        int result = 0;
        final int len = number.length();
        for (int i = 0; i < len - 1; i++) {
            if (getValue(number.charAt(i)) >= getValue(number.charAt(i + 1)))
                result += getValue(number.charAt(i));
            else
                result = result + getValue(number.charAt(i + 1)) - getValue(number.charAt(i));
        }
        result += getValue(number.charAt(len - 1));
        return result;
    }

    private StringBuilder getRomeNumber(int n) {
        int number = n;
        if (number <= 0) {
            System.out.println("Number couldn't be negative!");
            return new StringBuilder();
        }
        StringBuilder result = new StringBuilder();
        if (number >= 1000) {
            result.append(getRomeNumberPart("M", number / 1000));
            number %= 1000;
        }
        if (number >= 500 && number < 900) {
            result.append(getRomeNumberPart("D", number / 500));
            number %= 500;
        }
        if (number >= 500) {
            result.append("CM");
            number %= 100;
        }
        if (number >= 100 && number < 400) {
            result.append(getRomeNumberPart("C", number / 100));
            number %= 100;
        }
        if (number >= 100) {
            result.append("CD");
            number %= 100;
        }
        if (number >= 50 && number < 90) {
            result.append(getRomeNumberPart("L", number / 50));
            number %= 50;
        }
        if (number >= 50) {
            result.append("XC");
            number %= 50;
        }
        if (number >= 10 && number < 40) {
            result.append(getRomeNumberPart("X", number / 10));
            number %= 10;
        }
        if (number >= 10) {
            result.append("XL");
            number %= 10;
        }
        if (number >= 5 && number < 9) {
            result.append(getRomeNumberPart("V", number / 5));
            number %= 5;
        }
        if (number >= 5) {
            result.append("V");
            number %= 5;
        }
        if (number >= 1 && number < 4) {
            result.append(getRomeNumberPart("I", number));
            number = 0;
        }
        if (number >= 1) {
            result.append("IV");
        }
        return result;
    }

    private StringBuilder getRomeNumberPart(String symbol, int amountOfSymbols) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < amountOfSymbols; i++) {
            result.append(symbol);
        }
        return result;
    }

    private boolean numbersAreOfDifferentType(String value1, String value2) {
        return (isDecimal(value1) ^ isDecimal(value2));
    }

    private boolean isDecimal(String value) {
        return value.matches("-*[0-9]+|[0-9]+");
    }

    private int getValue(char symbol) {
        if (symbol == 'I') {
            return 1;
        }
        if (symbol == 'V') {
            return 5;
        }
        if (symbol == 'X') {
            return 10;
        }
        if (symbol == 'L') {
            return 50;
        }
        if (symbol == 'C') {
            return 100;
        }
        if (symbol == 'D') {
            return 500;
        }
        if (symbol == 'M') {
            return 1000;
        }
        return -1;
    }
}

@FunctionalInterface
interface Operation {
    int calculate(int value1, int value2);
}
