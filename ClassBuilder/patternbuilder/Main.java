package patternbuilder;

public class Main {
    public static void main(String[] args) {
        Laptop laptop = new Laptop()
                .setProcessor(Processor.AMD)
                .setHdd(102400)
                .setRam(4 * 10240)
                .setTouchDisplay(false);
        System.out.println("Computer configuration:");
        System.out.println(laptop.toString());
    }
}

