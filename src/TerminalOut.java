public class TerminalOut {

    //options
    private String lang = "en";//de-> german, en-> english, fr-> french
    private char shipSymbol = 's';//char for ship (*, #, +)
    private char waterSymbol = '~';//w ater texture
    private char hitShip = 'x'; //char if a ship was hit (x, )

    public TerminalOut() {}

    //print console messages for the player to read (info etc.)
    public void TerminalMessageOut(int message) {
        switch(message){
            case 1 : {
                System.out.println("You Won!");
            }
            case 2 :{
                System.out.println("You Lost!");
            }
            case 3 : {
                System.out.println("Ship placement not allowed!");
            }
            case 4 : {
                System.out.println("Error!");
            }
            case 5 : {
                System.out.println("Winner Winner Chicken Dinner");  
            }
            case 6 : {
                System.out.println("Miss!");
            }
            case 7 : {
                System.out.println("Hit!");
            }
            case 8 : {
                System.out.println("Made by: ");
            }
            case 9 : {
                System.out.println("");
            }
        }
    }

    //interface for placing the ships
    public void playerInputPlace() {
        char[][] ownField = new char[10][10];
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for(int i = 0; i < ownField.length; i++) {
            for(int j = 0; j < ownField[0].length; j++) {
                System.out.print(i+ " "+ ownField[i][j] + "  ");
            }
            System.out.println();
        }
        
    }

    //interface while in game
    public void playerInputAttack() {

    }

    //options menu interfaces
    public void options() {

    }


}
