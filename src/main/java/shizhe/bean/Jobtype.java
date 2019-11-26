package shizhe.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * jobtype
 * @author 
 */
public class Jobtype implements Serializable {
    private String code;

    private String name;

    private String pcode;

    private List<Jobtype> subList=new ArrayList<>();

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

    public List<Jobtype> getSubList() {
        return subList;
    }

    public void setSubList(List<Jobtype> subList) {
        this.subList = subList;
    }
}