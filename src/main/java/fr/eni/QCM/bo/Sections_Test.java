package bo;

import java.io.Serializable;

public class Sections_Test implements Serializable {

    private int idSectionTest;

    private int nbQuestionsATirer;

    public Sections_Test() {
    }

    public Sections_Test(int idSectionTest, int nbQuestionsATirer) {
        this.idSectionTest = idSectionTest;
        this.nbQuestionsATirer = nbQuestionsATirer;
    }

    public int getIdSectionTest() {
        return idSectionTest;
    }

    public void setIdSectionTest(int idSectionTest) {
        this.idSectionTest = idSectionTest;
    }

    public int getNbQuestionsATirer() {
        return nbQuestionsATirer;
    }

    public void setNbQuestionsATirer(int nbQuestionsATirer) {
        this.nbQuestionsATirer = nbQuestionsATirer;
    }
}
