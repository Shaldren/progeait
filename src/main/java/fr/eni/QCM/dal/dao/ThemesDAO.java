package dal.dao;

import bo.Themes;
import dal.exception.DaoException;

public interface ThemesDAO extends GenericDAO<Themes,Integer> {

    Themes selectByLibelle(String libelle) throws DaoException;

}
