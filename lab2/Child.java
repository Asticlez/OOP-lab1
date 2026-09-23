package lab2;

public class Child extends Person {
    private Person guardian;
    private int age;
    private int height;
    private double weight;

    public Child(int age, int height, double weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public void setGuardian(Person guardian) {
        this.guardian = guardian;
    }

    public Person getGuardian() {
        return guardian;
    }

    // Read-only access also lets the test check constructor values.
    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }
}
