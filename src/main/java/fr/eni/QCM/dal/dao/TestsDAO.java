package dal.dao;

import bo.Tests;

public interface TestsDAO extends GenericDAO<Tests,Integer> {

    Tests selectByLibelle(String libelle) throws DaoException;
}
