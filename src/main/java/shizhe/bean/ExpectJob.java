package shizhe.bean;

import java.io.Serializable;
import java.util.List;

/**
 * expect_job
 * @author 
 */
public class ExpectJob implements Serializable {
    private Integer id;

    private String name;

    private String addrs;

    public List<String> getAddrNames() {
        return addrNames;
    }

    public void setAddrNames(List<String> addrNames) {
        this.addrNames = addrNames;
    }

    private List<String> addrNames;

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

    public String getAddrs() {
        return addrs;
    }

    public void setAddrs(String addrs) {
        this.addrs = addrs;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}