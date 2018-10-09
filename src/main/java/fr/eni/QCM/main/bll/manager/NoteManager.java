package fr.eni.QCM.main.bll.manager;

import java.util.List;

import fr.eni.tp.prisedenotes.bo.Note;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.exception.FunctionalException;

public interface NoteManager {

    List<Note> findAll() throws ManagerException;
    
    Note findOne(Integer id) throws ManagerException, ElementNotFoundException;
    
    void deleteOne(Integer id) throws ManagerException;
    
    Note saveOne(Note note) throws ManagerException, FunctionalException;
}
