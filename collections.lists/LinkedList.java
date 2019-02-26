package collections.lists;

public class LinkedList<T> implements List<T> {

    private int size = 0;
    private Node<T> fstNode;
    private Node<T> lstNode;

    @Override
    public T get(int index) {
        checkIndexException(index);
        return getNode(index).currentElement;
    }

    private Node<T> getNode(int index) {
        Node<T> target = fstNode;
        for (int i = 0; i < index; i++) {
            target = target.nextElement;
        }
        return target;
    }

    private void checkIndexException(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean add(T t) {
        Node<T> node;
        if (isEmpty()) {
            node = new Node<>(null, t, null);
            fstNode = node;
            lstNode = node;
        } else {
            node = new Node<>(lstNode, t, null);
            lstNode.nextElement = node;
            lstNode = node;
        }
        size++;
        return true;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T remove(int index) {
        checkIndexException(index);
        return delConnections(getNode(index));
    }

    private T delConnections(Node<T> node) {
        final T targetValue = node.currentElement;
        final Node<T> nextElement = node.nextElement;
        final Node<T> prevElement = node.prevElement;

        if (prevElement == null) {
            fstNode = nextElement;
        } else {
            prevElement.nextElement = nextElement;
            node.prevElement = null;
        }

        if (nextElement == null) {
            lstNode = prevElement;
        } else {
            nextElement.prevElement = prevElement;
            node.nextElement = null;
        }

        node.currentElement = null;
        size--;
        return targetValue;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<T> {
        private T currentElement;
        private Node<T> nextElement;
        private Node<T> prevElement;

        private Node(Node<T> prevElement, T currentElement, Node<T> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }
    }
}