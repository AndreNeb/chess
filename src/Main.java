// FIXME: Man soll eine Info ausgeben, wenn man versucht, eine Figur zu Bewegen, die man nicht bewegen kann, weil direkt vor einem zB eine eigene Figur steht (ein Turm wird am Anfang zB von zwei Figuren eingeschlossen)
// TODO: Spezielle Spielzüge beachten (En passant, Bauernumwandlung & Rochade)
// TODO: README verbessern & auf Englisch schreiben
// TODO: Check if Checkmate
// TODO: Check if Chess


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        // Init Chess Figures

        Spielfigur bauerA2 = new Spielfigur(6, 0, "Weiß", "♟", "A2", "Bauer", 0);
        Spielfigur bauerB2 = new Spielfigur(6, 1, "Weiß", "♟", "B2", "Bauer", 0);
        Spielfigur bauerC2 = new Spielfigur(6, 2, "Weiß", "♟", "C2", "Bauer", 0);
        Spielfigur bauerD2 = new Spielfigur(6, 3, "Weiß", "♟", "D2", "Bauer", 0);
        Spielfigur bauerE2 = new Spielfigur(6, 4, "Weiß", "♟", "E2", "Bauer", 0);
        Spielfigur bauerF2 = new Spielfigur(6, 5, "Weiß", "♟", "F2", "Bauer", 0);
        Spielfigur bauerG2 = new Spielfigur(6, 6, "Weiß", "♟", "G2", "Bauer", 0);
        Spielfigur bauerH2 = new Spielfigur(6, 7, "Weiß", "♟", "H2", "Bauer", 0);

        Spielfigur turmA1 = new Spielfigur(7, 0, "Weiß", "♜", "A1", "Turm", 0);
        Spielfigur turmH1 = new Spielfigur(7, 7, "Weiß", "♜", "H1", "Turm", 0);
        Spielfigur springerB1 = new Spielfigur(7, 1, "Weiß", "♞", "B1", "Springer", 0);
        Spielfigur springerG1 = new Spielfigur(7, 6, "Weiß", "♞", "G1", "Springer", 0);
        Spielfigur läuferC1 = new Spielfigur(7, 2, "Weiß", "♝", "C1", "Läufer", 0);
        Spielfigur läuferF1 = new Spielfigur(7, 5, "Weiß", "♝", "F1", "Läufer", 0);
        Spielfigur queenD1 = new Spielfigur(7, 3, "Weiß", "♛", "D1", "Queen", 0);
        Spielfigur kingE1 = new Spielfigur(7, 4, "Weiß", "♚", "E1", "King", 0);

        Spielfigur bauerA7 = new Spielfigur(1, 0, "Grün", "\u001B[32m♟\u001B[0m", "A7", "Bauer", 0);
        Spielfigur bauerB7 = new Spielfigur(1, 1, "Grün", "\u001B[32m♟\u001B[0m", "B7", "Bauer", 0);
        Spielfigur bauerC7 = new Spielfigur(1, 2, "Grün", "\u001B[32m♟\u001B[0m", "C7", "Bauer", 0);
        Spielfigur bauerD7 = new Spielfigur(1, 3, "Grün", "\u001B[32m♟\u001B[0m", "D7", "Bauer", 0);
        Spielfigur bauerE7 = new Spielfigur(1, 4, "Grün", "\u001B[32m♟\u001B[0m", "E7", "Bauer", 0);
        Spielfigur bauerF7 = new Spielfigur(1, 5, "Grün", "\u001B[32m♟\u001B[0m", "F7", "Bauer", 0);
        Spielfigur bauerG7 = new Spielfigur(1, 6, "Grün", "\u001B[32m♟\u001B[0m", "G7", "Bauer", 0);
        Spielfigur bauerH7 = new Spielfigur(1, 7, "Grün", "\u001B[32m♟\u001B[0m", "H7", "Bauer", 0);

        Spielfigur turmA8 = new Spielfigur(0, 0, "Grün", "\u001B[32m♜\u001B[0m", "A8", "Turm", 0);
        Spielfigur turmH8 = new Spielfigur(0, 7, "Grün", "\u001B[32m♜\u001B[0m", "H8", "Turm", 0);
        Spielfigur springerB8 = new Spielfigur(0, 1, "Grün", "\u001B[32m♞\u001B[0m", "B8", "Springer", 0);
        Spielfigur springerG8 = new Spielfigur(0, 6, "Grün", "\u001B[32m♞\u001B[0m", "G8", "Springer", 0);
        Spielfigur läuferC8 = new Spielfigur(0, 2, "Grün", "\u001B[32m♝\u001B[0m", "C8", "Läufer", 0);
        Spielfigur läuferF8 = new Spielfigur(0, 5, "Grün", "\u001B[32m♝\u001B[0m", "F8", "Läufer", 0);
        Spielfigur queenD8 = new Spielfigur(0, 3, "Grün", "\u001B[32m♛\u001B[0m", "D8", "Queen", 0);
        Spielfigur kingE8 = new Spielfigur(0, 4, "Grün", "\u001B[32m♚\u001B[0m", "E8", "King", 0);

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


        Spielfigur[] vonWeißGeschlageneSpielfiguren = new Spielfigur[16];
        Spielfigur[] vonGrünGeschlageneSpielfiguren = new Spielfigur[16];

        System.out.println();
        Ausgabe(Schachbrett, vonWeißGeschlageneSpielfiguren, vonGrünGeschlageneSpielfiguren);
        System.out.println();

        moveFigures(Spielfiguren, Schachbrett, vonWeißGeschlageneSpielfiguren, vonGrünGeschlageneSpielfiguren);

        // -------------------------------------------------------------------------------------------------------------
    }

    public static void Ausgabe(String[][] Schachbrett, Spielfigur[] vonWeißGeschlageneSpielfiguren, Spielfigur[] vonGrünGeschlageneSpielfiguren) {

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

            // Ausgabe von den von grün geschlagenen Figuren
            if (i == 2) {
                System.out.print("\tVon Grün geschlagene Figuren: ");
                for (int j = 0; j < vonGrünGeschlageneSpielfiguren.length; j++) {
                    if (vonGrünGeschlageneSpielfiguren[j] == null) {
                        break;
                    }
                    System.out.print(vonGrünGeschlageneSpielfiguren[j].getSymbol() + " ");
                }
            }

            // Ausgabe von den von weiß geschlagenen Figuren
            if (i == 5) {
                System.out.print("\tVon Weiß geschlagene Figuren: ");
                for (int j = 0; j < vonWeißGeschlageneSpielfiguren.length; j++) {
                    if (vonWeißGeschlageneSpielfiguren[j] == null) {
                        break;
                    }
                    System.out.print(vonWeißGeschlageneSpielfiguren[j].getSymbol() + " ");
                }
            }

            System.out.println();
        }

        // Buchstaben ausgeben
        for (int i = 0; i < buchstaben.length; i++) {
            System.out.print("\t" + buchstaben[i]);
        }

    }

    public static void moveFigures(Spielfigur[] Spielfiguren, String[][] Schachbrett, Spielfigur[] vonWeißGeschlageneSpielfiguren, Spielfigur[] vonGrünGeschlageneSpielfiguren) {

        int vonWeißGeschlageneSpielfigurenCounter = 0;
        int vonGrünGeschlagendeSpielfigurenCounter = 0;

        int vorübergehenderFarbenCounter = 0;
        boolean colorError = false;
        System.out.println();
        System.out.println("Weiß beginnt!");

        while (true) {

            boolean isInSpielfiguren = false;

            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Gib die Position der Figur ein, die du bewegen möchtest: ");
            String eingabeUrsprünglichePosition = sc.next();
            if (eingabeUrsprünglichePosition.equals("c")) {
                System.out.println("Die Partie ist beendet!");
                System.out.println("Sollen die Spielzüge in der Datei gespeichert bleiben? (Y = 0 / N = 1) ");
                int speichereSpielzüge = sc.nextInt();
                if (speichereSpielzüge == 0)
                    System.out.println("Die Spielzüge wurden gespeichert und können im File angesehen werden!");
                else {
                    spielzügeDateiLöschen();
                }

                break;
            }
            String convertedEingabeUrsprünglichePosition = converter(eingabeUrsprünglichePosition);
            String[] convertedEingabeUrsprünglichePositionArray = convertedEingabeUrsprünglichePosition.split(" ");
            if (Schachbrett[Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0])][Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1])].equals(" ")) {
                System.out.println("An dieser Position befindet sich keine Figur!");
                continue;
            }

            for (int fff = 0; fff < Spielfiguren.length; fff++) {
                if (Spielfiguren[fff].getID().equals(eingabeUrsprünglichePosition)) {
                    isInSpielfiguren = true;
                }
            }
            if (!isInSpielfiguren) {
                System.out.println("Das ist keine Position auf dem Schachbrett!");
                continue;
            }

            for (int u = 0; u < Spielfiguren.length; u++) {
                if (Spielfiguren[u].getID().equals(eingabeUrsprünglichePosition)) {
                    if (vorübergehenderFarbenCounter == 0 && Spielfiguren[u].getFarbe().equals("Weiß")) {
                        vorübergehenderFarbenCounter++;
                    } else if (vorübergehenderFarbenCounter % 2 == 0 && Spielfiguren[u].getFarbe().equals("Weiß")) {
                        vorübergehenderFarbenCounter++;
                    } else if (vorübergehenderFarbenCounter % 2 != 0 && Spielfiguren[u].getFarbe().equals("Grün")) {
                        vorübergehenderFarbenCounter++;
                    } else {
                        if (Spielfiguren[u].getFarbe().equals("Weiß")) {
                            System.out.println();
                            System.out.println("Grün ist jetzt am Zug!");
                            colorError = true;
                        }
                        if (Spielfiguren[u].getFarbe().equals("Grün")) {
                            System.out.println();
                            System.out.println("Weiß ist jetzt am Zug!");
                            colorError = true;
                        }
                    }
                }
            }
            if (colorError) {
                colorError = false;
                continue;
            }


            boolean checkVariable = showPossibleMoves(Schachbrett, eingabeUrsprünglichePosition, Spielfiguren);

            if (checkVariable) {
                Ausgabe(Schachbrett, vonWeißGeschlageneSpielfiguren, vonGrünGeschlageneSpielfiguren);
            }

            for (int i = 0; i < Schachbrett.length; i++) {
                for (int j = 0; j < Schachbrett[i].length; j++) {
                    if (Schachbrett[i][j] == null) continue;
                    if (Schachbrett[i][j].equals("*") || Schachbrett[i][j].equals("\u001B[32m*\u001B[0m")) {
                        Schachbrett[i][j] = " ";
                    }
                }

            }


            System.out.println();
            System.out.println("Wohin möchtest du sie bewegen?: ");
            String eingabeZielPosition = sc.next();

            if (!checkIfPositionIsValid(eingabeZielPosition)){
                System.out.println("Das ist keine Position auf dem Schachbrett!");
                vorübergehenderFarbenCounter--;
                continue;
            }

            if (!checkIfFigurIsInTheWay(Schachbrett, Spielfiguren, eingabeUrsprünglichePosition, eingabeZielPosition)) {
                vorübergehenderFarbenCounter--;
                continue;
            }


            String vergleichsObjekt = converter(eingabeZielPosition);
            String[] vergleichsObjektArray = vergleichsObjekt.split(" ");

            speichereSpielzügeInDatei(eingabeUrsprünglichePosition, eingabeZielPosition);

            if (Schachbrett[Integer.parseInt(vergleichsObjektArray[0])][Integer.parseInt(vergleichsObjektArray[1])].equals(" ")) {
                for (int i = 0; i < Spielfiguren.length; i++) {
                    if (Spielfiguren[i].getID().equals(eingabeUrsprünglichePosition)) {

                        if (tryIfMoveIsPossibleWhenGoalIsEmpty(Spielfiguren[i], eingabeUrsprünglichePosition, eingabeZielPosition)) {

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

                            Spielfiguren[i].setID(eingabeZielPosition);
                            int zuganzahl = Spielfiguren[i].getZuganzahl();
                            zuganzahl++;
                            Spielfiguren[i].setZuganzahl(zuganzahl);
                        } else {
                            vorübergehenderFarbenCounter--;
                        }
                    }
                }

            } else {
                for (int i = 0; i < Spielfiguren.length; i++) {
                    if (Spielfiguren[i].getID().equals(eingabeUrsprünglichePosition)) {
                        for (int x = 0; x < Spielfiguren.length; x++) {
                            if (Spielfiguren[x].getID().equals(eingabeZielPosition)) {
                                if (Spielfiguren[i].getFarbe().equals(Spielfiguren[x].getFarbe())) {
                                    System.out.println("Sie können keine eigene Figur schlagen!");
                                    System.out.println();
                                    vorübergehenderFarbenCounter--;
                                    break;
                                } else {
                                    if (tryIfMoveIsPossibleWheGoalIsNotEmpty(Spielfiguren[i], eingabeUrsprünglichePosition, eingabeZielPosition)) {

                                        System.out.println(Spielfiguren[i].getName() + " " + Spielfiguren[i].getFarbe() + " hat " + Spielfiguren[x].getName() + " " + Spielfiguren[x].getFarbe() + " an der Stelle " + Spielfiguren[x].getID() + " geschlagen!");
                                        System.out.println();
                                        Spielfiguren[x].setID("GESCHLAGENE FIGUR");
                                        if (Spielfiguren[x].getFarbe().equals("Weiß")) {
                                            vonGrünGeschlageneSpielfiguren[vonGrünGeschlagendeSpielfigurenCounter] = Spielfiguren[x];
                                            vonGrünGeschlagendeSpielfigurenCounter++;
                                        } else if (Spielfiguren[x].getFarbe().equals("Grün")) {
                                            vonWeißGeschlageneSpielfiguren[vonWeißGeschlageneSpielfigurenCounter] = Spielfiguren[x];
                                            vonWeißGeschlageneSpielfigurenCounter++;
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

                                        Spielfiguren[i].setID(eingabeZielPosition);
                                        int zuganzahl = Spielfiguren[i].getZuganzahl();
                                        zuganzahl++;
                                        Spielfiguren[i].setZuganzahl(zuganzahl);
                                        break;
                                    } else {
                                        vorübergehenderFarbenCounter--;

                                    }
                                }
                            }

                        }

                    }

                }

            }
            Ausgabe(Schachbrett, vonWeißGeschlageneSpielfiguren, vonGrünGeschlageneSpielfiguren);
        }

    }

    public static boolean tryIfMoveIsPossibleWheGoalIsNotEmpty(Spielfigur spielfigur, String eingabeUrsprünglichePosition, String eingabeZielPosition) {
        if (spielfigur.getName().equals("Bauer") && spielfigur.getFarbe().equals("Weiß")) {
            char[] buchstabenArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

            char spalteDerUrsprünglichenPosition = eingabeUrsprünglichePosition.charAt(0);
            char spalteDerZielPosition = eingabeZielPosition.charAt(0);

            int zeileDerUrsprünglichenPosition = Character.getNumericValue(eingabeUrsprünglichePosition.charAt(1));
            int zeileDerZielPosition = Character.getNumericValue(eingabeZielPosition.charAt(1));

            if (spalteDerUrsprünglichenPosition + 1 == spalteDerZielPosition && zeileDerUrsprünglichenPosition + 1 == zeileDerZielPosition) {
                return true;
            } else if (spalteDerUrsprünglichenPosition - 1 == spalteDerZielPosition && zeileDerUrsprünglichenPosition + 1 == zeileDerZielPosition) {
                return true;
            } else {
                System.out.println("Bauer " + spielfigur.getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                return false;
            }

        }

        if (spielfigur.getName().equals("Bauer") && spielfigur.getFarbe().equals("Grün")) {
            char[] buchstabenArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

            char spalteDerUrsprünglichenPosition = eingabeUrsprünglichePosition.charAt(0);
            char spalteDerZielPosition = eingabeZielPosition.charAt(0);

            int zeileDerUrsprünglichenPosition = Character.getNumericValue(eingabeUrsprünglichePosition.charAt(1));
            int zeileDerZielPosition = Character.getNumericValue(eingabeZielPosition.charAt(1));

            if (spalteDerUrsprünglichenPosition + 1 == spalteDerZielPosition && zeileDerUrsprünglichenPosition - 1 == zeileDerZielPosition) {
                return true;
            } else if (spalteDerUrsprünglichenPosition - 1 == spalteDerZielPosition && zeileDerUrsprünglichenPosition - 1 == zeileDerZielPosition) {
                return true;
            } else {
                System.out.println("Bauer " + spielfigur.getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                return false;
            }
        }
        return true;
    }

    public static boolean tryIfMoveIsPossibleWhenGoalIsEmpty(Spielfigur spielfigur, String eingabeUrsprünglichePosition, String eingabeZielPosition) {
        if (spielfigur.getZuganzahl() > 0) {
            if (spielfigur.getName().equals("Bauer") && spielfigur.getFarbe().equals("Weiß")) {
                int g = Character.getNumericValue(eingabeZielPosition.charAt(1));
                int h = Character.getNumericValue(eingabeUrsprünglichePosition.charAt(1)) + 1;

                if (eingabeUrsprünglichePosition.charAt(0) != eingabeZielPosition.charAt(0) || h != g) {
                    System.out.println("Bauer Weiß an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                    return false;
                }

            }

            if (spielfigur.getName().equals("Bauer") && spielfigur.getFarbe().equals("Grün")) {
                int g = Character.getNumericValue(eingabeZielPosition.charAt(1));
                int h = Character.getNumericValue(eingabeUrsprünglichePosition.charAt(1)) - 1;

                if (eingabeUrsprünglichePosition.charAt(0) != eingabeZielPosition.charAt(0) || h != g) {
                    System.out.println("Bauer Grün an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                    return false;
                }

            }
        }
        if (spielfigur.getZuganzahl() == 0) {
            if (spielfigur.getName().equals("Bauer") && spielfigur.getFarbe().equals("Weiß")) {
                int g = Character.getNumericValue(eingabeZielPosition.charAt(1));
                int h = Character.getNumericValue(eingabeUrsprünglichePosition.charAt(1)) + 1;
                int k = Character.getNumericValue(eingabeUrsprünglichePosition.charAt(1)) + 2;

                if (eingabeUrsprünglichePosition.charAt(0) != eingabeZielPosition.charAt(0)) {
                    if (h != g || k != g) {
                        System.out.println("Bauer Weiß an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                        return false;
                    }
                }
            }


            if (spielfigur.getName().equals("Bauer") && spielfigur.getFarbe().equals("Grün")) {
                int g = Character.getNumericValue(eingabeZielPosition.charAt(1));
                int h = Character.getNumericValue(eingabeUrsprünglichePosition.charAt(1)) - 1;
                int k = Character.getNumericValue(eingabeUrsprünglichePosition.charAt(1)) - 2;

                if (eingabeUrsprünglichePosition.charAt(0) != eingabeZielPosition.charAt(0)) {
                    if (h != g || k != g) {
                        System.out.println("Bauer Grün an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                        return false;
                    }
                }
            }

        }


        if (spielfigur.getName().equals("Turm")) { // Für Turm Farbenunabhängig, da ja in jeder Spalte / Zeile nach oben
            // oder nach unten

            String spalteZiel = Integer.toString(eingabeZielPosition.charAt(0));
            int zeileZiel = eingabeZielPosition.charAt(1);

            String spalteUrsprung = Integer.toString(eingabeUrsprünglichePosition.charAt(0));
            int zeileUrsprung = eingabeUrsprünglichePosition.charAt(1);

            if (!spalteZiel.equals(spalteUrsprung) && zeileZiel != zeileUrsprung) {
                System.out.println("Turm " + spielfigur.getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                return false;
            }

        }

        if (spielfigur.getName().equals("Springer")) { // Auch hier keine weitere implementierung für Grün erforderlich
            int spalteZiel = eingabeZielPosition.charAt(0) - 'A';
            int zeileZiel = eingabeZielPosition.charAt(1) - '1';
            int spalteUrsprung = eingabeUrsprünglichePosition.charAt(0) - 'A';
            int zeileUrsprung = eingabeUrsprünglichePosition.charAt(1) - '1';
            int deltaX = Math.abs(spalteZiel - spalteUrsprung);
            int deltaY = Math.abs(zeileZiel - zeileUrsprung);
            if ((deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1)) return true;
            else {
                System.out.println("Springer " + spielfigur.getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                return false;
            }

        }

        if (spielfigur.getName().equals("Läufer")) { // Auch hier keine weitere implementierung für Grün erforderlich
            int spalteZiel = eingabeZielPosition.charAt(0) - 'A';
            int zeileZiel = eingabeZielPosition.charAt(1) - '1';
            int spalteUrsprung = eingabeUrsprünglichePosition.charAt(0) - 'A';
            int zeileUrsprung = eingabeUrsprünglichePosition.charAt(1) - '1';

            int deltaX = Math.abs(spalteZiel - spalteUrsprung);
            int deltaY = Math.abs(zeileZiel - zeileUrsprung);

            if (deltaX == deltaY) {
                return true;
            } else {
                System.out.println("Läufer " + spielfigur.getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                return false;
            }
        }

        if (spielfigur.getName().equals("King")) { // Auch hier keine weitere implementierung für Grün erforderlich
            int spalteZiel = eingabeZielPosition.charAt(0) - 'A';
            int zeileZiel = eingabeZielPosition.charAt(1) - '1';
            int spalteUrsprung = eingabeUrsprünglichePosition.charAt(0) - 'A';
            int zeileUrsprung = eingabeUrsprünglichePosition.charAt(1) - '1';
            int deltaX = Math.abs(spalteZiel - spalteUrsprung);
            int deltaY = Math.abs(zeileZiel - zeileUrsprung);

            // Überprüfen, ob der Zug horizontal, vertikal oder diagonal ist und nur um eine
            // Position geht
            if (deltaX <= 1 && deltaY <= 1) {
                return true;
            } else {
                System.out.println("King " + spielfigur.getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                return false;
            }
        }

        if (spielfigur.getName().equals("Queen")) { // Auch hier keine weitere implementierung für Grün erforderlich
            int spalteZiel = eingabeZielPosition.charAt(0) - 'A';
            int zeileZiel = eingabeZielPosition.charAt(1) - '1';
            int spalteUrsprung = eingabeUrsprünglichePosition.charAt(0) - 'A';
            int zeileUrsprung = eingabeUrsprünglichePosition.charAt(1) - '1';
            int deltaX = Math.abs(spalteZiel - spalteUrsprung);
            int deltaY = Math.abs(zeileZiel - zeileUrsprung);

            // Überprüfen, ob der Zug horizontal, vertikal oder diagonal ist und ob deltaX
            // und deltaY gleich sind, was auf eine diagonale Bewegung hinweist
            if (deltaX == 0 || deltaY == 0 || deltaX == deltaY) {
                return true;
            } else {
                System.out.println("Queen " + spielfigur.getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                return false;
            }
        }

        return true;
    }

    public static void speichereSpielzügeInDatei(String ursprung, String ziel) {
        try {
            File datei = new File("schachspielzuege.txt");
            FileWriter writer = new FileWriter(datei, true);

            String zug = ursprung + " -> " + ziel;
            writer.write(zug + "\n");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void spielzügeDateiLöschen() {
        try {
            File datei = new File("schachspielzuege.txt");
            PrintWriter writer = new PrintWriter(datei);
            writer.close();
            System.out.println("Inhalt der Spielzugdatei wurde gelöscht.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkIfFigurIsInTheWay(String[][] Schachbrett, Spielfigur[] Spielfiguren, String eingabeUrsprünglichePosition, String eingabeZielPosition) {
        String convertedEingabeUrsprünglichePosition = converter(eingabeUrsprünglichePosition);
        String[] convertedEingabeUrsprünglichePositionArray = convertedEingabeUrsprünglichePosition.split(" ");
        String convertedEingabeZielPosition = converter(eingabeZielPosition);
        String[] convertedEingabeZielPositionArray = convertedEingabeZielPosition.split(" ");

        for (int i = 0; i < Spielfiguren.length; i++) {
            if (eingabeUrsprünglichePosition.equals(Spielfiguren[i].getID())) {

                int rowUrsprünglichePosition = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                int columnUrsprünglichePosition = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);
                int rowZielPosition = Integer.parseInt(convertedEingabeZielPositionArray[0]);
                int columnZielPosition = Integer.parseInt(convertedEingabeZielPositionArray[1]);

                switch (Spielfiguren[i].getName()) {
                    case "Bauer":
                        return true;
                    case "Springer":
                        return true;
                    case "King":
                        return true;
                    case "Turm":
                        if (Integer.parseInt(convertedEingabeZielPositionArray[1]) == Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1])) {
                            if (Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) < Integer.parseInt(convertedEingabeZielPositionArray[0])) {
                                for (int j = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) + 1; j < Integer.parseInt(convertedEingabeZielPositionArray[0]); j++) {
                                    if (!Schachbrett[j][Integer.parseInt(convertedEingabeZielPositionArray[1])].equals(" ")) {
                                        System.out.println("Turm " + Spielfiguren[i].getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                                        return false;
                                    }
                                }
                            }

                            if (Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) > Integer.parseInt(convertedEingabeZielPositionArray[0])) {
                                for (int j = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) - 1; j > Integer.parseInt(convertedEingabeZielPositionArray[0]); j--) {
                                    if (!Schachbrett[j][Integer.parseInt(convertedEingabeZielPositionArray[1])].equals(" ")) {
                                        System.out.println("Turm " + Spielfiguren[i].getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                                        return false;
                                    }
                                }
                            }
                        }

                        // Case Horizontale Bewegung:

                        if (Integer.parseInt(convertedEingabeZielPositionArray[0]) == Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0])) {
                            if (Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]) < Integer.parseInt(convertedEingabeZielPositionArray[1])) {
                                for (int j = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]) + 1; j < Integer.parseInt(convertedEingabeZielPositionArray[1]); j++) {
                                    if (!Schachbrett[Integer.parseInt(convertedEingabeZielPositionArray[0])][j].equals(" ")) {
                                        System.out.println("Turm " + Spielfiguren[i].getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                                        return false;
                                    }
                                }
                            }

                            if (Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]) > Integer.parseInt(convertedEingabeZielPositionArray[1])) {
                                for (int j = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]) - 1; j > Integer.parseInt(convertedEingabeZielPositionArray[1]); j--) {
                                    if (!Schachbrett[Integer.parseInt(convertedEingabeZielPositionArray[0])][j].equals(" ")) {
                                        System.out.println("Turm " + Spielfiguren[i].getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                                        return false;
                                    }
                                }
                            }
                        }
                        return true;
                    case "Läufer":

                        // Wenn Bewegung nach links oben:
                        if (Integer.parseInt(convertedEingabeZielPositionArray[0]) < Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) && Integer.parseInt(convertedEingabeZielPositionArray[1]) < Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1])) {
                            while (rowUrsprünglichePosition > rowZielPosition + 1 && columnUrsprünglichePosition > columnZielPosition + 1) {
                                rowUrsprünglichePosition -= 1;
                                columnUrsprünglichePosition -= 1;
                                if (!Schachbrett[rowUrsprünglichePosition][columnUrsprünglichePosition].equals(" ")) {
                                    System.out.println("Läufer " + Spielfiguren[i].getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                                    return false;
                                }
                            }
                        }

                        // Wenn Bewegung nach rechts oben:
                        if (Integer.parseInt(convertedEingabeZielPositionArray[0]) < Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) && Integer.parseInt(convertedEingabeZielPositionArray[1]) > Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1])) {
                            while (rowUrsprünglichePosition > rowZielPosition + 1 && columnUrsprünglichePosition < columnZielPosition - 1) {
                                rowUrsprünglichePosition -= 1;
                                columnUrsprünglichePosition += 1;
                                if (!Schachbrett[rowUrsprünglichePosition][columnUrsprünglichePosition].equals(" ")) {
                                    System.out.println("Läufer " + Spielfiguren[i].getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                                    return false;
                                }
                            }
                        }

                        // Wenn Bewegung nach rechts unten:
                        if (Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) < Integer.parseInt(convertedEingabeZielPositionArray[0]) && Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]) < Integer.parseInt(convertedEingabeZielPositionArray[1])) {
                            while (rowUrsprünglichePosition < rowZielPosition - 1 && columnUrsprünglichePosition < columnZielPosition - 1) {
                                rowUrsprünglichePosition += 1;
                                columnUrsprünglichePosition += 1;
                                if (!Schachbrett[rowUrsprünglichePosition][columnUrsprünglichePosition].equals(" ")) {
                                    System.out.println("Läufer " + Spielfiguren[i].getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                                    return false;
                                }
                            }
                        }

                        // Wenn Bewegung nach links unten:
                        if (Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) < Integer.parseInt(convertedEingabeZielPositionArray[0]) && Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]) > Integer.parseInt(convertedEingabeZielPositionArray[1])) {
                            while (rowUrsprünglichePosition < rowZielPosition - 1 && columnUrsprünglichePosition > columnZielPosition + 1) {
                                rowUrsprünglichePosition += 1;
                                columnUrsprünglichePosition -= 1;
                                if (!Schachbrett[rowUrsprünglichePosition][columnUrsprünglichePosition].equals(" ")) {
                                    System.out.println("Läufer " + Spielfiguren[i].getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                                    return false;
                                }
                            }
                        }
                        return true;
                    case "Queen":
                        if (Integer.parseInt(convertedEingabeZielPositionArray[1]) == Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1])) {
                            if (Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) < Integer.parseInt(convertedEingabeZielPositionArray[0])) {
                                for (int j = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) + 1; j < Integer.parseInt(convertedEingabeZielPositionArray[0]); j++) {
                                    if (!Schachbrett[j][Integer.parseInt(convertedEingabeZielPositionArray[1])].equals(" ")) {
                                        System.out.println("Queen " + Spielfiguren[i].getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                                        return false;
                                    }
                                }
                            }

                            if (Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) > Integer.parseInt(convertedEingabeZielPositionArray[0])) {
                                for (int j = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) - 1; j > Integer.parseInt(convertedEingabeZielPositionArray[0]); j--) {
                                    if (!Schachbrett[j][Integer.parseInt(convertedEingabeZielPositionArray[1])].equals(" ")) {
                                        System.out.println("Queen " + Spielfiguren[i].getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                                        return false;
                                    }
                                }
                            }
                        }

                        // Case Horizontale Bewegung:

                        if (Integer.parseInt(convertedEingabeZielPositionArray[0]) == Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0])) {
                            if (Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]) < Integer.parseInt(convertedEingabeZielPositionArray[1])) {
                                for (int j = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]) + 1; j < Integer.parseInt(convertedEingabeZielPositionArray[1]); j++) {
                                    if (!Schachbrett[Integer.parseInt(convertedEingabeZielPositionArray[0])][j].equals(" ")) {
                                        System.out.println("Queen " + Spielfiguren[i].getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                                        return false;
                                    }
                                }
                            }

                            if (Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]) > Integer.parseInt(convertedEingabeZielPositionArray[1])) {
                                for (int j = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]) - 1; j > Integer.parseInt(convertedEingabeZielPositionArray[1]); j--) {
                                    if (!Schachbrett[Integer.parseInt(convertedEingabeZielPositionArray[0])][j].equals(" ")) {
                                        System.out.println("Queen " + Spielfiguren[i].getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                                        return false;
                                    }
                                }
                            }
                        }
                        rowUrsprünglichePosition = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                        columnUrsprünglichePosition = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);
                        rowZielPosition = Integer.parseInt(convertedEingabeZielPositionArray[0]);
                        columnZielPosition = Integer.parseInt(convertedEingabeZielPositionArray[1]);

                        // Wenn Bewegung nach links oben:
                        if (Integer.parseInt(convertedEingabeZielPositionArray[0]) < Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) && Integer.parseInt(convertedEingabeZielPositionArray[1]) < Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1])) {
                            while (rowUrsprünglichePosition > rowZielPosition + 1 && columnUrsprünglichePosition > columnZielPosition + 1) {
                                rowUrsprünglichePosition -= 1;
                                columnUrsprünglichePosition -= 1;
                                if (!Schachbrett[rowUrsprünglichePosition][columnUrsprünglichePosition].equals(" ")) {
                                    System.out.println("Queen " + Spielfiguren[i].getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                                    return false;
                                }
                            }
                        }

                        // Wenn Bewegung nach rechts oben:
                        if (Integer.parseInt(convertedEingabeZielPositionArray[0]) < Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) && Integer.parseInt(convertedEingabeZielPositionArray[1]) > Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1])) {
                            while (rowUrsprünglichePosition > rowZielPosition + 1 && columnUrsprünglichePosition < columnZielPosition - 1) {
                                rowUrsprünglichePosition -= 1;
                                columnUrsprünglichePosition += 1;
                                if (!Schachbrett[rowUrsprünglichePosition][columnUrsprünglichePosition].equals(" ")) {
                                    System.out.println("Queen " + Spielfiguren[i].getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                                    return false;
                                }
                            }
                        }

                        // Wenn Bewegung nach rechts unten:
                        if (Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) < Integer.parseInt(convertedEingabeZielPositionArray[0]) && Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]) < Integer.parseInt(convertedEingabeZielPositionArray[1])) {
                            while (rowUrsprünglichePosition < rowZielPosition - 1 && columnUrsprünglichePosition < columnZielPosition - 1) {
                                rowUrsprünglichePosition += 1;
                                columnUrsprünglichePosition += 1;
                                if (!Schachbrett[rowUrsprünglichePosition][columnUrsprünglichePosition].equals(" ")) {
                                    System.out.println("Queen " + Spielfiguren[i].getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                                    return false;
                                }
                            }
                        }

                        // Wenn Bewegung nach links unten:
                        if (Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) < Integer.parseInt(convertedEingabeZielPositionArray[0]) && Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]) > Integer.parseInt(convertedEingabeZielPositionArray[1])) {
                            while (rowUrsprünglichePosition < rowZielPosition - 1 && columnUrsprünglichePosition > columnZielPosition + 1) {
                                rowUrsprünglichePosition += 1;
                                columnUrsprünglichePosition -= 1;
                                if (!Schachbrett[rowUrsprünglichePosition][columnUrsprünglichePosition].equals(" ")) {
                                    System.out.println("Queen " + Spielfiguren[i].getFarbe() + " an der Stelle " + eingabeUrsprünglichePosition + " ist nicht befugt, an die Stelle " + eingabeZielPosition + " zu fahren!");
                                    return false;
                                }
                            }
                        }
                        return true;
                }
            }
        }
        return true;
    }

    public static boolean showPossibleMoves(String[][] Schachbrett, String eingabeUrsprünglichePosition, Spielfigur[] Spielfiguren) {
        String convertedEingabeUrsprünglichePosition = converter(eingabeUrsprünglichePosition);
        String[] convertedEingabeUrsprünglichePositionArray = convertedEingabeUrsprünglichePosition.split(" ");


        for (int i = 0; i < Spielfiguren.length; i++) {
            if (Spielfiguren[i].getID().equals(eingabeUrsprünglichePosition)) {

                // Wenn die Spielfigur ein Bauer ist:

                if (Spielfiguren[i].getName().equals("Bauer") && Spielfiguren[i].getFarbe().equals("Weiß") && Spielfiguren[i].getZuganzahl() != 0) {
                    if (Schachbrett[Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) - 1][Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1])].equals(" ")) {
                        Schachbrett[Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) - 1][Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1])] = "*";
                        return true;
                    }
                }

                if (Spielfiguren[i].getName().equals("Bauer") && Spielfiguren[i].getFarbe().equals("Weiß") && Spielfiguren[i].getZuganzahl() == 0) {
                    if (Schachbrett[Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) - 1][Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1])].equals(" ") && Schachbrett[Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) - 2][Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1])].equals(" ")) {
                        Schachbrett[Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) - 1][Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1])] = "*";
                        Schachbrett[Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) - 2][Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1])] = "*";
                        return true;
                    }
                }


                if (Spielfiguren[i].getName().equals("Bauer") && Spielfiguren[i].getFarbe().equals("Grün") && Spielfiguren[i].getZuganzahl() != 0) {
                    if (Schachbrett[Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) + 1][Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1])].equals(" ")) {
                        Schachbrett[Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) + 1][Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1])] = "\u001B[32m*\u001B[0m";
                        return true;
                    }
                }

                if (Spielfiguren[i].getName().equals("Bauer") && Spielfiguren[i].getFarbe().equals("Grün") && Spielfiguren[i].getZuganzahl() == 0) {
                    if (Schachbrett[Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) + 1][Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1])].equals(" ") && Schachbrett[Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) + 2][Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1])].equals(" ")) {
                        Schachbrett[Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) + 1][Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1])] = "\u001B[32m*\u001B[0m";
                        Schachbrett[Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]) + 2][Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1])] = "\u001B[32m*\u001B[0m";
                        return true;
                    }
                }

                // Wenn die Spielfigur ein Turm ist:


                if (Spielfiguren[i].getName().equals("Turm") && Spielfiguren[i].getFarbe().equals("Weiß")) {

                    int rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    int cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);


                    while (true) {
                        try {
                            rows--;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "*";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    while (true) {
                        try {
                            rows++;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "*";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }

                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    while (true) {
                        try {
                            cols++;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "*";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    while (true) {
                        try {
                            cols--;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "*";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }
                    return true;

                }


                if (Spielfiguren[i].getName().equals("Turm") && Spielfiguren[i].getFarbe().equals("Grün")) {

                    int rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    int cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);


                    while (true) {
                        try {
                            rows--;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "\u001B[32m*\u001B[0m";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    while (true) {
                        try {
                            rows++;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "\u001B[32m*\u001B[0m";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }

                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    while (true) {
                        try {
                            cols++;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "\u001B[32m*\u001B[0m";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    while (true) {
                        try {
                            cols--;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "\u001B[32m*\u001B[0m";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }
                    return true;
                }

                // Wenn die Spielfigur ein Springer ist:

                if (Spielfiguren[i].getName().equals("Springer") && Spielfiguren[i].getFarbe().equals("Weiß")) {
                    int rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    int cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    int zielRow = rows - 2;
                    int zielCol = cols + 1;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "*";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }

                    zielRow = rows - 1;
                    zielCol = cols + 2;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "*";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }


                    zielRow = rows + 1;
                    zielCol = cols + 2;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "*";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }

                    zielRow = rows + 2;
                    zielCol = cols + 1;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "*";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }


                    zielRow = rows + 2;
                    zielCol = cols - 1;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "*";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }

                    zielRow = rows + 1;
                    zielCol = cols - 2;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "*";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }


                    zielRow = rows - 1;
                    zielCol = cols - 2;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "*";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }

                    zielRow = rows - 2;
                    zielCol = cols - 1;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "*";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }
                    return true;
                }


                if (Spielfiguren[i].getName().equals("Springer") && Spielfiguren[i].getFarbe().equals("Grün")) {
                    int rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    int cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    int zielRow = rows - 2;
                    int zielCol = cols + 1;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "\u001B[32m*\u001B[0m";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }

                    zielRow = rows - 1;
                    zielCol = cols + 2;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "\u001B[32m*\u001B[0m";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }


                    zielRow = rows + 1;
                    zielCol = cols + 2;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "\u001B[32m*\u001B[0m";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }

                    zielRow = rows + 2;
                    zielCol = cols + 1;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "\u001B[32m*\u001B[0m";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }


                    zielRow = rows + 2;
                    zielCol = cols - 1;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "\u001B[32m*\u001B[0m";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }

                    zielRow = rows + 1;
                    zielCol = cols - 2;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "\u001B[32m*\u001B[0m";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }


                    zielRow = rows - 1;
                    zielCol = cols - 2;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "\u001B[32m*\u001B[0m";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }

                    zielRow = rows - 2;
                    zielCol = cols - 1;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "\u001B[32m*\u001B[0m";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }
                    return true;
                }

                // Wenn die Spielfigur ein Läufer ist:

                if (Spielfiguren[i].getName().equals("Läufer") && Spielfiguren[i].getFarbe().equals("Weiß")) {
                    int rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    int cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    while (true) {
                        try {
                            rows--;
                            cols--;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "*";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);
                    while (true) {
                        try {
                            rows--;
                            cols++;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "*";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);
                    while (true) {
                        try {
                            rows++;
                            cols++;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "*";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);
                    while (true) {
                        try {
                            rows++;
                            cols--;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "*";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }
                    return true;
                }


                if (Spielfiguren[i].getName().equals("Läufer") && Spielfiguren[i].getFarbe().equals("Grün")) {
                    int rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    int cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    while (true) {
                        try {
                            rows--;
                            cols--;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "\u001B[32m*\u001B[0m";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    while (true) {
                        try {
                            rows--;
                            cols++;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "\u001B[32m*\u001B[0m";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);
                    while (true) {
                        try {
                            rows++;
                            cols++;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "\u001B[32m*\u001B[0m";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);
                    while (true) {
                        try {
                            rows++;
                            cols--;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "\u001B[32m*\u001B[0m";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }
                    return true;
                }


                // Wenn die Spielfigur eine Queen ist:

                if (Spielfiguren[i].getName().equals("Queen") && Spielfiguren[i].getFarbe().equals("Weiß")) {

                    // Anteil des weißen Turmes:

                    int rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    int cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);


                    while (true) {
                        try {
                            rows--;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "*";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    while (true) {
                        try {
                            rows++;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "*";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }

                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    while (true) {
                        try {
                            cols++;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "*";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    while (true) {
                        try {
                            cols--;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "*";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    // Anteil des weißen Läufers:

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    while (true) {
                        try {
                            rows--;
                            cols--;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "*";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);
                    while (true) {
                        try {
                            rows--;
                            cols++;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "*";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);
                    while (true) {
                        try {
                            rows++;
                            cols++;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "*";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);
                    while (true) {
                        try {
                            rows++;
                            cols--;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "*";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    return true;
                }


                if (Spielfiguren[i].getName().equals("Queen") && Spielfiguren[i].getFarbe().equals("Grün")) {

                    // Anteil des grünen Turmes:

                    int rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    int cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);


                    while (true) {
                        try {
                            rows--;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "\u001B[32m*\u001B[0m";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    while (true) {
                        try {
                            rows++;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "\u001B[32m*\u001B[0m";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }

                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    while (true) {
                        try {
                            cols++;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "\u001B[32m*\u001B[0m";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    while (true) {
                        try {
                            cols--;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "\u001B[32m*\u001B[0m";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    // Anteil des grünen Läufers:

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    while (true) {
                        try {
                            rows--;
                            cols--;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "\u001B[32m*\u001B[0m";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);
                    while (true) {
                        try {
                            rows--;
                            cols++;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "\u001B[32m*\u001B[0m";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);
                    while (true) {
                        try {
                            rows++;
                            cols++;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "\u001B[32m*\u001B[0m";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);
                    while (true) {
                        try {
                            rows++;
                            cols--;
                            if (Schachbrett[rows][cols] == null || !Schachbrett[rows][cols].equals(" ")) {
                                break;
                            }
                            Schachbrett[rows][cols] = "\u001B[32m*\u001B[0m";
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }

                    return true;
                }


                if (Spielfiguren[i].getName().equals("King") && Spielfiguren[i].getFarbe().equals("Weiß")) {
                    int rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    int cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    int zielRow = rows + 1;
                    int zielCol = cols;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "*";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }

                    zielRow = rows;
                    zielCol = cols - 1;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "*";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }


                    zielRow = rows - 1;
                    zielCol = cols;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "*";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }

                    zielRow = rows;
                    zielCol = cols + 1;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "*";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }
                    return true;
                }


                if (Spielfiguren[i].getName().equals("King") && Spielfiguren[i].getFarbe().equals("Grün")) {
                    int rows = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[0]);
                    int cols = Integer.parseInt(convertedEingabeUrsprünglichePositionArray[1]);

                    int zielRow = rows + 1;
                    int zielCol = cols;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "\u001B[32m*\u001B[0m";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }

                    zielRow = rows;
                    zielCol = cols - 1;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "\u001B[32m*\u001B[0m";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }


                    zielRow = rows - 1;
                    zielCol = cols;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "\u001B[32m*\u001B[0m";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }

                    zielRow = rows;
                    zielCol = cols + 1;

                    try {
                        if (Schachbrett[zielRow][zielCol] != null && Schachbrett[zielRow][zielCol].equals(" ")) {
                            Schachbrett[zielRow][zielCol] = "\u001B[32m*\u001B[0m";
                        }
                    } catch (IndexOutOfBoundsException e) {

                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkIfPositionIsValid(String position) {
        switch (position) {
            case "A8":
                return true;
            case "B8":
                return true;
            case "C8":
                return true;
            case "D8":
                return true;
            case "E8":
                return true;
            case "F8":
                return true;
            case "G8":
                return true;
            case "H8":
                return true;
            case "A7":
                return true;
            case "B7":
                return true;
            case "C7":
                return true;
            case "D7":
                return true;
            case "E7":
                return true;
            case "F7":
                return true;
            case "G7":
                return true;
            case "H7":
                return true;
            case "A6":
                return true;
            case "B6":
                return true;
            case "C6":
                return true;
            case "D6":
                return true;
            case "E6":
                return true;
            case "F6":
                return true;
            case "G6":
                return true;
            case "H6":
                return true;
            case "A5":
                return true;
            case "B5":
                return true;
            case "C5":
                return true;
            case "D5":
                return true;
            case "E5":
                return true;
            case "F5":
                return true;
            case "G5":
                return true;
            case "H5":
                return true;
            case "A4":
                return true;
            case "B4":
                return true;
            case "C4":
                return true;
            case "D4":
                return true;
            case "E4":
                return true;
            case "F4":
                return true;
            case "G4":
                return true;
            case "H4":
                return true;
            case "A3":
                return true;
            case "B3":
                return true;
            case "C3":
                return true;
            case "D3":
                return true;
            case "E3":
                return true;
            case "F3":
                return true;
            case "G3":
                return true;
            case "H3":
                return true;
            case "A2":
                return true;
            case "B2":
                return true;
            case "C2":
                return true;
            case "D2":
                return true;
            case "E2":
                return true;
            case "F2":
                return true;
            case "G2":
                return true;
            case "H2":
                return true;
            case "A1":
                return true;
            case "B1":
                return true;
            case "C1":
                return true;
            case "D1":
                return true;
            case "E1":
                return true;
            case "F1":
                return true;
            case "G1":
                return true;
            case "H1":
                return true;
            default:
                return false;
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