package bo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Epreuves implements Serializable {

    private int idEpreuve;

    private Date dateDebutValidite;

    private Date dateFinValidite;

    private Time tempsEcoule;

    private String etat;

    private float note_obtenue;

    private String niveau_obtenu;

    public Epreuves() {
    }

    public Epreuves(int idEpreuve, Date dateDebutValidite, Date dateFinValidite, Time tempsEcoule, String etat, float note_obtenue, String niveau_obtenu) {
        this.idEpreuve = idEpreuve;
        this.dateDebutValidite = dateDebutValidite;
        this.dateFinValidite = dateFinValidite;
        this.tempsEcoule = tempsEcoule;
        this.etat = etat;
        this.note_obtenue = note_obtenue;
        this.niveau_obtenu = niveau_obtenu;
    }

    public int getIdEpreuve() {
        return idEpreuve;
    }

    public void setIdEpreuve(int idEpreuve) {
        this.idEpreuve = idEpreuve;
    }

    public Date getDateDebutValidite() {
        return dateDebutValidite;
    }

    public void setDateDebutValidite(Date dateDebutValidite) {
        this.dateDebutValidite = dateDebutValidite;
    }

    public Date getDateFinValidite() {
        return dateFinValidite;
    }

    public void setDateFinValidite(Date dateFinValidite) {
        this.dateFinValidite = dateFinValidite;
    }

    public Time getTempsEcoule() {
        return tempsEcoule;
    }

    public void setTempsEcoule(Time tempsEcoule) {
        this.tempsEcoule = tempsEcoule;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public float getNote_obtenue() {
        return note_obtenue;
    }

    public void setNote_obtenue(float note_obtenue) {
        this.note_obtenue = note_obtenue;
    }

    public String getNiveau_obtenu() {
        return niveau_obtenu;
    }

    public void setNiveau_obtenu(String niveau_obtenu) {
        this.niveau_obtenu = niveau_obtenu;
    }
}
