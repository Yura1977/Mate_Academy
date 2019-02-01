package serialization;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Composite implements Shape {
    private List<Shape> components;

    public Composite(List<Shape> components) {
        this.components = new ArrayList<>(components);
    }

    public Composite() {

    }

    public void addComponent(Shape component) {
        components.add(component);
    }

    public void removeComponent(Shape component) {
        components.remove(component);
    }

    public List<Shape> getComponents() {
        return components;
    }

    @Override
    public void draw() {
        System.out.println("Group with elements:");
        for (Shape component : components) {
            component.draw();
            System.out.println();
        }
    }
}
