package main.java.fr.eni.QCM.bll.factory;

import fr.eni.tp.prisedenotes.bll.manager.NoteManager;
import fr.eni.tp.prisedenotes.bll.manager.impl.NoteManagerImpl;

public class ManagerFactory {

    public static NoteManager noteManager() {
        return NoteManagerImpl.getInstance();
    }
}
