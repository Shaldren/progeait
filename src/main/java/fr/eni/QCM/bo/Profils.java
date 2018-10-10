package bo;

import java.io.Serializable;

public class Profils implements Serializable {

    private int codeProfil;
    private String libelle;

    public Profils() {
    }

    public Profils(int codeProfil, String libelle) {
        this.codeProfil = codeProfil;
        this.libelle = libelle;
    }

    public int getCodeProfil() {
        return codeProfil;
    }

    public void setCodeProfil(int codeProfil) {
        this.codeProfil = codeProfil;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
