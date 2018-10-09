package main.java.fr.eni.QCM.main.bo;

import java.io.Serializable;

public class Reponses_Tirage implements Serializable {

    private int idReponseTirage;

    public Reponses_Tirage() {
    }

    public Reponses_Tirage(int idReponseTirage) {
        this.idReponseTirage = idReponseTirage;
    }

    public int getIdReponseTirage() {
        return idReponseTirage;
    }

    public void setIdReponseTirage(int idReponseTirage) {
        this.idReponseTirage = idReponseTirage;
    }
}
