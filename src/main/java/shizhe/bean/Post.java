package shizhe.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * post
 * @author 
 */
public class Post implements Serializable {
    private Integer id;

    private String title;

    private Date establishDt;

    private Integer authorId;

    private String content;

    private String imgs;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEstablishDt() {
        return establishDt;
    }

    public void setEstablishDt(Date establishDt) {
        this.establishDt = establishDt;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }
}