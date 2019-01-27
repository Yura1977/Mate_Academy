// Java program to rotate an array of length n by
// d elements

import java.util.Arrays;

public class ArrayRotation {

    /*Function to left rotate arr[] of length n by d */
    private int[] rotateArray(int[] arr, int n, int d){

        int[] result = new int[arr.length];
        int remainingElem = arr.length - d;

        for (int i = 0; i < remainingElem; i++){
            result[i] = arr[i + d];
        }

        for (int i = 0; i < d; i++) {
            result[i + remainingElem] = arr[i];
        }
        return result;

    }
        public static void main(String[] args){
        ArrayRotation rotate = new ArrayRotation();
        int[] arr = { 5, 6, 1, 2, 6 };
        System.out.println(Arrays.toString(arr) + " - Original Array");
        arr = rotate.rotateArray(arr, 5, 2);
        System.out.print("");
        System.out.println("\n"+ Arrays.toString(arr) + " - Modified Array");

        }
}

