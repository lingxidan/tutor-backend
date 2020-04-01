package shizhe.bean;

import java.io.Serializable;

/**
 * company
 * @author 
 */
public class Company implements Serializable {
    private String code;

    private String name;

    private String pcode;

    private static final long serialVersionUID = 1L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }
}