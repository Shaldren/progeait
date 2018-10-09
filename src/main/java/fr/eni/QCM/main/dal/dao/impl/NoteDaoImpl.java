package fr.eni.QCM.main.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.tp.prisedenotes.bo.Note;
import fr.eni.tp.prisedenotes.dal.dao.NoteDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class NoteDaoImpl implements NoteDAO {

    private static final String SELECT_ALL_NOTES_QUERY = "SELECT n.id as note_id, n.nom as note_nom, n.created_at as note_created_at, n.content as note_content FROM note n ORDER BY n.created_at DESC";
    private static final String SELECT_ONE_NOTE_QUERY = "SELECT n.id as note_id, n.nom as note_nom, n.created_at as note_created_at, n.content as note_content FROM note n where n.id = ?";
    private static final String SELECT_ONE_NOTE_BY_NAME_QUERY = "SELECT n.id FROM note n where n.nom = ?";
    private static final String INSERT_NOTE_QUERY = "INSERT INTO note(nom, created_at, content) VALUES (?, ?, ?)";
    private static final String DELETE_NOTE_QUERY = "DELETE FROM note WHERE id = ?";
    private static final String UPDATE_NOTE_QUERY = "UPDATE note SET nom = ?, content = ? WHERE id = ?";
    
    private static NoteDaoImpl instance;
    
    private NoteDaoImpl() {
        
    }
    
    public static NoteDaoImpl getInstance() {
        if(instance == null) {
            instance = new NoteDaoImpl();
        }
        return instance;
    }
    
    @Override
    public Note insert(Note note) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = MSSQLConnectionFactory.get();
            
            statement = connection.prepareStatement(INSERT_NOTE_QUERY, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, note.getName());
            statement.setTimestamp(2,  new Timestamp(note.getCreatedAt().getTime()));
            statement.setString(3, note.getContent());

            if (statement.executeUpdate() == 1) {
                resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    
                    note.setId(resultSet.getInt(1));                    
                }
            }

        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }
        
        return note;
    }

    @Override
    public boolean checkExistenceWithName(String name) throws DaoException {
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean exists = false;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_NOTE_BY_NAME_QUERY);
            
            statement.setString(1, name);
            resultSet = statement.executeQuery();

            exists = resultSet.next();
            
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }
        
        return exists;
    }

    @Override
    public void update(Note note) throws DaoException {
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = MSSQLConnectionFactory.get();
            
            statement = connection.prepareStatement(UPDATE_NOTE_QUERY);
            
            statement.setString(1, note.getName());
            statement.setString(2, note.getContent());
            statement.setInt(3, note.getId());
            
            statement.executeUpdate();

        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }
        
    }

    @Override
    public void delete(Integer id) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = MSSQLConnectionFactory.get();
            
            statement = connection.prepareStatement(DELETE_NOTE_QUERY);
            
            statement.setInt(1, id);
            
            statement.executeUpdate();

        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }
    }

    @Override
    public Note selectById(Integer id) throws DaoException {
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Note note = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_NOTE_QUERY);
            
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                note = resultSetToNote(resultSet);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }
        
        return note;
    }

    @Override
    public List<Note> selectAll() throws DaoException {
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Note> list = new ArrayList<>();
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_NOTES_QUERY);

            while (resultSet.next()) {
                list.add(resultSetToNote(resultSet));
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }
        
        return list;
    }
    
    private Note resultSetToNote(ResultSet resultSet) throws SQLException {
        
        Note note = new Note();
        note.setId(resultSet.getInt("note_id"));
        note.setName(resultSet.getString("note_nom"));
        note.setCreatedAt(new Date(resultSet.getTimestamp("note_created_at").getTime()));
        note.setContent(resultSet.getString("note_content"));
        
        return note;
        
    }

}
