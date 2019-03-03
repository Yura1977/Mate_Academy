package calc;

public class Converter {

    public static double getDecimalNumber(String number) {
        double result = 0;
        String[] symbolArray = number.split("");
        for (int i = 0; i < symbolArray.length - 1; i++) {
            if (getValue(symbolArray[i]) >= getValue(symbolArray[i + 1]))
                result += getValue(symbolArray[i]);
            else
                result = result + getValue(symbolArray[i + 1]) - getValue(symbolArray[i]);
        }
        result += getValue(symbolArray[symbolArray.length - 1]);
        return result;
    }

    public static StringBuilder getRomeNumber(double n) {
        int number = (int) n;
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

    private static StringBuilder getRomeNumberPart(String symbol, int amountOfSymbols) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < amountOfSymbols; i++) {
            result.append(symbol);
        }
        return result;
    }

    private static double getValue(String n) {
        if (n.equals("I"))
            return 1;
        if (n.equals("V"))
            return 5;
        if (n.equals("X"))
            return 10;
        if (n.equals("L"))
            return 50;
        if (n.equals("C"))
            return 100;
        if (n.equals("D"))
            return 500;
        if (n.equals("M"))
            return 1000;
        return -1;
    }
}
