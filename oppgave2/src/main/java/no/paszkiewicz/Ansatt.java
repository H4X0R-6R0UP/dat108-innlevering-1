package no.paszkiewicz;

public class Ansatt {
    private String fornavn;
    private String etternavn;
    private Kjonn kjonn;
    private String stilling;
    private int aarslonn;
    
    public Ansatt(String fornavn, String etternavn, Kjonn kjonn, String stilling, int aarslonn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.kjonn = kjonn;
        this.stilling = stilling;
        this.aarslonn = aarslonn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getFornavn() {
        return this.fornavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getEtternavn() {
        return this.etternavn;
    }

    public void setKjonn(Kjonn kjonn) {
        this.kjonn = kjonn;
    }

    public Kjonn getKjonn() {
        return this.kjonn;
    }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

    public String getStilling() {
        return this.stilling;
    }

    public void setAarslonn(int aarslonn) {
        this.aarslonn = aarslonn;
    }

    public int getAarslonn() {
        return this.aarslonn;
    }

    @Override
    public String toString() {
        return "[Ansatt: " + fornavn + " " + etternavn + ", " + kjonn + ", " + stilling + ", " + aarslonn + "]";
    }
}
