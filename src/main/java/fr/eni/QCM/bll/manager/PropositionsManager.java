package bll.manager;

import bo.Epreuves;
import bo.Propositions;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;

import java.util.List;

public interface PropositionsManager {

    List<Propositions> selectAll() throws ManagerException;

    Propositions selectById(Integer id) throws ManagerException, ElementNotFoundException;

}
