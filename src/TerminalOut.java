import java.util.Scanner;

public class TerminalOut {


    //options
    private char shipSymbol = '#';//char for ship (*, #, +)
    private char waterSymbol = '~';//w ater texture
    private char hitSymbol = 'x'; //char if a ship was hit (x)
    private char missSymbol = 'O';//miss
    private int lang = 0;

    public TerminalOut() {
    }

    public String language(int lang, int temp){
        String[][] language = {{"Your Field:", "Input your Ship!",              "   Enemy Field:               Your Field:", "Input Coordinates!",    "WELCOME To Raumschiffe-Versenken",  "To continue input one of the following numbers...",           "1 -> Options Menu (change the symbols, name and language)",             "2 -> Start New Game",         "3 -> Credits", "0 -> Exit",          "This Are The OPTIONS",   "To continue input one of the following numbers...",           "1 -> Change Ship Symbol, current: ",        "2 -> Change Water Symbol, current: ",       "3 -> Change Hit Symbol, current: ",            "4 -> Change Miss Symbol, current: ",          "5 -> Change Name, current: ",          "6 -> Change Language, current: ",      "0 -> Return To Main Menu",        "Made by Nick und Moritz",     "Input '0' to get back to main menu!",                    "The Computer Won!",          "input X cord:",          "input Y cord:",          "Input rotation (1-> horizontal, 2-> vertical):",    "Bad input, try again:",                  "Ships left: small: ",        "medium: ", "big: ",  "huge: ",       "input type:",   "No ships of that type left, choose different:",             "Choose symbol:",         "Choose new name:",         "Choose Language (0-> English, 1-> German): ",         "Bad Input, try again! "},
                               {"Dein Feld:",  "Geben Sie ihre Schiffe an!",    "   Gegner Feld:               Dein Feld:" , "Koordinaten eingeben!", "WILKOMMEN zu Raumschiffe-Versenken","Um fortzufahren geben sie eine der folgenden Nummern ein...", "1 -> Optionen Menu (ändere die Symbole, deinen Namen und die Sprache)", "2 -> Starte ein neues Spiel", "3 -> Credits", "0 -> Spiel Beenden", "Das sind die OPTIONEN ", "Um fortzufahren geben sie eine der folgenden Nummern ein...", "1 -> Ändere das Schiff Symbol, jetziges: ", "2 -> Ändere das Wasser Symbol, jetziges: ", "3 -> Ändere das Getroffen Symbol, jetziges: ", "4 -> Ändere das Vertroffen Symbol, jetziges: ", "6 -> Ändere deinen Namen, jetziger: ", "6 -> Ändere die Sprache, jetzige: ", "0 -> Zum Hauptmenü zurückkehren", "Gemacht von Nick und Moritz", "Geben Sie '0' ein, um in das Hauptmenü zurückzukehren!", "Der Computer hat gewonnen!", "X Koordinate eingeben:", "Y Koordinate eingeben:", "Rotation eingeben (1-> Horizontal, 2-> Vertikal):", "Schlechte Eingabe, versuche es erneut:", "Schiffe verbleibend: Klein", "Mittel: ", "Groß: ", "Gigantisch: ", "Typ eingeben:", "Keine Schiffe dieses Typs verbleibend, wähle eine andere:", "Wähle das Symbol aus.:", "Wähle einen neuen Namen:", "Wähle die Sprache aus (0-> Englisch, 1-> Deutsch): ", "Schlechte Eingabe, versuche es erneut!"},
                               {}};
        
        return language[lang][temp];
    }
    //interface for placing the ships
    public void playerInputPlace(Player player) {
        clear();
        System.out.println("-------------------------------------------------");
        System.out.println(language(lang, 0));
        printFieldWithNumbers(player);
        System.out.println(language(lang, 1));
        System.out.println("-------------------------------------------------");
    }

    public void playerAttack(Player player) {
        System.out.println("-------------------------------------------------");
        System.out.println(language(lang, 2));
        printBothFieldsWithNumbers(player);
        System.out.println("-------------------------------------------------");
        System.out.println(language(lang, 3));
    }

