package lab4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TriangleManager {
    private List<Triangle> triangles;

    public TriangleManager(boolean useArrayList) {
        triangles = useArrayList ? new ArrayList<>() : new LinkedList<>();
    }

    public void addTriangle(Triangle t) {
        if (t == null) {
            throw new IllegalArgumentException("Triangle cannot be null");
        }
        triangles.add(t);
    }

    public Triangle findTriangleWithLargestPerimeter() {
        Triangle largest = null;
        for (Triangle triangle : triangles) {
            if (largest == null || triangle.getPerimeter() > largest.getPerimeter()) {
                largest = triangle;
            }
        }
        return largest;
    }
}
