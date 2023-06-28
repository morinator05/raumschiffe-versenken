import java.util.Scanner;

public class TerminalOut {

    //options
    private int lang = 1;//1-> german, 0-> english, 2-> french
    private char shipSymbol = '#';//char for ship (*, #, +)
    private char waterSymbol = '~';//w ater texture
    private char hitSymbol = 'x'; //char if a ship was hit (x, )
    private char missSymbol = 'O';//miss
    private String[][] terminalMessages = { {"Your Field:", "Enemy Field:", "Input the X Coord:",       "Input the Y Coord:",      "Input the Rotation: ",  "Bad Input, try aggain:",               "Input Your Placement Parameters for the ship:",    "Input the Type:",          "No ships of this type remaining, try other:"           },
                                            {"Dein Feld:",  "Gengner Feld", "Gib die X Position ein:",  "Gib die Y Position ein:", "Gib die Richtung ein:", "Ungültige Eingabe, versuche erneut:",  "Gib die Parameter für das Schiff ein:",            "Geben sie den Typ ein:",   "Keine Schiffe dieses Typs mehr, anderen Typ eingeben:" },
    };

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
    public void playerInputPlace(char[][] ownField) {
        System.out.println(terminalMessages[lang][0]);
        printFieldWithNumbers(ownField);
        System.out.println(terminalMessages[lang][6]);
    }

    //interface while in game
    public void playerInputAttack() {

    }

    //options menu interfaces
    public void options() {

    }

    private void printFieldWithNumbers(char[][] field) {
        System.out.println("   1 2 3 4 5 6 7 8 9 10"); //print numbers from 1 to 10 at the top

        for (int i = 0; i < field.length; i++) {

            //print numbers from 1 to 10 vertically for each line
            if (i < 9) {
                System.out.print(i + 1 + "  ");
            } else {
                System.out.print(i + 1 + " ");
            }

            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == 'w') {
                    System.out.print(waterSymbol + " ");
                } else if (field[i][j] == 's') {
                    System.out.print(shipSymbol + " ");
                } else if (field[i][j] == 'h') {
                    System.out.print(hitSymbol + " ");
                } else if (field[i][j] == 'm') {
                    System.out.print(missSymbol + " ");
                }
            }
            System.out.println();
        }
    }

    public int inputCoordX() {
        System.out.println(terminalMessages[lang][2]);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt() - 1;
    }

    public int inputCoordY() {
        System.out.println(terminalMessages[lang][3]);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt() - 1;
    }

    public boolean inputRotation() {
        System.out.println(terminalMessages[lang][4]);
        Scanner scan = new Scanner(System.in);

        while (true) {
            int temp = scan.nextInt();

            if (temp == 1) {
                return true;
            } else if (temp == 2) {
                return false;
            } else {
                System.out.println(terminalMessages[lang][5]);
            }
        }

    }

    public int inputType(int[] shipsRemaining) {
        System.out.println(terminalMessages[lang][7]);
        Scanner scan = new Scanner(System.in);

        while (true) {
            int temp = scan.nextInt();

            if(shipsRemaining[temp - 1] != 0) {
                System.out.println(terminalMessages[lang][8]);
            }
            else if (temp <= 4 && temp >= 1) {
                return temp - 1; //-1 to fit the array for the type
            }
            else {
                System.out.println(terminalMessages[lang][5]);
            }
        }
    }
}