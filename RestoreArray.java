import java.util.Arrays;

public class RestoreArray {

    static int[] modifyArray(int[] arr) {

        for (int i =0; i < arr.length; i++) {
            if (arr[i] < 0 && arr[i - 1] < arr[i+1]){
                arr[i] = arr[i - 1] + 1;

            }
            if (arr[i] < 0 && arr[i - 1] > arr[i + 1]){
                arr[i] = arr[i - 1] - 1;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] myArr = {1, 2, -1, 4, 7, 6, -2, 4};
        System.out.println (Arrays.toString(myArr) + " - Original Array");
        myArr = modifyArray(myArr);
        System.out.println(Arrays.toString(myArr) + " - Modified Array");
    }
}
