package dal.dao.impl;

import bo.Sections_Test;
import dal.dao.Sections_TestDAO;
import dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Sections_TestDaoImpl implements Sections_TestDAO {

    private static final String SELECT_ALL_SECTION_QUERY = "SELECT s.idSectionTest as section_id, s.nbQuestionATirer as section_nb FROM sections_test s";
    private static final String SELECT_ONE_SECTION_QUERY = "SELECT s.idSectionTest as section_id, s.nbQuestionATirer as section_nb FROM sections_test s where s.idSectionTest = ?";
    private static final String SELECT_ONE_NOTE_BY_NAME_QUERY = "SELECT n.id FROM note n where n.nom = ?";
    private static final String INSERT_EPREUVE_QUERY = "INSERT INTO epreuves(dateDebutValidite, dateFinValidite,tempsEcoule, note_obtenu, niveau_obtenu, etat) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String DELETE_NOTE_QUERY = "DELETE FROM note WHERE id = ?";
    private static final String UPDATE_NOTE_QUERY = "UPDATE note SET nom = ?, content = ? WHERE id = ?";

    private static Sections_TestDaoImpl instance;

    @Override
    public Sections_Test insert(Sections_Test element) throws DaoException {
        return null;
    }

    @Override
    public void update(Sections_Test element) throws DaoException {

    }

    @Override
    public void delete(Integer integer) throws DaoException {

    }

    @Override
    public Sections_Test selectById(Integer integer) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Sections_Test sectionstest = null;

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_SECTION_QUERY);

            statement.setInt(1, integer);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                sectionstest = resultSetToSectionsTest(resultSet);
            }
        } catch(SQLException e) {
            throw new dal.exception.DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return sectionstest;
    }

    @Override
    public List<Sections_Test> selectAll() throws DaoException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Sections_Test> list = new ArrayList<>();

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_SECTION_QUERY);

            while (resultSet.next()) {
                list.add(resultSetToSectionsTest(resultSet));
            }
        } catch(SQLException e) {
            throw new dal.exception.DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return list;
    }

    private Sections_Test resultSetToSectionsTest(ResultSet resultSet) throws SQLException {

        Sections_Test sectionstest = new Sections_Test();
        sectionstest.setIdSectionTest(resultSet.getInt("section_id"));
        sectionstest.setNbQuestionsATirer(resultSet.getInt("section_nb"));

        return sectionstest;

    }
}
