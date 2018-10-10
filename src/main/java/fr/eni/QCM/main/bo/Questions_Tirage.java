package main.java.fr.eni.QCM.main.bo;

import java.io.Serializable;

public class Questions_Tirage implements Serializable {

    private int idQuestionTirage;

    private boolean estMarquee;

    private int numOrdre;

    public Questions_Tirage() {
    }

    public Questions_Tirage(int idQuestionTirage, boolean estMarquee, int numOrdre) {
        this.idQuestionTirage = idQuestionTirage;
        this.estMarquee = estMarquee;
        this.numOrdre = numOrdre;
    }

    public int getIdQuestionTirage() {
        return idQuestionTirage;
    }

    public void setIdQuestionTirage(int idQuestionTirage) {
        this.idQuestionTirage = idQuestionTirage;
    }

    public boolean isEstMarquee() {
        return estMarquee;
    }

    public void setEstMarquee(boolean estMarquee) {
        this.estMarquee = estMarquee;
    }

    public int getNumOrdre() {
        return numOrdre;
    }

    public void setNumOrdre(int numOrdre) {
        this.numOrdre = numOrdre;
    }
}
