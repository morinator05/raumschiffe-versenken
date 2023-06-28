import java.util.stream.IntStream;

public class Player {

    //variables
    String name;
    private char[][] ownField = new char[10][10];

    private char[][] enemyField = new char[10][10];
    private int[] shipsRemaining; // small, small_medium, large_medium, large
    //private int[] shipsRemainingDefault = {4, 3, 2, 1};
    private final int[] shipsRemainingDefault = {1, 0, 0, 0};

    //constructor
    Player(String initName) {
        name = initName;
        shipsRemaining = shipsRemainingDefault;
        setAllWater(ownField);
        setAllWater(enemyField);
    }

    public void reset() {
        setAllWater(ownField);
        setAllWater(enemyField);
        shipsRemaining = shipsRemainingDefault;
    }


    public void resetShipsRemaining() {
        shipsRemaining = shipsRemainingDefault;
    }
    public char[][] getOwnField() {
        return ownField;
    }
    public char[][] getEnemyField() {return enemyField;}
    public void setOwnField(char[][] ownField) {this.ownField = ownField;}
    public int[] getShipsRemaining() {
        return shipsRemaining;
    }
    public void setShipsRemaining(int[] shipsRemaining) {
        this.shipsRemaining = shipsRemaining;
    }
    public int shipsRemaining() {
        int value = IntStream.of(shipsRemaining).sum();
        //System.out.println("info: player has " + value + " ships remaining");
        return value;
    }
    public void setAllWater(char[][] field) {
        for(int row = 0; row < field.length; row++) {
            for(int column = 0; column < field[0].length; column++) {
                field[row][column] = 'w';
            }
        }
    }
}
