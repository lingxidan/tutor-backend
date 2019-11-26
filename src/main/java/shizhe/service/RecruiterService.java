package shizhe.service;

import shizhe.bean.Recruiter;
import shizhe.dao.RecruiterDao;
import shizhe.dao.UserDao;

public class RecruiterService {
    RecruiterDao recruiterDao;
    UserDao userDao;
    public Long registe(Recruiter recruiter){
        Long res = recruiterDao.registe(recruiter);
        userDao.registe(recruiter);
        return res;
    }
}
