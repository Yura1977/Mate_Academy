import java.util.Arrays;

public class Restore_array {
    public static void main(String[] args) {
        int[] arr = {1, 2, -1, 4, 7, 6, -2, 4};



        System.out.println (Arrays.toString(arr) + " - Original Array" );



        for (int i =0; i < arr.length; i++) {
          if (arr[i] < 0 && arr[i - 1] < arr[i+1]){
              arr[i] = arr[i - 1] + 1;

          }
          if (arr[i] < 0 && arr[i - 1] > arr[i + 1]){
              arr[i] = arr[i - 1] - 1;
          }
        }

        System.out.println(Arrays.toString(arr) + " - Modified Array");
    }
}
