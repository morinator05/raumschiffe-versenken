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
        Scanner scan = new Scanner(System.in);

        System.out.println("WELCOME to Raumschiffe-Versenken");
        System.out.println("To continue input one of the following numbers...");
        System.out.println("1 -> Options menu (change the symbols)");
        System.out.println("2 -> Start new game");

        return scan.nextInt();
    }

    //options menu interfaces
    public int options() {
        clear();
        Scanner scan = new Scanner(System.in);

        System.out.println("OPTIONS");
        System.out.println("Choose the Symbol you want to change...");
        System.out.println("Ship -> 1, Water -> 2, Hit -> 3, Miss -> 4");
        System.out.println("To exit options -> 0");

        return scan.nextInt();
    }
    public char chooseSymbol() {
        Scanner scan = new Scanner(System.in);

        System.out.print("choose Symbol:");

        return scan.next().charAt(0);
    }

    public void win(int winner) {
        clear();
        switch (winner) {
            case 1:
                System.out.println("You Win!"); break;
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
        Scanner scan = new Scanner(System.in);
        return scan.nextInt() - 1;
    }

    public int inputCoordY() {
        System.out.println("input y cord:");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt() - 1;
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

    public void setShipSymbol(char shipSymbol) {
        this.shipSymbol = shipSymbol;
    }

    public void setWaterSymbol(char waterSymbol) {
        this.waterSymbol = waterSymbol;
    }

    public void setHitSymbol(char hitSymbol) {
        this.hitSymbol = hitSymbol;
    }

    public void setMissSymbol(char missSymbol) {
        this.missSymbol = missSymbol;
    }

    public void clear() {
        for(int i = 0; i < 33; i++) {
            System.out.println();
        }
    }

}