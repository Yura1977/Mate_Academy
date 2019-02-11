package patternbuilder;

public class Laptop {
    private Processor processor;
    private Os os;
    private int ram;
    private int hdd;
    private boolean touchDisplay;

    public Laptop setProcessor(Processor processor) {
        this.processor = processor;
        return this;
    }

    public Laptop setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public Laptop setHdd(int hdd) {
        this.hdd = hdd;
        return this;
    }

    public Laptop setTouchDisplay(boolean touchDisplay) {
        this.touchDisplay = touchDisplay;
        this.os = OS.Windows_Const; //becouse it support such dsisplays
        return this;
    }

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
        return "TouchDisplay: " + "\"" + touchDisplay + "\"" + " /HDD: " + hdd + " /RAM: " + ram + " /OS: " + os + " / Processor: " + processor;
    }
}

public enum Processor {
INTEL,
AMD
}
public enum Os {
WINDOWS,
LINUX
}
