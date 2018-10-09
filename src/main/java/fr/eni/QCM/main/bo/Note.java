package fr.eni.QCM.main.bo;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 5316335132571438735L;
    
    private Integer id;
    private Date createdAt;
    private String name;
    private String content;
    
        
    public Note() {
        super();
    }
    
    
    public Note(Integer id, Date createdAt, String name, String content) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.name = name;
        this.content = content;
    }


    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }


    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }
    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    
}
