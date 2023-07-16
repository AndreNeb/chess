public class Spielfigur {
    private int positionsNummerVertikal;
    private int poeitionsNummerHorizontal;
    private String Farbe;
    private String Symbol;
    private String ID;
    private String Name;

    public int getPositionsNummerVertikal() {
        return positionsNummerVertikal;
    }

    public void setPositionsNummerVertikal(int positionsNummerVertikal) {
        this.positionsNummerVertikal = positionsNummerVertikal;
    }

    public int getPoeitionsNummerHorizontal() {
        return poeitionsNummerHorizontal;
    }

    public void setPoeitionsNummerHorizontal(int poeitionsNummerHorizontal) {
        this.poeitionsNummerHorizontal = poeitionsNummerHorizontal;
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

    public Spielfigur(int positionsNummerVertikal, int positionsNummerHorizontal, String farbe, String symbol, String id, String name) {
        this.positionsNummerVertikal = positionsNummerVertikal;
        this.poeitionsNummerHorizontal = positionsNummerHorizontal;
        Farbe = farbe;
        Symbol = symbol;
        ID = id;
        Name = name;
    }


}
