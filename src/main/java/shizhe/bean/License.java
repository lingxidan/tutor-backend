package shizhe.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * license
 * @author 
 */
public class License implements Serializable {
    private String name;

    private String pname;

    private List<License> subList=new ArrayList<>();

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

    public List<License> getSubList() {
        return subList;
    }

    public void setSubList(List<License> subList) {
        this.subList = subList;
    }
}