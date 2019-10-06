package shizhe.bean;

import java.io.Serializable;

/**
 * user
 * @author 
 */
public class User implements Serializable {
    private Integer id;

    private String name;

    private String password;

    private String idcard;

    private String phone;

    private String email;

    private String address;

    private String addressName;

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    private String regsitedt;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegsitedt() {
        return regsitedt;
    }

    public void setRegsitedt(String regsitedt) {
        this.regsitedt = regsitedt;
    }

}