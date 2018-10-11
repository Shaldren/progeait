package bll.manager;

import bo.Propositions;
import bo.Reponses_Tirage;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;

import java.util.List;

public interface Reponses_TirageManager {

    List<Reponses_Tirage> selectAll() throws ManagerException;

    Reponses_Tirage selectById(Integer id) throws ManagerException, ElementNotFoundException;

}
