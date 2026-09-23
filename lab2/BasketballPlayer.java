package lab2;

public class BasketballPlayer extends Player {
    public BasketballPlayer(String n, int j) {
        super(n, j);
    }

    @Override
    public void playGame() {
        addMinutes(48);
    }

    public void changeJerseyNumber(int newNumber) {
        setJerseyNumber(newNumber);
        System.out.println(getName() + " changes number to " + newNumber);
    }
}
