package patternbuilder;

public class LaptopBuilder {
    private Laptop laptop;


    public LaptopBuilder create(){
        laptop = new Laptop();
        return this;
    }

    public Laptop build(){
        return laptop;
    }

    public LaptopBuilder setProcessor(Processor processor){
        laptop.processor =  processor;
        return this;
    }

    public LaptopBuilder setRam(int ram){
        laptop.ram = ram;
        return this;
    }

    public LaptopBuilder setHdd(int hdd) {
        laptop.hdd = hdd;
        return this;
    }

    public LaptopBuilder setTouchDisplay (boolean touchDisplay) {
        laptop.touchDisplay = touchDisplay;
        laptop.os = OS.Windows; //becouse it support such dsisplays
        return this;


        }
    }

