import java.util.Scanner;

public class TerminalOut {


    //options
    private char shipSymbol = '#';//char for ship (*, #, +)
    private char waterSymbol = '~';//w ater texture
    private char hitSymbol = 'x'; //char if a ship was hit (x)
    private char missSymbol = 'O';//miss

    public TerminalOut() {
    }

    //interface for placing the ships
    public void playerInputPlace(Player player) {
        clear();
        System.out.println("-------------------------------------------------");
        System.out.println("Your Field:");
        printFieldWithNumbers(player);
        System.out.println("Input your Ship!");
        System.out.println("-------------------------------------------------");
    }

    public void playerAttack(Player player) {
        System.out.println("-------------------------------------------------");
        System.out.println("   Enemy Field:               Your Field:");
        printBothFieldsWithNumbers(player);
        System.out.println("-------------------------------------------------");
        System.out.println("Input Coordinates!");
    }

    public int title() {

        System.out.println("-------------------------------------------------");
        System.out.println("WELCOME To Raumschiffe-Versenken");
        System.out.println("To continue input one of the following numbers...");
        System.out.println("1 -> Options Menu (change the symbols and name)");
        System.out.println("2 -> Start New Game");
        System.out.println("3 -> Credits");
        System.out.println("0 -> Exit");
        System.out.println("-------------------------------------------------");

        return inputNumberIntRange(0, 3);
    }

    //options menu interfaces
    public int options(Player player) {
        clear();

        System.out.println("-------------------------------------------------");
        System.out.println("This Are The OPTIONS");
        System.out.println("To continue input one of the following numbers...");
        System.out.println("1 -> Change Ship Symbol, current: " + shipSymbol);
        System.out.println("2 -> Change Water Symbol, current: " + waterSymbol);
        System.out.println("3 -> Change Hit Symbol, current: " + hitSymbol);
        System.out.println("4 -> Change Miss Symbol, current: " + missSymbol);
        System.out.println("5 -> Change Change Name, current: " + player.getName());
        System.out.println("0 -> Return To Main Menu");
        System.out.println("-------------------------------------------------");

        return inputNumberIntRange(0, 5);
    }

    public void credits() {
        clear();

        System.out.println("-------------------------------------------------");
        System.out.println("Made by Nick und Moritz");
        System.out.println();
        System.out.println("Input '0' to get back to main menu!");
        System.out.println("-------------------------------------------------");

        inputNumberIntRange(0,0);

    }

    public void alreadyHit() {
        System.out.println("You already shot at this position, choose different:");
    }

    public void win(int winner, Player player) {
        clear();
        switch (winner) {
            case 1:
                System.out.println("You/" + player.getName() + " Won!"); break;
            case 2:
                System.out.println("The Computer Won!"); break;
        }
    }

