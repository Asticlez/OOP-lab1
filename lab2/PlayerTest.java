package lab2;

public class PlayerTest {
    public static void main(String[] args) {
        FootballPlayer f = new FootballPlayer("Ronaldo", 7);
        BasketballPlayer b = new BasketballPlayer("James", 23);
        f.print();
        b.print();
        f.playGame();
        b.playGame();
        System.out.println(f.getMinutesPlayed());
        System.out.println(b.getMinutesPlayed());
        b.changeJerseyNumber(6);
    }
}
