package bll.manager;

import bo.Propositions;
import bo.Questions;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;

import java.util.List;

public interface QuestionsManager {


    List<Questions> selectAll() throws ManagerException;

    Questions selectById(Integer id) throws ManagerException, ElementNotFoundException;


}
