import java.util.Arrays;


public class Ranges {
    public static void main(String[] args) {

        int array[] = { 1,2,3,5,8,9,10,13,14,15,16 };//1 2 3 5 8 9 10 13 14 15 16
        System.out.println(Arrays.toString(array) + " - Original Array");
        System.out.println(arrayRanges(array) + " - New Array");
}

    public static <overwrite> String arrayRanges(int[] array) {
        StringBuilder result = new StringBuilder();
        int minValue = array[0];
        int maxValue;
        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i - 1] > 1) {
                maxValue = array[i - 1];
                if (maxValue == minValue) {
                    result.append("[").append(minValue).append("]");
                } else {
                    result.append("[").append(minValue).append(" ").append(maxValue).append("]");
                }
                minValue = array[i];
            }
        }
        boundary(result, minValue, array[array.length - 1]);

        return result.toString();
    }

    public static void boundary (StringBuilder sb, int minValue, int maxValue){

        sb.append("[").append(minValue);
        if (maxValue != minValue) {
            sb.append(" ").append(maxValue);
        }
        sb.append("]");

    }

}