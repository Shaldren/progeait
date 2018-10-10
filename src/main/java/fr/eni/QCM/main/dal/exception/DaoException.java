package main.java.fr.eni.QCM.main.dal.exception;

/**
 * Exception class for DAO Methods.
 * 
 * @author externe
 *
 */
public class DaoException extends Exception {

    private static final long serialVersionUID = 5373358650308469523L;

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
