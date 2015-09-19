import java.util.Random;

public class RandomPlayer implements Player {

    private Random rand;
    private String name;
    private int num;

    public RandomPlayer(String name) {
        this.name = name;
        num = 0;
        rand = new Random();
    }

    /**
     * A player of the Peace-War Game.  All players for the Peace-War Game must
     * implement this interface (whether they are human- or AI-controlled).
     */
    public String getName() {
        return name;
    }

    public String getDescription() {
        return Move.toString(takeTurn(num, rand));
    }

    /**
     * @param num  the turn number
     * @param rand the Random object to be used to make random choices
     * @return the Move to be played for the current round.
     */
    public Move takeTurn(int num, Random rand) {
        this.num = num;
        Move move;
        int decideNum = rand.nextInt(1000);
        if ((decideNum % 2) == 0) {
            move = Move.PEACE;
        } else {
            move = Move.WAR;
        }
        return move;
    }

    /**
     * Records the opponent's move for this round.  If this player does not
     * make decisions based off of their opponent's actions,
     * recordOpponentMove does nothing.
     *
     * @param num  the round number
     * @param move the move
     */
    public void recordOpponentMove(int num, Move move) {
        return;
    }

}
