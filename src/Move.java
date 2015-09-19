// In Move.java

/**
 * The possible moves in a Peace-war Game.
 */
public enum Move {
    PEACE, WAR;

    /**
     * @return the string representation of this Move.
     */
    public static String toString(Move move) {
        if (Move.PEACE == move) {
            return "peace";
        } else {
            return "war";
        }
    }

    @Override
    public String toString() {
        if (this == PEACE) {
            return "peace";
        } else {
            return "war";
        }
    }
}
