package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.Recruiter;
import shizhe.bean.User;
import shizhe.bean.Volunteer;
import shizhe.dao.DatadictDao;
import shizhe.dao.RecruiterDao;
import shizhe.dao.UserDao;
import shizhe.dao.VolunteerDao;

import java.util.List;

@Service("UserService")
public class UserService{
    @Autowired
    UserDao userDao;
    @Autowired
    VolunteerDao volunteerDao;
    @Autowired
    RecruiterDao recruiterDao;
    @Autowired
    DatadictDao datadictDao;
    public List<User> getAll() {
        return userDao.getAll();
    }

    public User login(String name, String password) {
        return userDao.login(name,password);
    }

    public Long registe(User user){
        return userDao.registe(user);
    }

    public int registeVolunteer(Volunteer user){
//
        userDao.registe(user);
        int userId= user.getId();
        System.out.println(userId);
        user.setUserId(userId);
        user.setStatus(1);
        volunteerDao.registe(user);
        return userId;
    }

    public int registeRecuiter(Recruiter user){
//        System.out.println(userDao);
//        System.out.println(recruiterDao);
//        System.out.println(recruiterDao.registe(user));
        Long res1=userDao.registe(user);
//        user.setId(user.getId());
        int userId= user.getId();
        user.setUserId(userId);
        user.setIdentify("1");
        Long res2=recruiterDao.registe(user);
        System.out.println(res1+","+res2);
        return userId;
    }

    public Volunteer getVolunteer(int userId){
        Volunteer volunteer=volunteerDao.getVolunteer(userId);
        volunteer.setAddressName(datadictDao.selectAddressByCode(volunteer.getAddress()));
        return volunteer;
    }

    public int editVolunteer(Volunteer volunteer){
        int res2=volunteerDao.edit(volunteer);
        System.out.println(volunteer.getId()+","+volunteer.getUserId());
        volunteer.setId(volunteer.getUserId());
        Long res1=userDao.edit(volunteer);
        System.out.println(res1+","+res2);
        return 1;
    }

    //招募者


    public Recruiter getRecruiter(int userId){
        Recruiter recruiter=recruiterDao.getRecruiter(userId);
        recruiter.setAddressName(datadictDao.selectAddressByCode(recruiter.getAddress()));
        return recruiter;
    }

    public int editRecruiter(Recruiter recruiter){
        int res2=recruiterDao.edit(recruiter);
        System.out.println(recruiter.getId()+","+recruiter.getUserId());
        recruiter.setId(recruiter.getUserId());
        Long res1=userDao.editRecruiter(recruiter);
        System.out.println(res1+","+res2);
        return 1;
    }
}
