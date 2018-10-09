package main.java.fr.eni.QCM.main.bo;

import java.io.File;
import java.io.Serializable;

public class Questions implements Serializable {

    private int idQuestion;

    private String enonce;

    private File media;

    private int points;

    public Questions() {
    }

    public Questions(int idQuestion, String enonce, int points) {
        this.idQuestion = idQuestion;
        this.enonce = enonce;
        this.points = points;
    }

    public Questions(int idQuestion, String enonce, File media, int points) {
        this.idQuestion = idQuestion;
        this.enonce = enonce;
        this.media = media;
        this.points = points;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public File getMedia() {
        return media;
    }

    public void setMedia(File media) {
        this.media = media;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
