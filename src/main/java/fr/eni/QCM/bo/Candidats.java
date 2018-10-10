package bo;

import java.io.Serializable;

public class Candidats implements Serializable {

    private int idCandidat;

    public Candidats() {
    }

    public Candidats(int idCandidat) {
        this.idCandidat = idCandidat;
    }

    public int getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(int idCandidat) {
        this.idCandidat = idCandidat;
    }
}
