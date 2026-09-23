package lab2;

public class Parent extends Person {
    private Child child;
    private int money;

    public Parent(int money) {
        this.money = money;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Child getChild() {
        return child;
    }

    public int getMoney() {
        return money;
    }
}
