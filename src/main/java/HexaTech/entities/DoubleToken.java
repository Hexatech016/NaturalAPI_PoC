package HexaTech.entities;

public class DoubleToken {
    String token;
    String lemma;

    public DoubleToken(String t, String l)
    {
        token=t;
        lemma=l;
    }

    public String getLemma() {
        return lemma;
    }

    public String getToken() {
        return token;
    }

    public String toString(){
        return token+ " " + lemma;
    }
}
