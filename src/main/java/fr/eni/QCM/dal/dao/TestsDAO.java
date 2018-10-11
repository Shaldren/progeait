package dal.dao;

import bo.Tests;
import dal.exception.DaoException;

public interface TestsDAO extends GenericDAO<Tests,Integer> {

    Tests selectByLibelle(String libelle) throws DaoException;
}
