package bll.manager;

import bo.Propositions;
import bo.Themes;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;

import java.util.List;

public interface ThemesManager {


    List<Themes> selectAll() throws ManagerException;

    Themes selectById(Integer id) throws ManagerException, ElementNotFoundException;

}
