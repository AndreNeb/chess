public class Spielfigur {
    private int positionsNummerVertikal;
    private int positionsNummerHorizontal;
    private String Farbe;
    private String Symbol;
    private String ID;
    private String Name;

    private int zuganzahl;

    public int getZuganzahl() {
        return zuganzahl;
    }

    public void setZuganzahl(int zuganzahl) {
        this.zuganzahl = zuganzahl;
    }

    public int getPositionsNummerVertikal() {
        return positionsNummerVertikal;
    }

    public void setPositionsNummerVertikal(int positionsNummerVertikal) {
        this.positionsNummerVertikal = positionsNummerVertikal;
    }

    public int getPoeitionsNummerHorizontal() {
        return positionsNummerHorizontal;
    }

    public void setPoeitionsNummerHorizontal(int poeitionsNummerHorizontal) {
        this.positionsNummerHorizontal = poeitionsNummerHorizontal;
    }

    public String getFarbe() {
        return Farbe;
    }

    public void setFarbe(String farbe) {
        Farbe = farbe;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Spielfigur(int positionsNummerVertikal, int positionsNummerHorizontal, String farbe, String symbol, String id, String name, int zuganzahl) {
        this.positionsNummerVertikal = positionsNummerVertikal;
        this.positionsNummerHorizontal = positionsNummerHorizontal;
        Farbe = farbe;
        Symbol = symbol;
        ID = id;
        Name = name;
        this.zuganzahl = zuganzahl;
    }


}
