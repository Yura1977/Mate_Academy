package calculateWithLambdas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        testRomanConversion();
        Operation add = (x, y) -> x + y;
        Operation sub = (x, y) -> x - y;
        Operation div = (x, y) -> x / y;
        Operation multiple = (x, y) -> x * y;
        System.out.println("Enter first arabic number:");
        Scanner num = new Scanner(System.in);
        int x, y;
        x = num.nextInt();
        System.out.println("Enter second arabic number:");
        y = num.nextInt();
        System.out.println("First arabic number is: " + x + "\t =\t " + RomanNumber.toRoman(x));
        System.out.println("Second arabic number is: " + y + "\t =\t " + RomanNumber.toRoman(y));
        num.close();

        int resultAdd = add.calculate(x, y);
        int resultSub = sub.calculate(x, y);
        int resultDiv = div.calculate(x, y);
        int resultMultiple = multiple.calculate(x, y);

        System.out.println("Add = " + resultAdd + "(" + RomanNumber.toRoman(resultAdd) + ")"); // Add result
        System.out.println("Sub = " + resultSub + "(" + RomanNumber.toRoman(resultSub) + ")"); // Sub result
        System.out.println("Div = " + resultDiv + "(" + RomanNumber.toRoman(resultDiv) + ")"); // Div result
        System.out.println("Multiple = " + resultMultiple + "(" + RomanNumber.toRoman(resultMultiple) + ")"); // Multiple result
    }

    private static void testRomanConversion() {
    }
}

@FunctionalInterface
interface Operation {
    int calculate(int x, int y);
}
