package mergeSort;

class Merge {
    private long[] arr;
    private int n;

    public Merge(int max) {
        arr = new long[max];
        n = 0;
    }

    public void insert(long value) {
        arr[n] = value;
        n++;
    }

    public void display() {
        for (int j = 0; j < n; j++)
            System.out.print(arr[j] + " ");
        System.out.println(" ");
    }

    public void mergeSort() {
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

class Main {
    public static void main(String[] args) {
        int maxSize = 100;
        Merge arr;
        arr = new Merge(maxSize);
        arr.insert(64);
        arr.insert(21);
        arr.insert(33);
        arr.insert(70);
        arr.insert(12);
        arr.insert(85);
        arr.insert(44);
        arr.insert(3);
        arr.insert(97);
        arr.insert(24);
        arr.insert(51);
        arr.insert(40);
        arr.display();
        arr.mergeSort();
        arr.display();
    }
}