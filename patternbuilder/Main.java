package patternbuilder;

public class Main {
    public static void main (String[] args){
        LaptopBuilder builder =  Laptop.BUILDER;

        Laptop laptop = builder.create()
                .setProcessor(Processor.AMD)
                .setHdd(102400)
                .setRam (4 * 10240)
                .setTouchDisplay(false)
                .build();
        System.out.println("Computer configuration:");
        System.out.println(laptop.toString());

        }

    }

