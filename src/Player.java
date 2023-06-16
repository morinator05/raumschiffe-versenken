import java.util.stream.IntStream;

public class Player {

    //variables
    String name;
    private char[][] ownField = new char[10][10];
    private char[][] enemyField = new char[10][10];
    private int[] shipsRemaining = {4, 3, 2, 1}; // small, small_medium, large_medium, large
    private int[] shipsRemainingDefault = {4, 3, 2, 1};
    private int hits;

    //constructor
    Player(String initName) {
        name = initName;
        setAllWater(ownField);
        setAllWater(enemyField);
        hits = 0;
    }

    public void resetPlayer() {
        setAllWater(ownField);
        setAllWater(enemyField);
        hits = 0;
        resetShipsRemaining();
    }


    public void resetShipsRemaining() {
        shipsRemaining = shipsRemainingDefault;
    }
    public char[][] getOwnField() {
        return ownField;
    }
    public void setOwnField(char[][] ownField) {this.ownField = ownField;}
    public int[] getShipsRemaining() {
        return shipsRemaining;
    }
    public void setShipsRemaining(int[] shipsRemaining) {
        this.shipsRemaining = shipsRemaining;
    }
    public int shipsRemaining() {
        int value = IntStream.of(shipsRemaining).sum();
        System.out.println("info: player has " + value + " ships remaining");
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
