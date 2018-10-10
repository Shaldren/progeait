package bo;

import java.io.Serializable;

public class Promotions implements Serializable {

    private int codePromo;

    private String libelle;

    public Promotions() {
    }

    public Promotions(int codePromo, String libelle) {
        this.codePromo = codePromo;
        this.libelle = libelle;
    }

    public int getCodePromo() {
        return codePromo;
    }

    public void setCodePromo(int codePromo) {
        this.codePromo = codePromo;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