    public int title() {

        System.out.println("-------------------------------------------------");
        System.out.println(language(lang, 4));
        System.out.println(language(lang, 5));
        System.out.println(language(lang, 6));
        System.out.println(language(lang, 7));
        System.out.println(language(lang, 8));
        System.out.println(language(lang, 9));
        System.out.println("-------------------------------------------------");

        return inputNumberIntRange(0, 3);
    }

    //options menu interfaces
    public int options(Player player) {
        clear();

        System.out.println("-------------------------------------------------");
        System.out.println(language(lang, 10));
        System.out.println(language(lang, 11));
        System.out.println(language(lang, 12) + shipSymbol);
        System.out.println(language(lang, 13) + waterSymbol);
        System.out.println(language(lang, 14) + hitSymbol);
        System.out.println(language(lang, 15) + missSymbol);
        System.out.println(language(lang, 16) + player.getName());
        System.out.println(language(lang, 17)+ lang);
        System.out.println(language(lang, 18));
        System.out.println("-------------------------------------------------");

        return inputNumberIntRange(0, 6);
    }

    public void credits() {
        clear();

        System.out.println("-------------------------------------------------");
        System.out.println(language(lang, 19));
        System.out.println("https://github.com/morinator05/raumschiffe-versenken");
        System.out.println();
        System.out.println(language(lang, 20));
        System.out.println("-------------------------------------------------");

        inputNumberIntRange(0,0);

    }

    public void win(int winner, Player player) {
        clear();
        switch (winner) {
            case 1:
                System.out.println("----------------------------------------------------------------------------------------------------------"); 
                System.out.println("//    //   /////////	//     //	//            ////           //	   ////////	   ///     //   //");
                System.out.println(" // //   //        //	//     // 	 //         //   //         //   //       //	 // //    //    //");
                System.out.println("  //    //         //	//     //  	  //       //     //       //   //        //    //  //   //     //");
                System.out.println("  //    //         //	//     //	   //     //       //     //    //        //   //   //  //      //");
                System.out.println("  //    //        //	//     //    	    //   //         //   //     //       //   //    // //       ");
                System.out.println("  //	 /////////	  ////  	     ////            ////        ////////    //      ///        //");
                System.out.println("----------------------------------------------------------------------------------------------------------");
                System.out.println(player.getName());
                for(int i =0; i<06; i++){
                    System.out.println(" ");
                } break;
                //System.out.println("You/" + player.getName() + " Won!");
            case 2:
                System.out.println(language(lang, 21)); break;
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
        System.out.print(language(lang, 22));
        return inputNumberIntRange(1, 10) - 1;
    }
    public int inputCoordY() {
        System.out.print(language(lang, 23));
        return inputNumberIntRange(1, 10) - 1;
    }

    //input the rotation of the ship
    public boolean inputRotation() {
        System.out.print(language(lang, 24));
        Scanner scan = new Scanner(System.in);

        //converts to boolean because Game.java uses boolean, which is bad for user input
        while (true) {
            int temp = scan.nextInt();

            if (temp == 1) {
                return true;
            } else if (temp == 2) {
                return false;
            } else {
                System.out.print(language(lang, 25));;
            }
        }

    }

    //inputs the type for the ship
    public int inputType(Player player) {
        int temp;

        System.out.print(language(lang, 26) + player.getShipsRemaining()[0] + ", ");
        System.out.print(language(lang, 27) + player.getShipsRemaining()[1] + ", ");
        System.out.print(language(lang, 28) + player.getShipsRemaining()[2] + ", ");
        System.out.println(language(lang, 29) + player.getShipsRemaining()[3] + ", ");
        System.out.print(language(lang, 30));

        //input number from 1 to 4 and check if on that index ships are remaining
        while (true) {
            temp = inputNumberIntRange(1,4);
            if(player.getShipsRemaining()[temp - 1] == 0) {
                System.out.print(language(lang, 31));
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

        System.out.print(language(lang, 32));

        return scan.next().charAt(0);
    }

    //set new name
    public void changeName(Player player) {
        Scanner scan = new Scanner(System.in);
        System.out.print(language(lang, 33));
        player.setName(scan.next());
    }
    public int changeLang(Player player) {
        Scanner scan = new Scanner(System.in);
        System.out.println(language(lang, 34));
        lang = scan.nextInt();
        
        return lang;
            
            
            
        

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