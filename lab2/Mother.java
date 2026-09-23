package lab2;

public class Mother extends Parent {
    private Father husband;

    public Mother() {
        super(0); // No money or husband is supplied by the UML constructor.
        husband = null;
    }

    @Override
    public String getFirstName() {
        return "Ms." + super.getFirstName();
    }
}
