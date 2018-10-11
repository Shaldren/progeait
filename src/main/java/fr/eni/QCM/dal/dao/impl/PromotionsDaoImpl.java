package dal.dao.impl;

import bo.Propositions;
import bo.Tests;
import dal.dao.PromotionsDAO;
import dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PromotionsDaoImpl implements PromotionsDAO {

    private static final String SELECT_ALL_PROPOSITION_QUERY = "SELECT p.idProposition as propo_id, p.enonce as propo_enonce, p.estBonne as propo_estBonne FROM propositions p";
    private static final String SELECT_ONE_PROPOSITION_QUERY = "SELECT p.idProposition as propo_id, p.enonce as propo_enonce, p.estBonne as propo_estBonne FROM propositions p where p.idProposition = ?";
    private static final String SELECT_ONE_TEST_BY_LIBELLE_QUERY = "SELECT t.id FROM test t where t.description = ?";
    //private static final String INSERT_NOTE_QUERY = "INSERT INTO test(libelle, description, duree, seuil_haut, seuil_bas) VALUES (?, ?, ?, ?, ?)";
    //private static final String DELETE_NOTE_QUERY = "DELETE FROM test WHERE id = ?";
    //private static final String UPDATE_NOTE_QUERY = "UPDATE test SET libelle = ?, description = ?, duree = ?, seuil_haut = ?, seuil_bas = ? WHERE id = ?";

    private static TestsDaoImpl instance;

    @Override
    public Propositions insert(Propositions element) throws DaoException {
        return null;
    }

    @Override
    public void update(Propositions element) throws DaoException {

    }

    @Override
    public void delete(Integer integer) throws DaoException {

    }

    @Override
    public Propositions selectById(Integer integer) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Propositions propositions = null;

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_PROPOSITION_QUERY);

            statement.setInt(1, integer);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                propositions = resultSetToPropositions(resultSet);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return propositions;
    }

    @Override
    public List<Propositions> selectAll() throws DaoException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Propositions> list = new ArrayList<>();

        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_PROPOSITION_QUERY);

            while (resultSet.next()) {
                list.add(resultSetToPropositions(resultSet));
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }

        return list;
    }

    private Propositions resultSetToPropositions(ResultSet resultSet) throws SQLException {

        Propositions propositions = new Propositions();
        propositions.setIdProposition(resultSet.getInt("propo_id"));
        propositions.setEnonce(resultSet.getString("propo_enonce"));
        propositions.setEstBonne(resultSet.getBoolean("propo_estBonne"));

        return propositions;

    }
}
