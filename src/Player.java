import java.util.Random;
// In Player.java

/**
 * A player of the Peace-War Game.  All players for the Peace-War Game must
 * implement this interface (whether they are human- or AI-controlled).
 */
public interface Player {
    /**
     * @return the name of this player
     */
    public String getName();

    /**
     * @return a one sentence description describing this player's strategy
     */
    public String getDescription();

    /**
     * @param num  the turn number
     * @param rand the Random object to be used to make random choices
     * @return the Move to be played for the current round.
     */
    public Move takeTurn(int num, Random rand);

    /**
     * Records the opponent's move for this round.  If this player does not
     * make decisions based off of their opponent's actions,
     * recordOpponentMove does nothing.
     *
     * @param num  the round number
     * @param move the move
     */
    public void recordOpponentMove(int num, Move move);
}