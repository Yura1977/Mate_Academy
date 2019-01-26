package com.yura.immutableclass.immutable;

public class ComputerBuilderDirector {

    public Computer getBasicComputer() {
        return new Computer.Builder("2GB", "2TB", "Intel i5").build();
    }

    public Computer getGraphicsCardEnabledComputer() {
        return new Computer.Builder("3GB", "3TB", "Intel i7").setGraphicsCardEnabled(true).build();
    }
}
