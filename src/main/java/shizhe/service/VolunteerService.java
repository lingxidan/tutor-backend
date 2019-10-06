package shizhe.service;

import shizhe.bean.Volunteer;
import shizhe.dao.UserDao;
import shizhe.dao.VolunteerDao;

public class VolunteerService {
    VolunteerDao volunteerDao;
    UserDao userDao;
    public Long registe(Volunteer volunteer){
        Long res = volunteerDao.registe(volunteer);
        userDao.registe(volunteer);
        return res;
    }
}
