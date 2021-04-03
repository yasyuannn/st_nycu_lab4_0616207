import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Game game = new Game();
        Scanner scan = new Scanner(System.in);

        System.out.println("=== Welcome to Rock-Paper-Scissors game ===");
        System.out.println("Enter Player 1 Choice (rock, paper, scissors):");
        String player1 = scan.next();
        game.inputCheck(player1);

        System.out.println("Enter Player 2 Choice (rock, paper, scissors):");
        String player2 = scan.next();
        game.inputCheck(player2);

        System.out.println(game.winnerIs(player1, player2));
    }
}