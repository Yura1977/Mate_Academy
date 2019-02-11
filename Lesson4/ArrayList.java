package collections;

import java.util.Iterator;

public class ArrayList<T> implements List<T> {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        for (String s : strings) {
            System.out.println(s);
        }
        System.out.println("-------------");
        strings.update(1, "update");
        strings.remove(2);
        System.out.println(strings.get(0));
        System.out.println(strings.get(1));
        System.out.println(strings.get(2));
        System.out.println(strings.size());
    }

    private T[] values;

    ArrayList() {
        values = (T[]) new Object[0];
    }

    @Override
    public T get(int index) {
        return values[index];
    }

    @Override
    public boolean add(T t) {
        try {
            T[] temp = values;
            values = (T[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = t;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void remove(int index) {
        try {
            T[] temp = values;
            values = (T[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int amountElemAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, amountElemAfterIndex);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, T t) {
        values[index] = t;

    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<T>(values);
    }
}
