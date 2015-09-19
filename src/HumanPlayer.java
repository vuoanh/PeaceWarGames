import java.util.Random;
import java.util.Scanner;


public class HumanPlayer {

    private String name;
    private String description;
    private Scanner input;

    public HumanPlayer(String name, String description) {
        this.name = name;
        this.description = description;
        input = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Move takeTurn(int num, Random rand) {

        System.out.print("Strategy? ");
        String strategy;

        while (true) {
            strategy = input.nextLine().trim();
            if (strategy.equalsIgnoreCase("peace"))
                return Move.PEACE;
            else if (strategy.equalsIgnoreCase("war"))
                return Move.WAR;
            System.out.print("Invalid choice. Strategy? <peace|war> ");
        }
    }

    public void recordOpponentMove(int num, Move move) {
        return;
    }

}
