package dal.dao.impl;

import bo.Questions;
import dal.dao.QuestionsDAO;
import dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionsDaoImpl implements QuestionsDAO {

    private static final String SELECT_ALL_QUESTION_QUERY = "SELECT q.idQuestion as question_id, q.enonce as question_enonce, q.media as question_media, q.points as question_points FROM questions q ";
    private static final String SELECT_ONE_QUESTION_QUERY = "SELECT q.idQuestion as question_id, q.enonce as question_enonce, q.media as question_media, q.points as question_points FROM questions q where q.idQuestion = ?";
    private static final String SELECT_ONE_THEME_BY_LIBELLE_QUERY = "SELECT t.idTheme as theme_id FROM themes t where t.libelle = ?";
    private static final String INSERT_EPREUVE_QUERY = "INSERT INTO epreuves(dateDebutValidite, dateFinValidite,tempsEcoule, note_obtenu, niveau_obtenu, etat) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String DELETE_NOTE_QUERY = "DELETE FROM note WHERE id = ?";
    private static final String UPDATE_NOTE_QUERY = "UPDATE note SET nom = ?, content = ? WHERE id = ?";

    private static QuestionsDaoImpl instance;

    @Override
    public Questions insert(Questions element) throws DaoException {
        return null;
    }

    @Override
    public void update(Questions element) throws DaoException {

    }

    @Override
    public void delete(Integer integer) throws DaoException {

    }

    @Override
    public Questions selectById(Integer integer) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Questions questions = null;

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_QUESTION_QUERY);

            statement.setInt(1, integer);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                questions = resultSetToQuestions(resultSet);
            }
        } catch(SQLException e) {
            throw new dal.exception.DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return questions;
    }

    @Override
    public List<Questions> selectAll() throws DaoException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Questions> list = new ArrayList<>();

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_QUESTION_QUERY);

            while (resultSet.next()) {
                list.add(resultSetToQuestions(resultSet));
            }
        } catch(SQLException e) {
            throw new dal.exception.DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return list;
    }


    private Questions resultSetToQuestions(ResultSet resultSet) throws SQLException {

        Questions questions = new Questions();
        questions.setIdQuestion(resultSet.getInt("question_id"));
        questions.setEnonce(resultSet.getString("question_enonce"));
        questions.setMedia(new File(String.valueOf(resultSet.getObject("question_media"))));
        questions.setPoints(resultSet.getInt("question_points"));

        return questions;

    }
}
