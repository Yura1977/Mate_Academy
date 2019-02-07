package serialization;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> list1 = new ArrayList<>();
        list1.add(new Triangle(new int[]{30, 40, 50}));
        list1.add(new Square(80));
        list1.add(new Circle(60));
        Shape composit1 = new Composite(list1);
 
        List<Shape> list2 = new ArrayList<>();
        list2.add(new Square(40));
        list2.add(new Triangle(new int[]{9, 5, 12}));
        list2.add(composit1);
        Shape composit = new Composite(list2);

        System.out.println("XML string");
        System.out.println();
        System.out.println(ShapeToXml.encode(composit));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("JSON string");
        System.out.println();
        System.out.println(ShapeToJson.encode(composit));
    }
}
