package merge.sort;

public class Merge {
    private long[] arr;
    private int n;

   protected Merge(int max) {
        arr = new long[max];
        n = 0;
    }

    protected void insert(long value) {
        arr[n] = value;
        n++;
    }

    protected void display() {
        for (int j = 0; j < n; j++)
            System.out.print(arr[j] + " ");
        System.out.println(" ");
    }

    protected void mergeSort() {
        long[] workSpace = new long[n];
        recMergeSort(workSpace, 0, n - 1);
    }

    private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound)
            return;
        else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid + 1, upperBound);
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }

    private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;
        while (lowPtr <= mid && highPtr <= upperBound)
            if (arr[lowPtr] < arr[highPtr])
                workSpace[j++] = arr[lowPtr++];
            else
                workSpace[j++] = arr[highPtr++];
        while (lowPtr <= mid)
            workSpace[j++] = arr[lowPtr++];
        while (highPtr <= upperBound)
            workSpace[j++] = arr[highPtr++];
        for (j = 0; j < n; j++)
            arr[lowerBound + j] = workSpace[j];
    }
}
