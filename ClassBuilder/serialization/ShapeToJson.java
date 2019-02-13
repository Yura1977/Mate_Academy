package serialization;

import java.util.List;

public class ShapeToJson {
    public static String encode(Shape component) {
        String jsonString = "\n";
        jsonString += encodeShape(component);
        jsonString += "\n";
        return jsonString;
    }

    private static String encodeShape(Shape shape) {
        String jsonString = "";
        if (shape instanceof Triangle) {
            jsonString += encodeTriangle((Triangle) shape);
        } else if (shape instanceof Square) {
            jsonString += encodeSquare((Square) shape);
        } else if (shape instanceof Circle) {
            jsonString += encodeCircle((Circle) shape);
        } else if (shape instanceof Composite) {
            jsonString += encodeGroup((Composite) shape);
        }
        return jsonString;
    }

    private static String encodeTriangle(Triangle triangle) {
        String jsonString = "{\n";
        int[] triangleSides = triangle.getSides();
        for (int index = 0; index < 2; index++) {
            jsonString += "\"side" + index + "\"  : ";
            jsonString += triangleSides[index];
            jsonString += ",\n";
        }
        jsonString += "\"side2\" : ";
        jsonString += triangleSides[2];
        jsonString += "\n},";
        return jsonString;
    }

    private static String encodeSquare(Square square) {
        return "{\n\"side\" : " + square.getSide() + "\n},";
    }

    private static String encodeCircle(Circle circle) {
        return "{\n\"radius\" : " + circle.getRadius() + "\n}";
    }

    private static String encodeGroup(Composite group) {
        StringBuilder jsonString = new StringBuilder();
        jsonString.append("{\n");
        jsonString.append("\t\"components\" : [\n");
        List<Shape> shapes = group.getComponents();
        for (Shape shape : shapes) {
            String[] lines = encodeShape(shape).split("\n");
            for (String line : lines) {
                jsonString.append("\t").append(line).append("\t\n");
            }
        }
        jsonString.deleteCharAt(jsonString.length() - 1).append("\n]");
        jsonString.append("\n");
        return jsonString.append("}").toString();
    }
}
