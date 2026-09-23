package lab2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PlayerBehaviorTest {
    public static void main(String[] args) {
        String newline = System.lineSeparator();
        String expected = "Ronaldo: 7" + newline + "James: 23" + newline
                + "90" + newline + "48" + newline
                + "James changes number to 6" + newline;
        TestSupport.check(captureOutput(() -> PlayerTest.main(new String[0])).equals(expected),
                "PlayerTest must match the PDF output exactly");

        FootballPlayer football = new FootballPlayer("Ronaldo", 7);
        BasketballPlayer basketball = new BasketballPlayer("James", 23);
        // A superclass reference can call each subclass's overridden method.
        Player[] players = {football, basketball};
        for (Player player : players) {
            TestSupport.check(player.getMinutesPlayed() == 0, "Initial minutes");
            player.playGame();
            player.playGame();
            player.playGame();
        }
        TestSupport.check(football.getMinutesPlayed() == 270, "Three football games");
        TestSupport.check(basketball.getMinutesPlayed() == 144, "Three basketball games");
        String changed = captureOutput(() -> {
            basketball.changeJerseyNumber(6);
            basketball.print();
        });
        TestSupport.check(changed.equals("James changes number to 6" + newline
                + "James: 6" + newline), "Jersey change must update stored state");
        TestSupport.check(basketball.getMinutesPlayed() == 144, "Jersey change keeps minutes");
        System.out.println("PlayerBehaviorTest passed (exact output and repeated games).");
    }

    private static String captureOutput(Runnable action) {
        PrintStream original = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (PrintStream captured = new PrintStream(bytes)) {
            System.setOut(captured);
            action.run();
        } finally {
            System.setOut(original);
        }
        return bytes.toString();
    }
}
