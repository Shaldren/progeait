package fr.eni.QCM.main.dal.factory;

import fr.eni.tp.prisedenotes.dal.dao.NoteDAO;
import fr.eni.tp.prisedenotes.dal.dao.impl.NoteDaoImpl;

public class DAOFactory {

    public static NoteDAO noteDAO() {
        return NoteDaoImpl.getInstance();
    }
}
