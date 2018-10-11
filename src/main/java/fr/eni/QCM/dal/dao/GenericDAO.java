package dal.dao;

import java.util.List;

import dal.exception.DaoException;
import main.java.fr.eni.QCM.dal.exception.DaoException;
/**
 * Generic DAO for the basic current usages of specific DAO.
 * 
 * @author externe
 *
 * @param <T> The Element Type of the DAO.
 * @param <ID> The id type of the Element managed in DAO.
 */
public interface GenericDAO<T, ID> {
    
    /**
     * Insert an Element.
     * 
     * @param element The Element.
     * 
     * @throws DaoException
     */
	T insert(T element) throws DaoException;
	
	/**
	 * Update An Element.
	 * 
	 * @param element The Element.
	 * 
	 * @throws DaoException
	 */
	void update(T element) throws DaoException;	
	
	/**
	 * Delete an Element.
	 * 
	 * @param id The ID of the Element.
	 * 
	 * @throws DaoException
	 */
	void delete(ID id) throws DaoException;
	
	/**
	 * Get Element by its ID.
	 * 
	 * @param id The id of the Element.
	 * 
	 * @return The Selected Element.
	 * 
	 * @throws DaoException
	 */
	T selectById(ID id) throws DaoException;
	
	/**
	 * Get all elements.
	 * 
	 * @return The Elements found.
	 * 
	 * @throws DaoException
	 */
	List<T> selectAll() throws DaoException, DaoException;
	
}
