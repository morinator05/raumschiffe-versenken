
import java.util.stream.IntStream;

public class Player {

    //variables
    String name;
    private char[][] ownField = new char[10][10];
    private char[][] enemyField = new char[10][10];
    private int[] shipsRemaining = {4, 3, 2, 1}; // small, small_medium, large_medium, large

    //constructor
    Player(String initName) {
        name = initName;
        setAllWater(ownField);
        setAllWater(enemyField);
    }

    private void setAllWater(char[][] field) {
        for(int row = 0; row < field.length; row++) {
            for(int column = 0; column < field[0].length; column++) {
                field[row][column] = 'w';
            }
        }
    }

    public char[][] getOwnField() {
        return ownField;
    }
    public void setOwnField(char[][] ownField) {
        this.ownField = ownField;
    }

    public int[] getShipsRemaining() {
        return shipsRemaining;
    }
    public void setShipsRemaining(int[] shipsRemaining) {
        this.shipsRemaining = shipsRemaining;
    }
    public int shipsRemaining() {
        return IntStream.of(shipsRemaining).sum();
    }
}
