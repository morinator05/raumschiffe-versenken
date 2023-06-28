import java.util.Scanner;

public class TerminalOut {

    //options
    private int lang = 1;//1-> german, 0-> english, 2-> french
    private char shipSymbol = '#';//char for ship (*, #, +)
    private char waterSymbol = '~';//w ater texture
    private char hitSymbol = 'x'; //char if a ship was hit (x)
    private char missSymbol = 'O';//miss
    //private String[][] terminalMessages = { {"Your Field:", "Enemy Field:", "Input the X Coord:",       "Input the Y Coord:",      "Input the Rotation(1->vertical, 2->horizontal): ",  "Bad Input, try aggain:",               "Input Your Placement Parameters for (next) the ship:",    "Input the Type:",          "No ships of this type remaining, try other:",               "Welcome to Raumschiffe-Versenken!",    "Options -> 1",     "Start Round -> 2",     "Input:"},
    //                                        {"Dein Feld:",  "Gengner Feld", "Gib die X Position ein:",  "Gib die Y Position ein:", "Gib die Richtung ein(1->vertikal, 2->horizontal):", "Ungültige Eingabe, versuche erneut:",  "Gib die Parameter für das (nächste) Schiff ein:",            "Geben sie den Typ ein:",   "Keine Schiffe dieses Typs mehr, anderen Typ eingeben:",  "Willkommen zu Raumschiffe-Versenken",  "Optionen -> 1",    "Starte Runde -> 2",    "Eingabe:"},
    //};

    public TerminalOut() {
    }

    //print console messages for the player to read (info etc.)
    public void TerminalMessageOut(int message) {
        switch (message) {
            case 1: {
                System.out.println("You Won!");
            }
            case 2: {
                System.out.println("You Lost!");
            }
            case 3: {
                System.out.println("Ship placement not allowed!");
            }
            case 4: {
                System.out.println("Error!");
            }
            case 5: {
                System.out.println("Winner Winner Chicken Dinner");
            }
            case 6: {
                System.out.println("Miss!");
            }
            case 7: {
                System.out.println("Hit!");
            }
            case 8: {
                System.out.println("Made by: ");
            }
            case 9: {
                System.out.println("");
            }
        }
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
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome");
        System.out.println("options -> 1, start round -> 2");

        return scan.nextInt();

    }

    //options menu interfaces
    public void options() {


    }

    public void printFieldWithNumbers(Player player) {
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
}