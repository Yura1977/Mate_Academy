package immutable;

import immutable.Computer;

public class ComputerClient {

    public static void main(String[] args) {

        Computer comp = new Computer.Builder("2GB", "2TB", "Intel i5").build();

        Computer comp1 = new Computer.Builder("3GB", "3TB", "Intel i7").setGraphicsCardEnabled(true).build();
        Computer[] arr = {comp, comp1};
        for (Computer temp : arr) {
            System.out.println(temp.toString());
        }
    }
}
