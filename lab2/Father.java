package lab2;

public class Father extends Parent {
    private Mother wife;

    public Father(Mother wife) {
        super(0); // The UML constructor supplies no money argument.
        this.wife = wife;
    }

    // The UML's return type "Wife" appears to mean Mother.
    public Mother getWife() {
        return wife;
    }

    @Override
    public String getFirstName() {
        return "Mr." + super.getFirstName();
    }
}
