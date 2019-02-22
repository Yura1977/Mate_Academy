package merge.sort;

public class Main {
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
