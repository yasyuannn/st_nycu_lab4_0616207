import java.lang.*;

public class Game {
    // Judge the outcome
    public String winnerIs(String p1, String p2) {
        if (p1.equals(p2)) {
            return "Draw!";
        }
        else if ((p1.equals("rock") && p2.equals("scissors")) ||
                (p1.equals("paper") && p2.equals("rock")) ||
                (p1.equals("scissors")) && p2.equals("paper")) {
            return "Player 1 win!";
        }
        else {
            return "Player 2 win!";
        }
    }

    // Input Validation
    public static void inputCheck(String input) {
        if (!(input.equals("rock") || input.equals("paper") || input.equals("scissors")))
            throw new IllegalArgumentException("Bad Choice!");
    }
}