package shizhe.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * resume_file
 * @author 
 */
public class ResumeFile implements Serializable {
    private Integer id;

    private String name;

    private String filepath;

    private Date upDt;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Date getUpDt() {
        return upDt;
    }

    public void setUpDt(Date upDt) {
        this.upDt = upDt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}