package serialization;

import java.util.List;

public class ShapeToXml {
    public static String encode(Shape component) {
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        xmlString += encodeShape(component);
        return xmlString;
    }

    private static String encodeShape(Shape component) {
        String xmlString = "";
        if (component instanceof Triangle) {
            xmlString += encodeTriangle((Triangle) component);
        } else if (component instanceof Square) {
            xmlString += encodeSquare((Square) component);
        } else if (component instanceof Circle) {
            xmlString += encodeCircle((Circle) component);
        } else if (component instanceof Composite) {
            xmlString += encodeGroup((Composite) component);
        }
        return xmlString;
    }

    private static String encodeTriangle(Triangle triangle) {
        String xmlString = "<Triangle>\n";
        int[] triangleSides = triangle.getSides();
        for (int index = 0; index < 3; index++) {
            xmlString += "\t<side" + index + ">";
            xmlString += triangleSides[index];
            xmlString += "</side" + index + ">\n";
        }
        xmlString += "</Triangle>\n";
        return xmlString;
    }

    private static String encodeSquare(Square square) {
        String xmlString = "<Square>\n";
        xmlString += "\t<side>" + square.getSide() + "</side>\n";
        xmlString += "</Square>\n";
        return xmlString;
    }

    private static String encodeCircle(Circle circle) {
        String xmlString = "<Circle>\n";
        xmlString += "\t<radius>" + circle.getRadius() + "</radius>\n";
        xmlString += "</Circle>\n";
        return xmlString;
    }

    private static String encodeGroup(Composite group) {
        StringBuilder xmlString = new StringBuilder();
        xmlString.append("<Group>\n\t<shapes>\n");
        List<Shape> shapes = group.getComponents();
        for (Shape shape : shapes) {
            String[] lines = encodeShape(shape).split("\n");
            for (String line : lines) {
                xmlString.append("\t\t").append(line).append("\n");
            }
        }
        xmlString.append("\t</shapes>\n</Group>\n");
        return xmlString.toString();
    }
}
