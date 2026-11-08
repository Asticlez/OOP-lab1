package lab4;

public class TriangleManagerTest {
    public static void main(String[] args) {
        demonstrate(true);
        demonstrate(false);
        System.out.println("TriangleManagerTest passed.");
    }

    private static void demonstrate(boolean useArrayList) {
        System.out.println(useArrayList ? "ArrayList:" : "LinkedList:");
        TriangleManager manager = new TriangleManager(useArrayList);
        TestSupport.check(manager.findTriangleWithLargestPerimeter() == null, "Empty list");
        System.out.println("Empty list: " + manager.findTriangleWithLargestPerimeter());
        Triangle small = new RightTriangle(3, 4, 5);
        manager.addTriangle(small);
        TestSupport.check(manager.findTriangleWithLargestPerimeter() == small, "Single object");
        Triangle largest = new EquilateralTriangle(5);
        manager.addTriangle(largest);
        TestSupport.check(manager.findTriangleWithLargestPerimeter() == largest, "Largest object");
        Triangle tie = new RightTriangle(2.5, 6, 6.5);
        manager.addTriangle(tie);
        Triangle result = manager.findTriangleWithLargestPerimeter();
        TestSupport.check(result == largest || result == tie, "Tied object");
        System.out.println("Largest: " + result.getClass().getSimpleName()
                + ", perimeter = " + result.getPerimeter());
        try {
            manager.addTriangle(null);
            throw new AssertionError("Null must be rejected");
        } catch (IllegalArgumentException e) {
            TestSupport.check("Triangle cannot be null".equals(e.getMessage()), "Exact message");
            System.out.println("Rejected null: " + e.getMessage());
        }
        TestSupport.check(manager.findTriangleWithLargestPerimeter() == result,
                "Rejected addition leaves list unchanged");
    }
}
