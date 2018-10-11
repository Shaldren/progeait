package dal.dao.impl;

import bo.Questions_Tirage;
import dal.dao.Questions_TirageDAO;
import dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Questions_TirageDaoImpl implements Questions_TirageDAO {

    private static final String SELECT_ALL_QUESTION_QUERY = "SELECT t.id as test_id, t.libelle as test_libelle, t.description as test_description, t.duree as test_duree, t.seuil_haut as test_seuil_haut, t.seuil_bas as test_seuil_bas FROM test t";
    private static final String SELECT_ONE_QUESTION_QUERY = "SELECT t.id as test_id, t.libelle as test_libelle, t.description as test_description, t.duree as test_duree, t.seuil_haut as test_seuil_haut, t.seuil_bas as test_seuil_bas FROM test t where t.id = ?";
    private static final String SELECT_ONE_TEST_BY_LIBELLE_QUERY = "SELECT t.id FROM test t where t.description = ?";
    //private static final String INSERT_NOTE_QUERY = "INSERT INTO test(libelle, description, duree, seuil_haut, seuil_bas) VALUES (?, ?, ?, ?, ?)";
    //private static final String DELETE_NOTE_QUERY = "DELETE FROM test WHERE id = ?";
    //private static final String UPDATE_NOTE_QUERY = "UPDATE test SET libelle = ?, description = ?, duree = ?, seuil_haut = ?, seuil_bas = ? WHERE id = ?";

    private static TestsDaoImpl instance;

    @Override
    public Questions_Tirage insert(Questions_Tirage element) throws DaoException {
        return null;
    }

    @Override
    public void update(Questions_Tirage element) throws DaoException {

    }

    @Override
    public void delete(Integer integer) throws DaoException {

    }

    @Override
    public Questions_Tirage selectById(Integer integer) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Questions_Tirage questions = null;

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_QUESTION_QUERY);

            statement.setInt(1, integer);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                questions = resultSetToQuestionTirage(resultSet);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return questions;
    }

    @Override
    public List<Questions_Tirage> selectAll() throws DaoException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Questions_Tirage> list = new ArrayList<>();

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_QUESTION_QUERY);

            while (resultSet.next()) {
                list.add(resultSetToQuestionTirage(resultSet));
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return list;
    }

    private Questions_Tirage resultSetToQuestionTirage(ResultSet resultSet) throws SQLException {

        Questions_Tirage questions = new Questions_Tirage();
        questions.setIdQuestionTirage(resultSet.getInt("test_id"));
        questions.setNumOrdre(resultSet.getInt("test_libelle"));
        questions.setEstMarquee(resultSet.getBoolean("test_description"));

        return questions;

    }
}
