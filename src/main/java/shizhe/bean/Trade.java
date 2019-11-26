package shizhe.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * trade
 * @author 
 */
public class Trade implements Serializable {
    private String code;

    private String name;

    private String pcode;

    private List<Trade> subList=new ArrayList<>();

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

    public List<Trade> getSubList() {
        return subList;
    }

    public void setSubList(List<Trade> subList) {
        this.subList = subList;
    }
}