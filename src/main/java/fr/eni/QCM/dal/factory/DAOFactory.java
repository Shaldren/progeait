package dal.factory;


public class DAOFactory {

    public static NoteDAO noteDAO() {
        return NoteDao.getInstance();
    }
}
