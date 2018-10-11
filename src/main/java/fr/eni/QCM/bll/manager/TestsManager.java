package bll.manager;

import bo.Propositions;
import bo.Tests;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;

import java.util.List;

public interface TestsManager {


    List<Tests> selectAll() throws ManagerException;

    Tests selectById(Integer id) throws ManagerException, ElementNotFoundException;

}
