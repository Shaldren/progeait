package bll.manager;

import bo.Propositions;
import bo.Questions_Tirage;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;

import java.util.List;

public interface Questions_TirageManager {

    List<Questions_Tirage> selectAll() throws ManagerException;

    Questions_Tirage selectById(Integer id) throws ManagerException, ElementNotFoundException;

}
