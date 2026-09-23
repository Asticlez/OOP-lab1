package lab2;

public class FootballPlayer extends Player {
    public FootballPlayer(String n, int j) {
        super(n, j);
    }

    @Override
    public void playGame() {
        addMinutes(90);
    }
}
