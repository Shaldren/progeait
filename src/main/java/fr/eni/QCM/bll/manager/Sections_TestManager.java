package bll.manager;

import bo.Sections_Test;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;

import java.util.List;

public interface Sections_TestManager {

    List<Sections_Test> selectAll() throws ManagerException;

    Sections_Test selectById(Integer id) throws ManagerException, ElementNotFoundException;

}
