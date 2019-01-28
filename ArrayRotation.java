// Java program to rotate an array of length n by
// k elements

import java.util.Arrays;

public class ArrayRotation {
    /*Function to left rotate arr[] of length n by k */
    private int[] rotateArray(int[] arr, int n, int k) {
        int[] result = new int[arr.length];
        int remainingElem = arr.length - k;
        for (int i = 0; i < remainingElem; i++) {
            result[i] = arr[i + k];
        }
        for (int i = 0; i < k; i++) {
            result[i + remainingElem] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayRotation rotate = new ArrayRotation();
        int[] arr = {
                5, 6, 1, 2, 6
        };
        System.out.println(Arrays.toString(arr) + " - Original Array");
        arr = rotate.rotateArray(arr, 5, 2);
        System.out.println("\n" + Arrays.toString(arr) + " - Modified Array");
    }
}
