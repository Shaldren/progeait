package bo;

import java.io.Serializable;

public class Themes implements Serializable {

    private int idTheme;

    private String libelle;

    public Themes() {
    }

    public Themes(int idTheme, String libelle) {
        this.idTheme = idTheme;
        this.libelle = libelle;
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
