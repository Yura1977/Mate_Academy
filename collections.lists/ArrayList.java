package collections.lists;

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

    @Override
    public T get(int index) {
        checkIndexException(index);
        return (T) data[index];
    }

    @Override
    public boolean add(T t) {
        try {
            if (size == data.length) {
                resizeAdd();
            }
            data[size++] = t;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public T remove(int index) {
        checkIndexException(index);
        T temp = (T) data[index];
        data[index] = null;
        for (index = 0; index < size - 1; index++) {
            data[index] = data[index + 1];
        }
        size--;
        if (size == data.length / 4) {
            resizeRem();
        }
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    private void checkIndexException(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void resizeAdd() {
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    private void resizeRem() {
        Object[] newData = new Object[data.length / 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}
