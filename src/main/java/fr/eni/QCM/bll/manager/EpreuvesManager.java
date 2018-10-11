package bll.manager;

import bo.Epreuves;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;

import java.util.List;

public interface EpreuvesManager {

    List<Epreuves> selectAll() throws ManagerException;

    Epreuves selectById(Integer id) throws ManagerException, ElementNotFoundException;

}
