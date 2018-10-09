package main.java.fr.eni.QCM.main.bo;

import java.io.Serializable;

public class Propositions implements Serializable {

    private int idProposition;

    private String enonce;

    private boolean estBonne;

    public Propositions() {
    }

    public Propositions(int idProposition, String enonce, boolean estBonne) {
        this.idProposition = idProposition;
        this.enonce = enonce;
        this.estBonne = estBonne;
    }

    public int getIdProposition() {
        return idProposition;
    }

    public void setIdProposition(int idProposition) {
        this.idProposition = idProposition;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public boolean isEstBonne() {
        return estBonne;
    }

    public void setEstBonne(boolean estBonne) {
        this.estBonne = estBonne;
    }
}
