package lab2;

public class Person {
    private String lastName;
    private String firstName;

    public Person() {
        lastName = "";
        firstName = "";
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
}
