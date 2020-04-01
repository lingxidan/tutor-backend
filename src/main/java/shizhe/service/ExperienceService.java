package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.Experience;
import shizhe.dao.DatadictDAO;
import shizhe.dao.ExperienceDAO;
//import shizhe.dao_bak.ExperienceDao;
//import shizhe.dao_bak.SchoolDao;

import java.util.ArrayList;
import java.util.List;

@Service("ExperienceService")
public class ExperienceService {
    @Autowired
    ExperienceDAO experienceDao;

    public List<Experience> selectByCondition(String userId){
        return experienceDao.selectByCondition(userId);
    }

    // 新增
    public Long insertExperience(Experience experience){
        return experienceDao.insertExperience(experience);
    }
    // 修改
    public Long updateExperience(Experience experience){
        return experienceDao.updateExperience(experience);
    }
    // 删除
    public Long deleteById(int id){
        return experienceDao.deleteById(id);
    }
}
