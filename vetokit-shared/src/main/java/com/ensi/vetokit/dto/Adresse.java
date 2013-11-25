package com.ensi.vetokit.dto;

public class Adresse {
    private int numeroOrdre;
    private String ligne1;
    private String ligne2;
    private int codePostale;
    private String ville;

    public Adresse() {
    }

    public int getNumeroOrdre() {
        return numeroOrdre;
    }

    public void setNumeroOrdre(int numeroOrdre) {
        this.numeroOrdre = numeroOrdre;
    }

    public String getLigne1() {
        return ligne1;
    }

    public void setLigne1(String ligne1) {
        this.ligne1 = ligne1;
    }

    public String getLigne2() {
        return ligne2;
    }

    public void setLigne2(String ligne2) {
        this.ligne2 = ligne2;
    }

    public int getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(int codePostale) {
        this.codePostale = codePostale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
