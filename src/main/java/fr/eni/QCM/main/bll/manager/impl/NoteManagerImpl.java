package fr.eni.QCM.main.bll.manager.impl;

import java.util.Date;
import java.util.List;

import fr.eni.tp.prisedenotes.bll.manager.NoteManager;
import fr.eni.tp.prisedenotes.bo.Note;
import fr.eni.tp.prisedenotes.dal.dao.NoteDAO;
import fr.eni.tp.prisedenotes.dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.exception.FunctionalException;
import fr.eni.tp.web.common.util.ValidationUtil;

public class NoteManagerImpl implements NoteManager {

    private NoteDAO noteDAO = DAOFactory.noteDAO();
    
    private static NoteManagerImpl instance;
    
    private NoteManagerImpl() {
        
    }
    
    public static NoteManagerImpl getInstance() {
        if(instance == null) {
            instance = new NoteManagerImpl();
        }
        return instance;
    }
    

    
    @Override
    public List<Note> findAll() throws ManagerException {
        
        List<Note> list = null;
        
        try {
            list = noteDAO.selectAll();
            
        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        }
                
        return list;
    }

    @Override
    public Note findOne(Integer id) throws ManagerException, ElementNotFoundException {
        
        Note note = null;
        
        try {
            
            ValidationUtil.checkNotNull(id);
            
            note = noteDAO.selectById(id);
            
            if(note == null) {
                throw new ElementNotFoundException("The note does not exist", null);
            }
            
        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new ManagerException("The id cannot be null", e);
        }
                
        return note;
    }

    @Override
    public void deleteOne(Integer id) throws ManagerException {
        
        try {
            
            ValidationUtil.checkNotNull(id);
            
            noteDAO.delete(id);
            
        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new ManagerException("The id cannot be null", e);
        }
    }

    @Override
    public Note saveOne(Note note) throws ManagerException, FunctionalException {
        
        try {

            ValidationUtil.checkNotNull(note);
            ValidationUtil.checkNotBlank(note.getContent());
            ValidationUtil.checkNotBlank(note.getName());
            
            if(note.getId() != null) {
                noteDAO.update(note);
            } else {
                
                if(noteDAO.checkExistenceWithName(note.getName())) {
                    throw new FunctionalException("This name is already used", null);
                }
                note.setCreatedAt(new Date());
                noteDAO.insert(note);
            }

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);

        } catch (IllegalArgumentException e) {
            throw new ManagerException("The note is not valid", e);
        }
        
        return note;
    }

}
