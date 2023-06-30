public class Game {

    //associations
    Player player;
    Player computerEnemy;
    TerminalOut terminalout;

    //Variables
    int[] lengthOfShipList = {2, 3, 4, 5}; //list of length of ships for placing
    
    public Game() {
        int mode; int modeOptions;
        player = new Player("player");
        computerEnemy = new Player("computer");
        terminalout = new TerminalOut();

        do {

            mode = terminalout.title(); // set mode and display title in terminal, 0 for exit

            if(mode == 1) {
                do {
                    modeOptions = terminalout.options(player); // set options mode and display Options menu in terminal, 0 for exit

                    //switch between the options2
                    switch (modeOptions) {
                        case 1:terminalout.setShipSymbol(); break;
                        case 2:terminalout.setWaterSymbol(); break;
                        case 3:terminalout.setHitSymbol(); break;
                        case 4:terminalout.setMissSymbol(); break;
                        case 5:terminalout.changeName(player);
                    }
                } while(modeOptions != 0);
            }
            else if(mode == 2) {
                playRound(); //mode two starts the round
            }
            else if (mode == 3) {
                terminalout.credits();
            }

            //reset players after round is played
            player.reset();
            computerEnemy.reset();

        } while(mode != 0);
    }

    //plays one round and returns the winner
    public void playRound() {
        int winner;

        //placing all ships
        generateShipPlacements(computerEnemy);
        //generateShipPlacements(player);
        while(player.shipsRemaining() != 0) {
            terminalout.playerInputPlace(player);
            placeShip(terminalout.inputCoordX(), terminalout.inputCoordY(), terminalout.inputRotation(), terminalout.inputType(player), player);
        }

        //attacking the ships
        //terminalout.printFieldWithNumbers(computerEnemy);
        do {
            //attacks
            terminalout.playerAttack(player);
            attackPos(terminalout.inputCoordX(), terminalout.inputCoordY(), player, computerEnemy);
            attackPos(genRandomPos(), genRandomPos(), computerEnemy, player);

            //checks
            if(checkGameOver(player)) {
                winner = 2;
            }
            else if(checkGameOver(computerEnemy)) {
                winner = 1;
            }
            else {
                winner = 0;
            }
        } while(winner == 0);

        terminalout.win(winner, player);

    }

    //check if entered ship placement is valid and does not touch a other ship 
    private int checkPlacement(int x, int y, boolean rotation, int type, Player player) {
        //convert ship type to length
        int lengthOfShip = lengthOfShipList[type];

        //set start and end cords and checks if ship would be out of bounds
        int startPosX = x - 1; int startPosY = y - 1;
        int endPosX; int endPosY;

        //set the end coordinates for the scan according to the rotation of the ship
        if(rotation) {
            endPosX = startPosX + lengthOfShip + 1;
            endPosY = startPosY + 2;
            if((startPosX + lengthOfShip > 9)) {
                //System.out.println("error: invalid ship placement");
                return -1;
            }
        }
        else{
            endPosY = startPosY + lengthOfShip + 1;
            endPosX = startPosX + 2;
            if((startPosY + lengthOfShip > 9)) {
                //System.out.println("error: invalid ship placement");
                return -1;
            }
        }

        if(endPosX > 9) {
            endPosX = 9;
        }
        if(endPosY > 9) {
            endPosY = 9;
        }
        if(startPosX < 0) {
            startPosX = 0;
        }
        if(startPosY < 0) {
            startPosY = 0;
        }
        //System.out.println("debug: checking from (" + startPosX + "|" + startPosY + ") to (" + endPosX + "|" + endPosY + ")");

        //check from startPosXY to endPosXY if ship would touch other ship 
        for(int currentPosY = startPosY; currentPosY <= endPosY; currentPosY++) {
            for (int currentPosX = startPosX; currentPosX <= endPosX; currentPosX ++) {
                if(player.getOwnField()[currentPosY][currentPosX] != 'w') {
                    //System.out.println("error: invalid ship placement");
                    return -1;
                }
            }
        }
        return 0;
    }

    //place ship
    public void placeShip(int x, int y, boolean rotation, int type, Player player){
        int startPosX; int startPosY; int endPosX; int endPosY;
        int[] tempShipsRemaining = player.getShipsRemaining();

        if (player.shipsRemaining() != 0) {
            
            if(checkPlacement(x, y, rotation, type, player) == -1) {
                //System.out.println("info: no ship was placed");
            }
            else {
                startPosX = x; startPosY = y; 
                if(rotation) {
                    endPosX = startPosX + lengthOfShipList[type] - 1; endPosY = y;
                }
                else {
                    endPosX = x; endPosY = startPosY + lengthOfShipList[type] - 1;
                }
                //System.out.println("debug: placing from (" + startPosX + "|" + startPosY + ") to (" + endPosX + "|" + endPosY + ")");

                for(int currentPosY = startPosY; currentPosY <= endPosY; currentPosY++) {
                    for (int currentPosX = startPosX; currentPosX <= endPosX; currentPosX ++) {
                        player.getOwnField()[currentPosY][currentPosX] = 's';
                    }
                }
                tempShipsRemaining[type] --;
                player.setShipsRemaining(tempShipsRemaining);
            }

        }
        //System.out.println("debug: no ships remaining");
    }

    //checks if all ships of one player have been hit
    public boolean checkGameOver(Player player) {
        int tempShips = 0;
        for(int i = 0; i < player.getOwnField().length; i++) {
            for(int j = 0; j < player.getOwnField().length; j++) {
                if(player.getOwnField()[i][j] == 's') {
                    tempShips ++;
                }
            }
            System.out.println();
        }
        return tempShips == 0;
    }

    //player attacks player1
    public void attackPos(int PosX, int PosY, Player player, Player player1){
        if (player1.getOwnField()[PosY][PosX] == 'w') {
            player1.getOwnField()[PosY][PosX] = 'm';
            player.getEnemyField()[PosY][PosX] = 'm';
        }
        else if(player1.getOwnField()[PosY][PosX] == 's'){
            player1.getOwnField()[PosY][PosX] = 'h';
            player.getEnemyField()[PosY][PosX] = 'h';
        }
    }

    // algorithm for placing ships
    public void generateShipPlacements(Player player) {
        int counter = 0;
        int resets = 0;

        do{
            placeShip(genRandomPos(), genRandomPos(), genRandomBoolean(), genRandomType(player), player);
            counter ++;
            if(counter >= 200) {
                counter = 0; resets ++;
                player.setAllWater(player.getOwnField());
                player.resetShipsRemaining();
            }
        } while(player.shipsRemaining() != 0);
        //.out.println("tries to place all ships: " + counter + " times reset: " + resets);
    }

    public int genRandomPos() {
        return (int)(Math.random() * 10);
    }
    public boolean genRandomBoolean() {
        return Math.random() < 0.5;
    }
    public int genRandomType(Player player) {
        int[] shipsRemaining = player.getShipsRemaining();
        
        if(shipsRemaining[3] != 0){
            return 3;
        }
        if(shipsRemaining[2] != 0){
            return 2;
        }
        if(shipsRemaining[1] != 0){
            return 1;
        }
        if(shipsRemaining[0] != 0){
            return 0;
        }

        return -1;
    }

    public static void main(String[] args) {

        Game game1 = new Game();


    }
}
