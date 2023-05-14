public class Game {

    //associations
    Player player;
    ComputerEnemy computerplayer;
    Gui gui = new Gui();

    //variables
    
    
    public Game() {
        gui = new Gui();
        player = new Player("null");
        computerplayer = new  ComputerEnemy();
    }

    //plays one round and returns the winner
    public int playRound() {
        boolean gameOver = false;
        
        while(player.shipsRemaining() != 0) {
            placeShip(1,1,false,0, player.getOwnField());
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
        int lengthOfShip = getLengthFromType(type);

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
        if(checkPlacement(x, y, rotation, type, field) == -1) {
            System.out.println("info: no ship was placed");
        }
        else {
            if(rotation == true) {startPosX = x; startPosY = y; endPosX = startPosX + getLengthFromType(type) - 1; endPosY = y;}
            else {startPosX = x; startPosY = y; endPosX = x; endPosY = startPosY + getLengthFromType(type) - 1;}
            System.out.println("debug: placing from (" + startPosX + "|" + startPosY + ") to (" + endPosX + "|" + endPosY + ")");

            for(int currentPosY = startPosY; currentPosY <= endPosY; currentPosY++) {
                for (int currentPosX = startPosX; currentPosX <= endPosX; currentPosX ++) {
                    field[currentPosY][currentPosX] = 's';
                }
            }
            tempShipsRemaining[type] --;
            player.setShipsRemaining(tempShipsRemaining);
        }
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

    private int getLengthFromType(int type) {
        int[] lengthOfShipList = {2, 3, 4, 5}; //small, small_medium, large_medium, large
        switch (type) {
            case 0: return lengthOfShipList[0];
            case 1: return lengthOfShipList[1];
            case 2: return lengthOfShipList[2];
            case 3: return lengthOfShipList[3];
        }
        System.out.println("error: could not get length of ship from type");
        return -1;
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

    public static void main(String[] args) {

        Game game1 = new Game();
        game1.playRound();

    }
}
