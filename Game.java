public class Game {

    //associations
    Player player;
    ComputerEnemy computerplayer;
    Gui gui = new Gui();

    //Variables
    int[] lengthOfShipList = {2, 3, 4, 5}; //small, small_medium, large_medium, large
    
    public Game() {

        player = new Player("player1");
        computerplayer = new ComputerEnemy();

    }

    //plays one round and returns the winner
    public int playRound() {
        boolean gameOver = false;
        //generateShipPlacements(computerplayer);
        generateShipPlacements(player);
        while(player.shipsRemaining() != 0) {
            printField(player.getOwnField());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        while(gameOver == true) {

        }
        return 0;
    }

    public void printField(char[][] field) {
        System.out.println("debug: current field");
        for(int i = 0; i < field.length; i++) {
            for(int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j] + "  ");
            }
            System.out.println();
        }
    }

    //check if entered ship placement is valid and does not touch a other ship 
    private int checkPlacement(int x, int y, boolean rotation, int type, char[][] field) {
        //convert ship type to length
        int lengthOfShip = lengthOfShipList[type];

        //set start and end coords and checks if ship would be out of bounds
        int startPosX = x - 1; int startPosY = y - 1;
        int endPosX; int endPosY;
        if(rotation) {
            endPosX = startPosX + lengthOfShip + 1;
            endPosY = startPosY + 2;
            if((startPosX + lengthOfShip > 9)) {System.out.println("error: invalid ship placement"); return -1;}
        }
        else{
            endPosY = startPosY + lengthOfShip + 1;
            endPosX = startPosX + 2;
            if((startPosY + lengthOfShip > 9)) {System.out.println("error: invalid ship placement"); return -1;}
        }
        if(endPosX > 9) {endPosX = 9;}
        if(endPosY > 9) {endPosY = 9;}
        if(startPosX < 0) {startPosX = 0;}
        if(startPosY < 0) {startPosY = 0;}
        System.out.println("debug: checking from (" + startPosX + "|" + startPosY + ") to (" + endPosX + "|" + endPosY + ")");

        //check from startPosXY to endPosXY if ship would touch other ship 
        for(int currentPosY = startPosY; currentPosY <= endPosY; currentPosY++) {
            for (int currentPosX = startPosX; currentPosX <= endPosX; currentPosX ++) {
                if(field[currentPosY][currentPosX] != 'w') {
                    System.out.println("error: invalid ship placement");
                    return -1;
                }
            }
        }
        return 0;
    }

    //place ship
    public void placeShip(int x, int y, boolean rotation, int type, char[][] field){
        int startPosX; int startPosY; int endPosX; int endPosY;
        int[] tempShipsRemaining = player.getShipsRemaining();

        if (player.shipsRemaining() != 0) {
            if(checkPlacement(x, y, rotation, type, field) == -1) {
                System.out.println("info: no ship was placed");
                return;
            }
            else {
                if(rotation == true) {startPosX = x; startPosY = y; endPosX = startPosX + lengthOfShipList[type] - 1; endPosY = y;}
                else {startPosX = x; startPosY = y; endPosX = x; endPosY = startPosY + lengthOfShipList[type] - 1;}
                System.out.println("debug: placing from (" + startPosX + "|" + startPosY + ") to (" + endPosX + "|" + endPosY + ")");

                for(int currentPosY = startPosY; currentPosY <= endPosY; currentPosY++) {
                    for (int currentPosX = startPosX; currentPosX <= endPosX; currentPosX ++) {
                        field[currentPosY][currentPosX] = 's';
                    }
                }
                tempShipsRemaining[type] --;
                player.setShipsRemaining(tempShipsRemaining);
                return;
            }
        }
        System.out.println("info: no ships remaining");
    }

    //checks if all ships of one player have been hit
    public boolean checkGameOver(char[][] field) {
        int tempShips = 0;
        for(int i = 0; i < field.length; i++) {
            for(int j = 0; j < field[0].length; j++) {
                if(field[i][j] == 's') {
                    tempShips ++;
                }
            }
            System.out.println();
        }
        if (tempShips != 0) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public void attackShip(char field[][]){
        for(int i = 0; i < field.length; i++) {
            for(int j = 0; j < field[0].length; j++) {
                char[][] shot = new char[i][j];
                if(shot[i][j] == 's' || shot[i][j] == 'h'){
                    field[i][j] = 'h'; // h = hit
                }
                else if(shot[i][j] == 'w' || shot[i][j] == 'm'){
                    field[i][j] = 'm'; // m = miss
                }
                
            }
        }
    }

    // algorithm for placing ships
    public void generateShipPlacements(Player player) {

        while(player.shipsRemaining() != 0) {
            placeShip(genRandomPos(), genRandomPos(), genRandomBoolen(), genRandomType(), player.getOwnField());
           

        }
        printField(player.getOwnField());
        
        return;
    }
    public int genRandomPos() {
        return (int)(Math.random() * 10);
    }
    public boolean genRandomBoolen() {
        return Math.random() < 0.5;
    }
    public int genRandomType() {
        return (int)(Math.random() * 4);
    }

    public static void main(String[] args) {

        Game game1 = new Game();
        game1.playRound();

    }
}
