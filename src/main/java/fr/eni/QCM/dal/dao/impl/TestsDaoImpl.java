package dal.dao.impl;

import bo.Tests;
import dal.dao.TestsDAO;
import dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestsDaoImpl implements TestsDAO {
	
	private static final String SELECT_ALL_TESTS_QUERY = "SELECT t.id as test_id, t.libelle as test_libelle, t.description as test_description, t.duree as test_duree, t.seuil_haut as test_seuil_haut, t.seuil_bas as test_seuil_bas FROM test t";
    private static final String SELECT_ONE_TEST_QUERY = "SELECT t.id as test_id, t.libelle as test_libelle, t.description as test_description, t.duree as test_duree, t.seuil_haut as test_seuil_haut, t.seuil_bas as test_seuil_bas FROM test t where t.id = ?";
    private static final String SELECT_ONE_TEST_BY_LIBELLE_QUERY = "SELECT t.id FROM test t where t.description = ?";
    //private static final String INSERT_NOTE_QUERY = "INSERT INTO test(libelle, description, duree, seuil_haut, seuil_bas) VALUES (?, ?, ?, ?, ?)";
    //private static final String DELETE_NOTE_QUERY = "DELETE FROM test WHERE id = ?";
    //private static final String UPDATE_NOTE_QUERY = "UPDATE test SET libelle = ?, description = ?, duree = ?, seuil_haut = ?, seuil_bas = ? WHERE id = ?";
    
    private static TestsDaoImpl instance;
    
    private TestsDaoImpl() {
        
    }
    
    public static TestsDaoImpl getInstance() {
        if(instance == null) {
            instance = new TestsDaoImpl();
        }
        return instance;
    }
    
    @Override
    public Tests insert(Tests element) throws DaoException {
    	return null;
    }

    @Override
    public void update(Tests element) throws DaoException {	
    	//NOPE
    }

    @Override
    public void delete(Integer integer) throws DaoException {
    	// NOPE
    }

    @Override
    public Tests selectById(Integer id) throws DaoException {
    	Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Tests test = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_TEST_QUERY);
            
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                test = resultSetToTest(resultSet);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }
        
        return test;
    }

    @Override
    public List<Tests> selectAll() throws DaoException {
    	Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Tests> list = new ArrayList<>();
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_TESTS_QUERY);

            while (resultSet.next()) {
                list.add(resultSetToTest(resultSet));
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }
        
        return list;
    }
    
    @Override
    public Tests selectByLibelle(String libelle) throws DaoException {
    	Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Tests test = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_TEST_BY_LIBELLE_QUERY);
            
            statement.setString(1, libelle);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                test = resultSetToTest(resultSet);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }
        
        return test;
    }
    
    private Tests resultSetToTest(ResultSet resultSet) throws SQLException {
        
        Tests test = new Tests();
        test.setIdTest(resultSet.getInt("test_id"));
        test.setLibelle(resultSet.getString("test_libelle"));
        test.setDescription(resultSet.getString("test_description"));
        test.setDuree(resultSet.getTime("test_duree"));
        test.setSeuil_haut(resultSet.getFloat("test_seuil_haut"));
        test.setSeuil_bas(resultSet.getFloat("test_seuil_bas"));
        
        return test;
        
    }
}
