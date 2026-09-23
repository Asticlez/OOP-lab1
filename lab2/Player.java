package lab2;

// Both sports inherit the shared state and behavior from this superclass.
public abstract class Player {
    private String name;
    private int jerseyNumber;
    private int minutesPlayed;

    public Player(String name, int jerseyNumber) {
        this.name = name;
        this.jerseyNumber = jerseyNumber;
        minutesPlayed = 0;
    }

    public void print() {
        System.out.println(name + ": " + jerseyNumber);
    }

    public int getMinutesPlayed() {
        return minutesPlayed;
    }

    protected void addMinutes(int minutes) {
        minutesPlayed += minutes;
    }

    protected String getName() {
        return name;
    }

    protected void setJerseyNumber(int newNumber) {
        jerseyNumber = newNumber;
    }

    // Each subclass supplies its own game length.
    public abstract void playGame();
}
