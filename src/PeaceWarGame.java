import java.util.Random;

public class PeaceWarGame {

    private Player player1;
    private Player player2;
    private int player1Score;
    private int player2Score;
    private int numRounds;

    /**
     *
     * @param args command-line arguments where
     *             args[0] is number of rounds
     *             args[1] is <ai|player>
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Peace War Game!");
        System.out.println("This will be a showdown of " + args[0] + "years!");

        return;
    }

    /**
     * creates a new PeaceWarGame that is played by the two players
     * (see the Player interface below) for the specified number of rounds.
     * @param player1 a Player
     * @param player2 a player
     * @param numRounds must be a non-negative integer
     */
    public PeaceWarGame(Player player1, Player player2, int numRounds) {
        this.player1 = player1;
        this.player2 = player2;
        this.numRounds = numRounds;
        player1Score = player2Score = 0;
    }

    /**
     * plays a game of Peace-War, updating the scores of the two players in the process,
     * and printing the status of the game as outlined above. It should not print out
     * the final report and winner message.
     */
    public void play() {
        Random random = new Random();
        for (int i = 1; i <= numRounds; i++) { // iteation of each round
            // print the iteration number
            System.out.println("Year " + i);

            // get the player's moves
            Move move1 = player1.takeTurn(i, random);
            Move move2 = player2.takeTurn(i, random);

            // inform the players about their opponent's moves
            player1.recordOpponentMove(i, move2);
            player2.recordOpponentMove(i, move1);

            // find out what happens
            switch (move1) {
                case PEACE: // player 1 picks peace
                    switch (move2) {
                        case PEACE: // player 2 picks peace
                            System.out.println("Peace for everyone!");
                            player1Score += 3;
                            player2Score += 3;
                            break;
                        case WAR: // player 2 picks war
                            System.out.println(player2.getName() + " crushes " + player1.getName() + "!");
                            player2Score += 5;
                            break;
                    }
                    break;
                case WAR: // player 1 picks war
                    switch (move2) {
                        case PEACE: // player 2 picks peace
                            System.out.println(player1.getName() + " crushes " + player2.getName() + "!");
                            player1Score += 5;
                            break;
                        case WAR: // player 2 picks war
                            System.out.println("Everyone to arms!");
                            player1Score += 1;
                            player2Score += 1;
                            break;
                    }
                    break;
            }
        }
    }

    /**
     * @return retrieves the current score of player 1.
     */
    public int getPlayer1Score() {
        return player1Score;
    }

    /**
     * @return retrieves the current score of player 2.
     */
    public int getPlayer2Score() {
        return player2Score;
    }

}
