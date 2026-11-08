package lab4;

public class EquilateralTriangle implements Triangle {
    private double side;

    public EquilateralTriangle(double side) {
        this.side = side;
    }

    @Override
    public double getLongestSideLength() {
        return side;
    }

    @Override
    public double getPerimeter() {
        return side * 3;
    }

    @Override
    public double getLargestAngle() {
        return 60.0;
    }
}
