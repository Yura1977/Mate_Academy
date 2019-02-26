package collections.lists;

public class Tests<T> {

    public static void main(String[] args) {
        Tests tests = new Tests();

        List<Integer> arrayListOfIntegers = new ArrayList<>();
        arrayListOfIntegers.add(0);
        arrayListOfIntegers.add(1);
        arrayListOfIntegers.add(2);
        arrayListOfIntegers.add(3);
        arrayListOfIntegers.add(4);
        arrayListOfIntegers.add(5);

        tests.printList(arrayListOfIntegers);

        List<String> arrayListOfStrings = new ArrayList<>();
        arrayListOfStrings.add("One");
        arrayListOfStrings.add("Two");
        arrayListOfStrings.add("Three");
        arrayListOfStrings.add("Four");
        arrayListOfStrings.add("Five");

        tests.printList(arrayListOfStrings);

        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        List<Integer> linkedListOfIntegers = new LinkedList<>();
        linkedListOfIntegers.add(5);
        linkedListOfIntegers.add(4);
        linkedListOfIntegers.add(3);
        linkedListOfIntegers.add(2);
        linkedListOfIntegers.add(1);
        linkedListOfIntegers.add(0);

        tests.printList(linkedListOfIntegers);

        List<String> linkedListOfStrings = new ArrayList<>();
        linkedListOfStrings.add("Blue");
        linkedListOfStrings.add("Green");
        linkedListOfStrings.add("Yellow");
        linkedListOfStrings.add("Red");

        tests.printList(linkedListOfStrings);

        int removed4 = linkedListOfIntegers.remove(4);
        System.out.println("\ndata " + removed4 + " is removed from the LinkedList of integers");

        int removed5 = linkedListOfIntegers.remove(3);
        System.out.println("\ndata " + removed5 + " is removed from the LinkedList of integers");

        tests.printList(linkedListOfIntegers);

        tests.printList(linkedListOfStrings);
    }

    private void printList(List<T> list) {
        System.out.print("\n[");
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.print(list.get(list.size() - 1) + "]\n");
        System.out.println("size = " + list.size());
    }
}