package shizhe.bean;

import java.io.Serializable;

/**
 * recruiter
 * @author 
 */
public class Recruiter extends User implements Serializable {
    private Integer id;

    private String identify;

    private Integer userId;

    private String reason;

    private static final long serialVersionUID = 1L;

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", identify=").append(identify);
        sb.append(", userId=").append(userId);
        sb.append(", reason=").append(reason);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}