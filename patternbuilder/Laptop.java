package patternbuilder;

public class Laptop {
    public static final LaptopBuilder BUILDER = new LaptopBuilder();
    Processor processor;
    OS os;
    int ram;
    int hdd;
    boolean touchDisplay;

    public Processor getProcessor() {
        return processor;
    }
    public OS getOs() {
        return os;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public boolean isTouchDisplay() {
        return touchDisplay;
    }
    @Override
    public String toString() {
        return "TouchDisplay: " + "\"" + touchDisplay + "\"" + " /HDD: " + hdd  + " /RAM: " + ram + " /OS: " + os + " / Processor: " + processor;
    }


}
enum Processor {Intel,AMD };
enum OS{Windows,Linux};