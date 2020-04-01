package shizhe.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * vol_identity
 * @author 
 */
public class VolIdentity implements Serializable {
    private Integer id;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date applyDt;

    private String applyId;

    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date applyStartdt;

    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date applyEnddt;

    private String img;

    private String describe;

    private Integer result;

    private Integer volId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getApplyDt() {
        return applyDt;
    }

    public void setApplyDt(Date applyDt) {
        this.applyDt = applyDt;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public Date getApplyStartdt() {
        return applyStartdt;
    }

    public void setApplyStartdt(Date applyStartdt) {
        this.applyStartdt = applyStartdt;
    }

    public Date getApplyEnddt() {
        return applyEnddt;
    }

    public void setApplyEnddt(Date applyEnddt) {
        this.applyEnddt = applyEnddt;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getVolId() {
        return volId;
    }

    public void setVolId(Integer volId) {
        this.volId = volId;
    }
}