// Im Code verwendete Besonderheiten: OOP, Mehrdimensionale Arrays, Schleifen & Verzweigungen, switch-case
// TODO GUI
// TODO Redo durch r-Eingabe
// TODO Beschränkung wo die Figuren hinfahren
// TODO Timer / Schachuhr

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Init Schachfiguren

        Spielfigur bauerA2 = new Spielfigur(6, 0, "Weiß", "B", "A2", "Bauer");
        Spielfigur bauerB2 = new Spielfigur(6, 1, "Weiß", "B", "B2", "Bauer");
        Spielfigur bauerC2 = new Spielfigur(6, 2, "Weiß", "B", "C2", "Bauer");
        Spielfigur bauerD2 = new Spielfigur(6, 3, "Weiß", "B", "D2", "Bauer");
        Spielfigur bauerE2 = new Spielfigur(6, 4, "Weiß", "B", "E2", "Bauer");
        Spielfigur bauerF2 = new Spielfigur(6, 5, "Weiß", "B", "F2", "Bauer");
        Spielfigur bauerG2 = new Spielfigur(6, 6, "Weiß", "B", "G2", "Bauer");
        Spielfigur bauerH2 = new Spielfigur(6, 7, "Weiß", "B", "H2", "Bauer");

        Spielfigur turmA1 = new Spielfigur(7, 0, "Weiß", "T", "A1", "Turm");
        Spielfigur turmH1 = new Spielfigur(7, 7, "Weiß", "T", "H1", "Turm");
        Spielfigur springerB1 = new Spielfigur(7, 1, "Weiß", "S", "B1", "Springer");
        Spielfigur springerG1 = new Spielfigur(7, 6, "Weiß", "S", "G1", "Springer");
        Spielfigur läuferC1 = new Spielfigur(7, 2, "Weiß", "L", "C1", "Läufer");
        Spielfigur läuferF1 = new Spielfigur(7, 5, "Weiß", "L", "F1", "Läufer");
        Spielfigur queenD1 = new Spielfigur(7, 3, "Weiß", "Q", "D1", "Queen");
        Spielfigur kingE1 = new Spielfigur(7, 4, "Weiß", "K", "E1", "King");


        Spielfigur bauerA7 = new Spielfigur(1, 0, "Grün", "\u001B[32mB\u001B[0m", "A7", "Bauer");
        Spielfigur bauerB7 = new Spielfigur(1, 1, "Grün", "\u001B[32mB\u001B[0m", "B7", "Bauer");
        Spielfigur bauerC7 = new Spielfigur(1, 2, "Grün", "\u001B[32mB\u001B[0m", "C7", "Bauer");
        Spielfigur bauerD7 = new Spielfigur(1, 3, "Grün", "\u001B[32mB\u001B[0m", "D7", "Bauer");
        Spielfigur bauerE7 = new Spielfigur(1, 4, "Grün", "\u001B[32mB\u001B[0m", "E7", "Bauer");
        Spielfigur bauerF7 = new Spielfigur(1, 5, "Grün", "\u001B[32mB\u001B[0m", "F7", "Bauer");
        Spielfigur bauerG7 = new Spielfigur(1, 6, "Grün", "\u001B[32mB\u001B[0m", "G7", "Bauer");
        Spielfigur bauerH7 = new Spielfigur(1, 7, "Grün", "\u001B[32mB\u001B[0m", "H7", "Bauer");

        Spielfigur turmA8 = new Spielfigur(0, 0, "Grün", "\u001B[32mT\u001B[0m", "A8", "Turm");
        Spielfigur turmH8 = new Spielfigur(0, 7, "Grün", "\u001B[32mT\u001B[0m", "H8", "Turm");
        Spielfigur springerB8 = new Spielfigur(0, 1, "Grün", "\u001B[32mS\u001B[0m", "B8", "Springer");
        Spielfigur springerG8 = new Spielfigur(0, 6, "Grün", "\u001B[32mS\u001B[0m", "G8", "Springer");
        Spielfigur läuferC8 = new Spielfigur(0, 2, "Grün", "\u001B[32mL\u001B[0m", "C8", "Läufer");
        Spielfigur läuferF8 = new Spielfigur(0, 5, "Grün", "\u001B[32mL\u001B[0m", "F8", "Läufer");
        Spielfigur queenD8 = new Spielfigur(0, 3, "Grün", "\u001B[32mQ\u001B[0m", "D8", "Queen");
        Spielfigur kingE8 = new Spielfigur(0, 4, "Grün", "\u001B[32mK\u001B[0m", "E8", "King");


        Spielfigur[] Spielfiguren = {bauerA2, bauerB2, bauerC2, bauerD2, bauerE2, bauerF2, bauerG2, bauerH2, turmA1, turmH1, springerB1, springerG1, läuferC1, läuferF1, queenD1, kingE1, bauerA7, bauerB7, bauerC7, bauerD7, bauerE7, bauerF7, bauerG7, bauerH7, turmA8, turmH8, springerB8, springerG8, läuferC8, läuferF8, queenD8, kingE8};
        String[][] Schachbrett = new String[9][9];

        // Felder der grünen Seite mit Figuren befüllen

        for (int j = 0; j < 9; j++) {
            Schachbrett[1][j] = bauerA7.getSymbol();
        }
        Schachbrett[0][0] = turmA8.getSymbol();
        Schachbrett[0][7] = turmH8.getSymbol();
        Schachbrett[0][1] = springerB8.getSymbol();
        Schachbrett[0][6] = springerG8.getSymbol();
        Schachbrett[0][2] = läuferC8.getSymbol();
        Schachbrett[0][5] = läuferF8.getSymbol();
        Schachbrett[0][3] = queenD8.getSymbol();
        Schachbrett[0][4] = kingE8.getSymbol();


        // Restliche Felder des Feldes mit Leerzeichen befüllen
        for (int i = 2; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                Schachbrett[i][j] = " ";
            }
        }


        // Felder der weißen Seite mit Figuren befüllen

        for (int j = 0; j < 9; j++) {
            Schachbrett[6][j] = bauerA2.getSymbol();
        }

        Schachbrett[7][0] = turmA1.getSymbol();
        Schachbrett[7][7] = turmH1.getSymbol();
        Schachbrett[7][1] = springerB1.getSymbol();
        Schachbrett[7][6] = springerG1.getSymbol();
        Schachbrett[7][2] = läuferC1.getSymbol();
        Schachbrett[7][5] = läuferF1.getSymbol();
        Schachbrett[7][3] = queenD1.getSymbol();
        Schachbrett[7][4] = kingE1.getSymbol();


        Ausgabe(Schachbrett);
        System.out.println();

        moveFigures(Spielfiguren, Schachbrett);


        // -------------------------------------------------------------------------------------------------------------
    }

    public static void Ausgabe(String[][] Schachbrett) {

        char[] buchstaben = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

        // Buchstaben ausgeben
        for (int i = 0; i < buchstaben.length; i++) {
            System.out.print("\t" + buchstaben[i]);
        }
        System.out.println();

        // Zahlen am Rand ausgeben & wirkliches Schachbrett erstellen
        for (int i = 0; i < Schachbrett.length - 1; i++) {
            System.out.print(8 - i);
            for (int j = 0; j < Schachbrett[i].length - 1; j++) {
                System.out.print(" | " + Schachbrett[i][j]);
                if (Schachbrett.length - 2 == j) {
                    System.out.print(" | " + (8 - i));
                }
            }

            System.out.println();
        }

        // Buchstaben ausgeben
        for (int i = 0; i < buchstaben.length; i++) {
            System.out.print("\t" + buchstaben[i]);
        }

    }

    public static void moveFigures(Spielfigur[] Spielfiguren, String[][] Schachbrett) {

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Gib die Position der Figur ein, die du bewegen möchtest: ");
            String eingabeUrsprünglichePosition = sc.next();
            if (eingabeUrsprünglichePosition.equals("c")) {
                System.out.println("Die Partie ist beendet!");
                break;
            }
            System.out.println("Wohin möchtest du sie bewegen?: ");
            String eingabeZielPosition = sc.next();

            String vergleichsObjekt = converter(eingabeZielPosition);
            String[] vergleichsObjektArray = vergleichsObjekt.split(" ");


            if (Schachbrett[Integer.parseInt(vergleichsObjektArray[0])][Integer.parseInt(vergleichsObjektArray[1])].equals(" ")) {
                for (int i = 0; i < Spielfiguren.length; i++) {
                    if (Spielfiguren[i].getID().equals(eingabeUrsprünglichePosition)) {
                        Spielfiguren[i].setID(eingabeZielPosition);

                        String codeDerUrsprünglichenPosition = converter(eingabeUrsprünglichePosition);
                        String[] array = codeDerUrsprünglichenPosition.split(" ");
                        int iIndex = Integer.parseInt(array[0]);
                        int jIndex = Integer.parseInt(array[1]);
                        Schachbrett[iIndex][jIndex] = " ";


                        String codeDerZielPosition = converter(eingabeZielPosition);
                        String[] array2 = codeDerZielPosition.split(" ");
                        int iIndex2 = Integer.parseInt(array2[0]);
                        int jIndex2 = Integer.parseInt(array2[1]);
                        Schachbrett[iIndex2][jIndex2] = Spielfiguren[i].getSymbol();

                    }
                }
            } else {
                for (int i = 0; i < Spielfiguren.length; i++) {
                    if (Spielfiguren[i].getID().equals(eingabeUrsprünglichePosition)) {

                        for (int x = 0; x < Spielfiguren.length; x++) {
                            if (Spielfiguren[x].getID().equals(eingabeZielPosition)) {

                                System.out.println(Spielfiguren[i].getName() + " " + Spielfiguren[i].getFarbe() + " hat " + Spielfiguren[x].getName() + " " + Spielfiguren[x].getFarbe() + " an der Stelle " + Spielfiguren[x].getID() + " geschlagen!");


//                                String z = converter(eingabeZielPosition);
//                                String[] array4 = z.split(" ");
//                                int iIndex4 = Integer.parseInt(array4[0]);
//                                int jIndex4 = Integer.parseInt(array4[1]);
//                                Schachbrett[iIndex4][jIndex4] = Spielfiguren[i].getSymbol();


                            }
                        }





                        String codeDerUrsprünglichenPosition = converter(eingabeUrsprünglichePosition);
                        String[] array = codeDerUrsprünglichenPosition.split(" ");
                        int iIndex = Integer.parseInt(array[0]);
                        int jIndex = Integer.parseInt(array[1]);
                        Schachbrett[iIndex][jIndex] = " ";



                        String codeDerZielPosition = converter(eingabeZielPosition);
                        String[] array2 = codeDerZielPosition.split(" ");
                        int iIndex2 = Integer.parseInt(array2[0]);
                        int jIndex2 = Integer.parseInt(array2[1]);
                        Schachbrett[iIndex2][jIndex2] = Spielfiguren[i].getSymbol();
                        // TODO Wenn man jemanden geschlagen hat, und man dann wieder wegfährt, fährt man mit der geschlagenen Figur...

                        Spielfiguren[i].setID(eingabeZielPosition);

                    }

                }

            }
            Ausgabe(Schachbrett);
        }
    }


    public static String converter(String eingabe) {
        switch (eingabe) {
            case "A8":
                return "0 0";
            case "B8":
                return "0 1";
            case "C8":
                return "0 2";
            case "D8":
                return "0 3";
            case "E8":
                return "0 4";
            case "F8":
                return "0 5";
            case "G8":
                return "0 6";
            case "H8":
                return "0 7";
            case "A7":
                return "1 0";
            case "B7":
                return "1 1";
            case "C7":
                return "1 2";
            case "D7":
                return "1 3";
            case "E7":
                return "1 4";
            case "F7":
                return "1 5";
            case "G7":
                return "1 6";
            case "H7":
                return "1 7";
            case "A6":
                return "2 0";
            case "B6":
                return "2 1";
            case "C6":
                return "2 2";
            case "D6":
                return "2 3";
            case "E6":
                return "2 4";
            case "F6":
                return "2 5";
            case "G6":
                return "2 6";
            case "H6":
                return "2 7";
            case "A5":
                return "3 0";
            case "B5":
                return "3 1";
            case "C5":
                return "3 2";
            case "D5":
                return "3 3";
            case "E5":
                return "3 4";
            case "F5":
                return "3 5";
            case "G5":
                return "3 6";
            case "H5":
                return "3 7";
            case "A4":
                return "4 0";
            case "B4":
                return "4 1";
            case "C4":
                return "4 2";
            case "D4":
                return "4 3";
            case "E4":
                return "4 4";
            case "F4":
                return "4 5";
            case "G4":
                return "4 6";
            case "H4":
                return "4 7";
            case "A3":
                return "5 0";
            case "B3":
                return "5 1";
            case "C3":
                return "5 2";
            case "D3":
                return "5 3";
            case "E3":
                return "5 4";
            case "F3":
                return "5 5";
            case "G3":
                return "5 6";
            case "H3":
                return "5 7";
            case "A2":
                return "6 0";
            case "B2":
                return "6 1";
            case "C2":
                return "6 2";
            case "D2":
                return "6 3";
            case "E2":
                return "6 4";
            case "F2":
                return "6 5";
            case "G2":
                return "6 6";
            case "H2":
                return "6 7";
            case "A1":
                return "7 0";
            case "B1":
                return "7 1";
            case "C1":
                return "7 2";
            case "D1":
                return "7 3";
            case "E1":
                return "7 4";
            case "F1":
                return "7 5";
            case "G1":
                return "7 6";
            case "H1":
                return "7 7";
        }
        return "0 0";
    }
}