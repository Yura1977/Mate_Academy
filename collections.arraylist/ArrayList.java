package collections.arraylist;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size = 0;

    public ArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        this.data = new Object[capacity];
    }

    private void checkIndexException(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public T get(int index) {
        checkIndexException(index);
        return (T) data[index];
    }

    @Override
    public boolean add(T t) {
        try {
            T[] temp = (T[]) data;
            System.arraycopy(temp, 0, data, 0, temp.length);
            data[size++] = t;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public T remove(int index) {
        T[] temp = null;
        try {
            temp = (T[]) data;
            data = (T[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, data, 0, index);
            int amountElemAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, data, index, amountElemAfterIndex);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return (T) temp;
    }

    @Override
    public int size() {
        return size;
    }
}
