package dal.dao;

import bo.Tests;

public interface TestsDAO extends GenericDAO<Tests,Integer> {

    Tests selectByDescription(String description) throws DaoException;
}
