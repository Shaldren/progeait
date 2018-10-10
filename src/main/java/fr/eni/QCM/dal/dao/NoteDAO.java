package dal.dao;


import bo.Note;
import dal.exception.*;
public interface NoteDAO extends GenericDAO<Note, Integer> {
    boolean checkExistenceWithName(String name) throws DaoException;
}
