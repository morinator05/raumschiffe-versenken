public class TerminalOut {

    //options
    private String lang = "en";//de-> german, en-> english, fr-> french
    private char shipSymbol = 's';//char for ship (*, #, +)
    private char waterSymbol = '~';//w ater terxure
    private char hitShip = 'x'; //char if a ship was hit (x, )

    public TerminalOut() {}

    //print console messages for the player to read (info etc.)
    public void TerminalMessageOut(int message) {
        
    }

    //interface for placing the ships
    public void playerInputPlace() {

    }

    //interface while in game
    public void playerInputAttack() {

    }

    //options menu interfaces
    public void options() {

    }


}
