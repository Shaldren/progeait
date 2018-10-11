package dal.dao.impl;

import bo.Themes;
import dal.dao.ThemesDAO;
import dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThemesDaoImpl implements ThemesDAO {

    private static final String SELECT_ALL_THEME_QUERY = "SELECT t.idTheme as theme_id, t.libelle as theme_libelle FROM themes t ";
    private static final String SELECT_ONE_THEME_QUERY = "SELECT t.idTheme as theme_id, t.libelle as theme_libelle FROM themes t where t.idTheme = ?";
    private static final String SELECT_ONE_THEME_BY_LIBELLE_QUERY = "SELECT t.idTheme as theme_id FROM themes t where t.libelle = ?";
    private static final String INSERT_EPREUVE_QUERY = "INSERT INTO epreuves(dateDebutValidite, dateFinValidite,tempsEcoule, note_obtenu, niveau_obtenu, etat) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String DELETE_NOTE_QUERY = "DELETE FROM note WHERE id = ?";
    private static final String UPDATE_NOTE_QUERY = "UPDATE note SET nom = ?, content = ? WHERE id = ?";

    private static Sections_TestDaoImpl instance;

    @Override
    public Themes insert(Themes element) throws DaoException {
        return null;
    }

    @Override
    public void update(Themes element) throws DaoException {

    }

    @Override
    public void delete(Integer integer) throws DaoException {

    }

    @Override
    public Themes selectById(Integer integer) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Themes themes = null;

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_THEME_QUERY);

            statement.setInt(1, integer);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                themes = resultSetToThemes(resultSet);
            }
        } catch(SQLException e) {
            throw new dal.exception.DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return themes;
    }

    @Override
    public List<Themes> selectAll() throws DaoException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Themes> list = new ArrayList<>();

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_THEME_QUERY);

            while (resultSet.next()) {
                list.add(resultSetToThemes(resultSet));
            }
        } catch(SQLException e) {
            throw new dal.exception.DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return list;
    }

    @Override
    public Themes selectByLibelle(String libelle) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Themes themes = null;

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_THEME_BY_LIBELLE_QUERY);

            statement.setString(1, libelle);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                themes = resultSetToThemes(resultSet);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return themes;
    }

    private Themes resultSetToThemes(ResultSet resultSet) throws SQLException {

        Themes themes = new Themes();
        themes.setIdTheme(resultSet.getInt("theme_id"));
        themes.setLibelle(resultSet.getString("theme_libelle"));

        return themes;

    }
}