    public void printFieldWithNumbers(Player player) {
        System.out.println("   1 2 3 4 5 6 7 8 9 10"); //print x axis numbers

        for (int i = 0; i < player.getOwnField().length; i++) {

            //print Y axis numbers
            if (i < 9) {
                System.out.print(i + 1 + "  ");
            } else {
                System.out.print(i + 1 + " ");
            }

            for (int j = 0; j < player.getOwnField()[0].length; j++) {
                if (player.getOwnField()[i][j] == 'w') {
                    System.out.print(waterSymbol + " ");
                } else if (player.getOwnField()[i][j] == 's') {
                    System.out.print(shipSymbol + " ");
                } else if (player.getOwnField()[i][j] == 'h') {
                    System.out.print(hitSymbol + " ");
                } else if (player.getOwnField()[i][j] == 'm') {
                    System.out.print(missSymbol + " ");
                }
            }
            System.out.println();
        }
    }
    public void printBothFieldsWithNumbers(Player player) {
        System.out.println("   1 2 3 4 5 6 7 8 9 10       1 2 3 4 5 6 7 8 9 10"); //print numbers from 1 to 10 at the top

        for (int i = 0; i < player.getOwnField().length; i++) {

            //print numbers from 1 to 10 vertically for each line
            if (i < 9) {
                System.out.print(i + 1 + "  ");
            } else {
                System.out.print(i + 1 + " ");
            }

            for (int j = 0; j < player.getOwnField()[0].length; j++) {
                if (player.getOwnField()[i][j] == 'w') {
                    System.out.print(waterSymbol + " ");
                } else if (player.getOwnField()[i][j] == 's') {
                    System.out.print(shipSymbol + " ");
                } else if (player.getOwnField()[i][j] == 'h') {
                    System.out.print(hitSymbol + " ");
                } else if (player.getOwnField()[i][j] == 'm') {
                    System.out.print(missSymbol + " ");
                }
            }

            //print Y axis numbers
            System.out.print("    ");
            if (i < 9) {
                System.out.print(i + 1 + "  ");
            } else {
                System.out.print(i + 1 + " ");
            }

            for (int j = 0; j < player.getEnemyField()[0].length; j++) {
                if (player.getEnemyField()[i][j] == 'w') {
                    System.out.print(waterSymbol + " ");
                } else if (player.getEnemyField()[i][j] == 's') {
                    System.out.print(shipSymbol + " ");
                } else if (player.getEnemyField()[i][j] == 'h') {
                    System.out.print(hitSymbol + " ");
                } else if (player.getEnemyField()[i][j] == 'm') {
                    System.out.print(missSymbol + " ");
                }
            }
            System.out.println();
        }
    }

    //Input the Coordinates
    public int inputCoordX() {
        System.out.print("input X cord:");
        return inputNumberIntRange(1, 10) - 1;
    }
    public int inputCoordY() {
        System.out.print("input Y cord:");
        return inputNumberIntRange(1, 10) - 1;
    }

    //input the rotation of the ship
    public boolean inputRotation() {
        System.out.print("Input rotation (1-> horizontal, 2->vertical):");
        Scanner scan = new Scanner(System.in);

        //converts to boolean because Game.java uses boolean, which is bad for user input
        while (true) {
            int temp = scan.nextInt();

            if (temp == 1) {
                return true;
            } else if (temp == 2) {
                return false;
            } else {
                System.out.print("Bad input, try again:");;
            }
        }

    }

    //inputs the type for the ship
    public int inputType(Player player) {
        int temp;

        System.out.print("Ships left: small: " + player.getShipsRemaining()[0] + ", ");
        System.out.print("medium: " + player.getShipsRemaining()[1] + ", ");
        System.out.print("big: " + player.getShipsRemaining()[2] + ", ");
        System.out.println("huge: " + player.getShipsRemaining()[3] + ", ");
        System.out.print("input type:");

        //input number from 1 to 4 and check if on that index ships are remaining
        while (true) {
            temp = inputNumberIntRange(1,4);
            if(player.getShipsRemaining()[temp - 1] == 0) {
                System.out.print("No ships of that type left, choose different:");
            }
            else {
                return temp - 1;
            }
        }
    }

    //very bad idea but work fine
    public void clear() {
        for(int i = 0; i < 40; i++) {
            System.out.println();
        }
    }

    //input char
    public char chooseSymbol() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Choose symbol:");

        return scan.next().charAt(0);
    }

    //set new name
    public void changeName(Player player) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Choose new name:");
        player.setName(scan.next());
    }

    //inputs number in given range
    public int inputNumberIntRange(int begin, int end) {
        int temp;
        Scanner scan = new Scanner(System.in);

        //checks if the put in number is in the given range, if not repeat
        do {
            temp = scan.nextInt();
        } while(temp < begin || temp > end);
        return temp;
    }

    //setter and getter for the symbols
    public void setShipSymbol() {
        this.shipSymbol = chooseSymbol();
    }

    public void setWaterSymbol() {
        this.waterSymbol = chooseSymbol();
    }

    public void setHitSymbol() {
        this.hitSymbol = chooseSymbol();
    }

    public void setMissSymbol() {
        this.missSymbol = chooseSymbol();
    }
}