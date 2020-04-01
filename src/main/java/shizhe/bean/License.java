package shizhe.bean;

import java.io.Serializable;
import java.util.List;

/**
 * license
 * @author 
 */
public class License implements Serializable {
    private String name;

    private String pname;

    public List<License> getSubList() {
        return subList;
    }

    public void setSubList(List<License> subList) {
        this.subList = subList;
    }

    private List<License> subList;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}