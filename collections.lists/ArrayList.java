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
            if (size == data.length){
                resizeAdd();
            }
            data[size++] = t;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private void resizeAdd(){
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    @Override
    public T remove(int index) {
        this.checkIndexException(index);
        resizeRem();
        return null;
    }

    private void resizeRem(){
            Object[] newData = new Object[data.length / 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
    }

    @Override
    public int size() {
        return size;
    }
}
