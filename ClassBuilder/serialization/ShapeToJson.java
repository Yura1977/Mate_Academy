package serialization;

import java.util.List;

public class ShapeToJson {
    public static String encode(Shape component) {
        String jsonString = "{";
        jsonString += encodeShape(component);
        jsonString += "\n}";
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
        String jsonString = "\t\"Triangle\" : {\n";
        int[] triangleSides = triangle.getSides();
        for (int index = 0; index < 2; index++) {
            jsonString += "\t\t\"side\"" + index + " : ";
            jsonString += "\"" + triangleSides[index] + "\"";
            jsonString += ",\n";
        }
        jsonString += "\t\t\"side2\" : ";
        jsonString += "\"" + triangleSides[2] + "\"";
        jsonString += "\n\t}";
        return jsonString;
    }

    private static String encodeSquare(Square square) {
        String jsonString = "\t\"Square\" : {\n";
        jsonString += "\t\t\"side\" : \"" + square.getSide() + "\"\n";
        jsonString += "\t}";
        return jsonString;
    }

    private static String encodeCircle(Circle circle) {
        String jsonString = "\t\"Circle\" : {\n";
        jsonString += "\t\t\"radius\" : \"" + circle.getRadius() + "\"\n";
        jsonString += "\t}";
        return jsonString;
    }

    private static String encodeGroup(Composite group) {
        StringBuilder jsonString = new StringBuilder();
        jsonString.append("\t\"Group\" : {\n");
        List<Shape> shapes = group.getComponents();
        for (Shape shape : shapes) {
            String[] lines = encodeShape(shape).split("\n");
            for (String line : lines) {
                jsonString.append("\t").append(line).append("\n");
            }
            jsonString.setCharAt(jsonString.length() - 1, ',');
            jsonString.append("\n");
        }
        jsonString.deleteCharAt(jsonString.length() - 2); // Removing last comma
        jsonString.append("\t}");
        return jsonString.toString();
    }
}
