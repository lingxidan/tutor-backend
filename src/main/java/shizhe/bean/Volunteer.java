package shizhe.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * volunteer
 * @author 
 */
public class Volunteer extends User implements Serializable {
    private Integer id;

    private String education;

    private Date workStartdt;

    private Integer status;

    private Integer userId;

    private User user;

    private Integer certificate;

    private String descr;

    private String reason;

    private static final long serialVersionUID = 1L;


    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getWorkStartdt() {
        return workStartdt;
    }

    public void setWorkStartdt(Date workStartdt) {
        this.workStartdt = workStartdt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCertificate() {
        return certificate;
    }

    public void setCertificate(Integer certificate) {
        this.certificate = certificate;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

//    @Override
//    public boolean equals(Object that) {
//        if (this == that) {
//            return true;
//        }
//        if (that == null) {
//            return false;
//        }
//        if (getClass() != that.getClass()) {
//            return false;
//        }
//        Volunteer other = (Volunteer) that;
//        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
//            && (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()))
//            && (this.getWorkStartdt() == null ? other.getWorkStartdt() == null : this.getWorkStartdt().equals(other.getWorkStartdt()))
//            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
//            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
//            && (this.getCertificate() == null ? other.getCertificate() == null : this.getCertificate().equals(other.getCertificate()))
//            && (this.getDescr() == null ? other.getDescr() == null : this.getDescr().equals(other.getDescr()))
//            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()));
//    }
//
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
//        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
//        result = prime * result + ((getWorkStartdt() == null) ? 0 : getWorkStartdt().hashCode());
//        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
//        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
//        result = prime * result + ((getCertificate() == null) ? 0 : getCertificate().hashCode());
//        result = prime * result + ((getDescr() == null) ? 0 : getDescr().hashCode());
//        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
//        return result;
//    }
//
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", education=").append(education);
        sb.append(", workStartdt=").append(workStartdt);
        sb.append(", status=").append(status);
        sb.append(", userId=").append(userId);
        sb.append(", certificate=").append(certificate);
        sb.append(", descr=").append(descr);
        sb.append(", reason=").append(reason);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}