package bo;

import java.io.Serializable;

public class Collaborateurs implements Serializable {

    private int idCollaborateur;

    public Collaborateurs() {
    }

    public Collaborateurs(int idCollaborateur) {
        this.idCollaborateur = idCollaborateur;
    }

    public int getIdCollaborateur() {
        return idCollaborateur;
    }

    public void setIdCollaborateur(int idCollaborateur) {
        this.idCollaborateur = idCollaborateur;
    }
}
