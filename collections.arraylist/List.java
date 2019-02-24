package collections.arraylist;

public interface List<T> {
    T get(int index);

    boolean add(T t);

    T remove(int index);

    int size();
}