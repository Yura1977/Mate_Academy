// Java program to rotate an array by
// d elements

import java.util.Arrays;

class Array_Rotation {
    /*Function to left rotate arr[] of size n by d*/
    void leftRotate(int arr[], int d, int n)
    {

        for (int i = 0; i < d; i++)

            leftRotatebyOne(arr, n);

    }

    void leftRotatebyOne(int arr[], int n)
    {
        int i, temp;
        temp = arr[0];
        for (i = 0; i < n - 1; i++)
            arr[i] = arr[i + 1];
        arr[i] = temp;
//        System.out.println(arr[i]);
    }

    /* utility function to print an array */
    void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)

            System.out.print("" );
            System.out.println("\n"+ Arrays.toString(arr) + " - Modified Array");
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        Array_Rotation rotate = new Array_Rotation();
        int arr[] = { 5, 6, 1, 2, 6 };
        System.out.println(Arrays.toString(arr) + " - Original Array");
        rotate.leftRotate(arr, 2, 5);
        rotate.printArray(arr, 5);
    }
}

// This code has been contributed by Mayank Jaiswal
