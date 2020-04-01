package shizhe.bean;

import java.io.Serializable;

/**
 * accusation
 * @author 
 */
public class Accusation implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer accuseId;

    private Integer accuseType;

    private Integer accuseResult;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAccuseId() {
        return accuseId;
    }

    public void setAccuseId(Integer accuseId) {
        this.accuseId = accuseId;
    }

    public Integer getAccuseType() {
        return accuseType;
    }

    public void setAccuseType(Integer accuseType) {
        this.accuseType = accuseType;
    }

    public Integer getAccuseResult() {
        return accuseResult;
    }

    public void setAccuseResult(Integer accuseResult) {
        this.accuseResult = accuseResult;
    }
}