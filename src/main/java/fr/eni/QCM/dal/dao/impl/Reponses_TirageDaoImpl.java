package dal.dao.impl;

import bo.Reponses_Tirage;
import dal.dao.Reponses_TirageDAO;
import dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Reponses_TirageDaoImpl implements Reponses_TirageDAO {

    private static final String SELECT_ALL_REPONSE_QUERY = "SELECT r.idReponseTirage as reponse_id FROM reponses_Tirage r";
    private static final String SELECT_ONE_REPONSE_QUERY = "SELECT r.idReponseTirage as reponse_id FROM reponses_Tirage r where r.idReponseTirage = ?";
    private static final String SELECT_ONE_TEST_BY_LIBELLE_QUERY = "SELECT t.id FROM test t where t.description = ?";
    //private static final String INSERT_NOTE_QUERY = "INSERT INTO test(libelle, description, duree, seuil_haut, seuil_bas) VALUES (?, ?, ?, ?, ?)";
    //private static final String DELETE_NOTE_QUERY = "DELETE FROM test WHERE id = ?";
    //private static final String UPDATE_NOTE_QUERY = "UPDATE test SET libelle = ?, description = ?, duree = ?, seuil_haut = ?, seuil_bas = ? WHERE id = ?";

    private static TestsDaoImpl instance;

    @Override
    public Reponses_Tirage insert(Reponses_Tirage element) throws DaoException {
        return null;
    }

    @Override
    public void update(Reponses_Tirage element) throws DaoException {

    }

    @Override
    public void delete(Integer integer) throws DaoException {

    }

    @Override
    public Reponses_Tirage selectById(Integer integer) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Reponses_Tirage reponses = null;

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_REPONSE_QUERY);

            statement.setInt(1, integer);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                reponses = resultSetToReponses(resultSet);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return reponses;
    }

    @Override
    public List<Reponses_Tirage> selectAll() throws DaoException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Reponses_Tirage> list = new ArrayList<>();

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_REPONSE_QUERY);

            while (resultSet.next()) {
                list.add(resultSetToReponses(resultSet));
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return list;
    }

    private Reponses_Tirage resultSetToReponses(ResultSet resultSet) throws SQLException {

        Reponses_Tirage reponses = new Reponses_Tirage();
        reponses.setIdReponseTirage(resultSet.getInt("test_id"));

        return reponses;

    }
}
