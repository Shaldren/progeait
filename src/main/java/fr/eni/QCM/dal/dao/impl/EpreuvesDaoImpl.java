package dal.dao.impl;

import bo.Epreuves;
import dal.dao.EpreuvesDAO;
import dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EpreuvesDaoImpl implements EpreuvesDAO {

    private static final String SELECT_ALL_NOTES_QUERY = "SELECT n.id as note_id, n.nom as note_nom, n.created_at as note_created_at, n.content as note_content FROM note n ORDER BY n.created_at DESC";
    private static final String SELECT_ONE_EPREUVE_QUERY = "SELECT e.idEpreuve as epreuve_id, e.dateDebutValidite as epreuve_dateDebut, e.dateFinValidite as epreuve_dateFin, e.tempsEcoule as epreuve_temps, e.note_obtenu as epreuve_note, e.niveau_obtenu as epreuve_niveau, e.etat as epreuve_etat FROM epreuve e where e.id = ?";
    private static final String SELECT_ONE_NOTE_BY_NAME_QUERY = "SELECT n.id FROM note n where n.nom = ?";
    private static final String INSERT_EPREUVE_QUERY = "INSERT INTO epreuves(dateDebutValidite, dateFinValidite,tempsEcoule, note_obtenu, niveau_obtenu, etat) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String DELETE_NOTE_QUERY = "DELETE FROM note WHERE id = ?";
    private static final String UPDATE_NOTE_QUERY = "UPDATE note SET nom = ?, content = ? WHERE id = ?";

    private static EpreuvesDaoImpl instance;

    public EpreuvesDaoImpl() {
    }

    public static EpreuvesDaoImpl getInstance() {
        if(instance==null){
            instance = new EpreuvesDaoImpl();
        }
        return instance;
    }

    @Override
    public Epreuves insert(Epreuves element) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = MSSQLConnectionFactory.get();

            statement = connection.prepareStatement(INSERT_EPREUVE_QUERY, Statement.RETURN_GENERATED_KEYS);

            statement.setDate(1, element.getDateDebutValidite());
            statement.setDate(2, element.getDateFinValidite());
            statement.setTime(3, element.getTempsEcoule());
            statement.setFloat(4, element.getNote_obtenue());
            statement.setString(5, element.getNiveau_obtenu());
            statement.setString(6, element.getEtat());

            if (statement.executeUpdate() == 1) {
                resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {

                    element.setIdEpreuve(resultSet.getInt(1));
                }
            }

        } catch(SQLException e) {
            throw new dal.exception.DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return element;
    }

    @Override
    public void update(Epreuves element) throws DaoException {

    }

    @Override
    public void delete(Integer integer) throws DaoException {

    }

    @Override
    public Epreuves selectById(Integer integer) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Epreuves epreuves = null;

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_EPREUVE_QUERY);

            statement.setInt(1, integer);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                epreuves = resultSetToEpreuves(resultSet);
            }
        } catch(SQLException e) {
            throw new dal.exception.DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return epreuves;
    }

    @Override
    public List<Epreuves> selectAll() throws DaoException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Epreuves> list = new ArrayList<>();

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_NOTES_QUERY);

            while (resultSet.next()) {
                list.add(resultSetToEpreuves(resultSet));
            }
        } catch(SQLException e) {
            throw new dal.exception.DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return list;
    }

    private Epreuves resultSetToEpreuves(ResultSet resultSet) throws SQLException {

        Epreuves epreuves = new Epreuves();
        epreuves.setIdEpreuve(resultSet.getInt("epreuve_id"));
        epreuves.setDateDebutValidite(resultSet.getDate("epreuve_dateDebut"));
        epreuves.setDateFinValidite(resultSet.getDate("epreuve_dateFin"));
        epreuves.setTempsEcoule(resultSet.getTime("epreuve_temps"));
        epreuves.setNote_obtenue(resultSet.getFloat("epreuve_note"));
        epreuves.setNiveau_obtenu(resultSet.getString("epreuve_niveau"));
        epreuves.setEtat(resultSet.getString("epreuve_etat"));

        return epreuves;

    }
}