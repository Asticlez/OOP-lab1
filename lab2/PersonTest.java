package lab2;

public class PersonTest {
    public static void main(String[] args) {
        TestSupport.check(Child.class.getSuperclass() == Person.class, "Child extends Person");
        TestSupport.check(Parent.class.getSuperclass() == Person.class, "Parent extends Person");
        TestSupport.check(Father.class.getSuperclass() == Parent.class, "Father extends Parent");
        TestSupport.check(Mother.class.getSuperclass() == Parent.class, "Mother extends Parent");

        Mother mother = new Mother();
        mother.setFirstName("Alice");
        Father father = new Father(mother);
        father.setFirstName("Bob");
        Person person = new Person();
        TestSupport.check(person.getFirstName().equals("") && person.getLastName().equals(""),
                "Default names are empty");
        person.setFirstName("John");
        person.setLastName("Smith");
        TestSupport.check(person.getLastName().equals("Smith"), "Last name accessors");
        Person[] people = {mother, father, person};
        String[] names = {"Ms.Alice", "Mr.Bob", "John"};
        for (int i = 0; i < people.length; i++) {
            // Java chooses the override using the actual object's class.
            TestSupport.check(people[i].getFirstName().equals(names[i]), "Name override");
            System.out.println(people[i].getFirstName());
        }
        mother.setFirstName("Ann");
        father.setFirstName("Ben");
        TestSupport.check(mother.getFirstName().equals("Ms.Ann"), "Updated mother's name");
        TestSupport.check(father.getFirstName().equals("Mr.Ben"), "Updated father's name");
        TestSupport.check(father.getWife() == mother, "Wife is the supplied Mother object");
        TestSupport.check(father.getMoney() == 0 && mother.getMoney() == 0, "Default money");
        TestSupport.check(new Father(null).getWife() == null, "Unspecified wife may be null");

        Child child = new Child(8, 125, 25.5);
        TestSupport.check(child.getAge() == 8 && child.getHeight() == 125
                && child.getWeight() == 25.5, "Child constructor attributes");
        TestSupport.check(child.getGuardian() == null, "No initial guardian");
        child.setFirstName("Sam");
        child.setLastName("Smith");
        TestSupport.check(child.getFirstName().equals("Sam")
                && child.getLastName().equals("Smith"), "Child inherits names");
        child.setGuardian(father);
        TestSupport.check(child.getGuardian() == father, "Father is a Person guardian");
        child.setGuardian(mother);
        TestSupport.check(child.getGuardian() == mother, "Guardian can change");
        child.setGuardian(person);
        TestSupport.check(child.getGuardian() == person, "Guardian can be any Person");

        Parent parent = new Parent(2500);
        TestSupport.check(parent.getMoney() == 2500 && parent.getChild() == null,
                "Parent constructor and default child");
        Parent[] parents = {parent, father, mother};
        for (Parent current : parents) {
            current.setChild(child);
            TestSupport.check(current.getChild() == child, "Inherited child association");
        }
        System.out.println("PersonTest passed (UML inheritance, attributes and associations).");
    }
}
