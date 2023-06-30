import java.util.Scanner;

public class TerminalOut {


    //options
    private char shipSymbol = '#';//char for ship (*, #, +)
    private char waterSymbol = '~';//w ater texture
    private char hitSymbol = 'x'; //char if a ship was hit (x)
    private char missSymbol = 'O';//miss

    public TerminalOut() {
    }

    //interface for placing the ships //int[0] = x; int [1] = y
    public void playerInputPlace(Player player) {
        System.out.println("Your Field");
        printFieldWithNumbers(player);
        System.out.println("Input your Ship!");
    }

    //interface while in game
    public void playerInputAttack() {

    }

    public int title() {
        clear();

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
    public int options() {
        clear();

        System.out.println("-------------------------------------------------");
        System.out.println("This Are The OPTIONS");
        System.out.println("To continue input one of the following numbers...");
        System.out.println("1 -> Change Ship Symbol");
        System.out.println("2 -> Change Water Symbol");
        System.out.println("3 -> Change Hit Symbol");
        System.out.println("4 -> Change Miss Symbol");
        System.out.println("5 -> Change Change Name");
        System.out.println("0 -> Return To Main Menu");
        System.out.println("-------------------------------------------------");

        return inputNumberIntRange(0, 5);
    }

    public void credits() {
        clear();

        System.out.println("-------------------------------------------------");
        System.out.println("Made by Nick und Moritz");
        System.out.println("https://github.com/morinator05/raumschiffe-versenken");
        System.out.println();
        System.out.println("Input '0' to get back to main menu!");
        System.out.println("-------------------------------------------------");

        inputNumberIntRange(0,0);

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
        clear();
        System.out.println("   1 2 3 4 5 6 7 8 9 10"); //print numbers from 1 to 10 at the top

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
            System.out.println();
        }
    }
    public void printBothFieldsWithNumbers(Player player) {
        clear();
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

    public int inputCoordX() {
        System.out.println("input x cord:");
        return inputNumberIntRange(1, 10) - 1;
    }

    public int inputCoordY() {
        System.out.println("input y cord:");
        return inputNumberIntRange(1, 10) - 1;
    }

    public boolean inputRotation() {
        System.out.println("input rotation (1-> horizontal, 2->vertical):");
        Scanner scan = new Scanner(System.in);

        while (true) {
            int temp = scan.nextInt();

            if (temp == 1) {
                return true;
            } else if (temp == 2) {
                return false;
            } else {
                System.out.println("bad input, try again");;
            }
        }

    }

    public int inputType(Player player) {
        System.out.println("input type:");
        Scanner scan = new Scanner(System.in);

        while (true) {
            int temp = scan.nextInt();

            if(player.getShipsRemaining()[temp - 1] == 0) {
                System.out.println("no ships of that type left");
            }
            else if (temp <= 4 && temp >= 1) {
                return temp - 1; //-1 to fit the array for the type
            }
            else {
                System.out.println("bad input, try again");
            }
        }
    }

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

    public void clear() {
        for(int i = 0; i < 33; i++) {
            System.out.println();
        }
    }
    public char chooseSymbol() {
        Scanner scan = new Scanner(System.in);

        System.out.print("choose Symbol:");

        return scan.next().charAt(0);
    }
    public void changeName(Player player) {
        Scanner scan = new Scanner(System.in);
        player.setName(scan.next());
    }
    public int inputNumberIntRange(int begin, int end) {
        int temp;
        Scanner scan = new Scanner(System.in);

        //checks if the put in number is in the given range, if not repeat
        do {
            temp = scan.nextInt();
        } while(temp < begin || temp > end);
        return temp;
    }
}