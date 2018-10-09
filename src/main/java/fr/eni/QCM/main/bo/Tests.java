package main.java.fr.eni.QCM.main.bo;

import java.io.Serializable;
import java.sql.Time;

public class Tests implements Serializable {

    private int idTest;

    private String libelle;

    private String description;

    private Time duree;

    private float seuil_haut;

    private float seuil_bas;

    public Tests() {
    }

    public Tests(int idTest, String libelle, String description, Time duree, float seuil_haut, float seuil_bas) {
        this.idTest = idTest;
        this.libelle = libelle;
        this.description = description;
        this.duree = duree;
        this.seuil_haut = seuil_haut;
        this.seuil_bas = seuil_bas;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getDuree() {
        return duree;
    }

    public void setDuree(Time duree) {
        this.duree = duree;
    }

    public float getSeuil_haut() {
        return seuil_haut;
    }

    public void setSeuil_haut(float seuil_haut) {
        this.seuil_haut = seuil_haut;
    }

    public float getSeuil_bas() {
        return seuil_bas;
    }

    public void setSeuil_bas(float seuil_bas) {
        this.seuil_bas = seuil_bas;
    }
}
