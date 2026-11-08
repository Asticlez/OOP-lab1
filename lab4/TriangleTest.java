package lab4;

public class TriangleTest {
    public static void main(String[] args) {
        Triangle[] triangles = {
            new EquilateralTriangle(5), new RightTriangle(3, 4, 5)
        };
        double[] longest = {5, 5};
        double[] perimeters = {15, 12};
        double[] angles = {60, 90};
        for (int i = 0; i < triangles.length; i++) {
            Triangle t = triangles[i];
            TestSupport.check(t.getLongestSideLength() == longest[i], "Longest side");
            TestSupport.check(t.getPerimeter() == perimeters[i], "Perimeter");
            TestSupport.check(t.getLargestAngle() == angles[i], "Largest angle");
            System.out.println(t.getClass().getSimpleName() + ": longest side = "
                    + t.getLongestSideLength() + ", perimeter = " + t.getPerimeter()
                    + ", largest angle = " + t.getLargestAngle());
        }
        TestSupport.check(new RightTriangle(5, 3, 4).getLongestSideLength() == 5,
                "First side can be longest");
        TestSupport.check(new RightTriangle(3, 5, 4).getLongestSideLength() == 5,
                "Second side can be longest");
        System.out.println("TriangleTest passed.");
    }
}
