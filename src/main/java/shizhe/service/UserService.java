package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.*;
import shizhe.dao.DatadictDAO;
import shizhe.dao.RecrIdentityDAO;
import shizhe.dao.UserDAO;

import java.util.Date;
import java.util.List;

@Service("UserService")
public class UserService{
    @Autowired
    UserDAO userDao;
//    @Autowired
//    VolunteerDAO volunteerDao;
//    @Autowired
//    RecruiterDAO recruiterDao;
    @Autowired
    DatadictDAO datadictDao;

    @Autowired
    RecrIdentityDAO recrIdentityDAO;
    // 登录
    public User login(String name, String password) {
        return userDao.login(name,password);
    }

    // 注册志愿者
    public int registeVolunteer(Volunteer user){
        user.setRegsitedt(new Date());
        user.setUserType(1);
        userDao.registeUser(user);
        int userId= user.getId();
        // 用户身份、教资认证、注册日期
        user.setUserId(userId);
        user.setCertificate(-1);
        // 求职状态：1：考虑机会
        user.setStatus(1);
        userDao.registeVolunteer(user);
        return userId;
    }

    // 注册招募者
    public int registeRecuiter(Recruiter user){
        user.setRegsitedt(new Date());
        user.setUserType(2);
        userDao.registeUser(user);
        int userId= user.getId();
        // 用户身份、注册日期
        user.setUserId(userId);
        userDao.registeRecruiter(user);
        // 第一次身份认证

        RecrIdentity recrIdentity = new RecrIdentity();
        recrIdentity.setCompanyName(user.getCompanyName());
        recrIdentity.setCompanyPhone(user.getCompanyPhone());
        recrIdentity.setApplyName(user.getIdentify());
        recrIdentity.setApplyId("");
        recrIdentity.setImage("");
        recrIdentity.setApplyDt(new Date());
        recrIdentity.setRecrId(user.getUserId());
        recrIdentity.setResult(-1);
        recrIdentityDAO.applyRecrIdenty(recrIdentity);
        return userId;
    }

    // 获取志愿者列表
    public List<Volunteer> getVols(String address,
                                    String education,
                                    String status,
                                    String certificate,String keyword){
        List<Volunteer> volunteers=userDao.selectVols(address, education, status, certificate,keyword);
        volunteers.forEach((volunteer -> volunteer.setAddressName(datadictDao.selectAddressByCode(volunteer.getAddress()))));
        return volunteers;
    }

    // 获取志愿者详情
    public Volunteer getVolunteer(int userId){
        Volunteer volunteer=userDao.getVolunteer(userId);
        volunteer.setAddressName(datadictDao.selectAddressByCode(volunteer.getAddress()));
        return volunteer;
    }

    // 修改志愿者信息
    public Boolean editVolunteer(Volunteer volunteer) throws CloneNotSupportedException {
        User user = (User)volunteer.clone();
        user.setId(volunteer.getUserId());
        int res1 = userDao.editUser(user);
        int res2 = userDao.editVolunteer(volunteer);
        return res1==1 && res2==1;
    }

    // 获取招募者列表
    public List<Recruiter> getRecrs(String address,
                                    String companyName){
        List<Recruiter> recruiters=userDao.selectRecrs(address, companyName);
        recruiters.forEach((recruiter -> recruiter.setAddressName(datadictDao.selectAddressByCode(recruiter.getAddress()))));
        return recruiters;
    }

    // 获取招募者详情
    public Recruiter getRecruiter(int userId){
        Recruiter recruiter=userDao.getRecruiter(userId);
        recruiter.setAddressName(datadictDao.selectAddressByCode(recruiter.getAddress()));
        return recruiter;
    }

    // 修改招募者信息
    public Boolean editRecruiter(Recruiter recruiter) throws CloneNotSupportedException {
        User user = (User)recruiter.clone();
        user.setId(recruiter.getUserId());
        int res1 = userDao.editUser(user);
        int res2 = userDao.editRecruiter(recruiter);
        return res1==1 && res2==1;
    }

    // 招募者身份认证
    public Integer applyRecrIdenty(RecrIdentity recrIdentity){
        recrIdentityDAO.applyRecrIdenty(recrIdentity);
        int id = recrIdentity.getId();
        return id;
    }
    // 招募者身份认证
    public User getUser(int userId){
        return userDao.getUser(userId);
    }
}
