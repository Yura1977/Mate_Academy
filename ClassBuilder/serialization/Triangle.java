package serialization;

public class Triangle implements Shape {
    private final int SIDES_NUMBER = 3;
    private int[] sides;

    public Triangle(int[] sides) {
        this.sides = new int[SIDES_NUMBER];
        System.arraycopy(sides, 0, this.sides, 0, SIDES_NUMBER);
    }

    public int[] getSides() {
        int[] temp = new int[SIDES_NUMBER];
        System.arraycopy(sides, 0, temp, 0, SIDES_NUMBER);
        return temp;
    }

    public void setSides(int[] sides) {
        System.arraycopy(sides, 0, this.sides, 0, SIDES_NUMBER);
    }

    @Override
    public void draw() {
        System.out.print("Triangle with sides: ");
        for (int side : sides) {
            System.out.print(side + " ");
        }
    }
}
