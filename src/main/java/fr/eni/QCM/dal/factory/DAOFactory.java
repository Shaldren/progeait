package dal.factory;


import dal.dao.NoteDAO;

public class DAOFactory {

    public static NoteDAO noteDAO() {
        return NoteDao.getInstance();
    }
}
