package fr.eni.QCM.main.dal.dao;

import fr.eni.tp.prisedenotes.bo.Note;
import fr.eni.tp.web.common.dal.dao.GenericDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;

public interface NoteDAO extends GenericDAO<Note, Integer> {
    boolean checkExistenceWithName(String name) throws DaoException;
}
