package fr.eni.QCM.main.api;

import javax.ws.rs.Path;

import fr.eni.tp.prisedenotes.bll.factory.ManagerFactory;
import fr.eni.tp.prisedenotes.bll.manager.NoteManager;

@Path("/notes")
public class NoteApi {
    
    private NoteManager noteManager = ManagerFactory.noteManager();
    
}
