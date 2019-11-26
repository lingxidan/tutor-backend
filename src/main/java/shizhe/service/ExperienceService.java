package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.Experience;
import shizhe.dao.DatadictDao;
import shizhe.dao.ExperienceDao;
import shizhe.dao.SchoolDao;

import java.util.List;

@Service("ExperienceService")
public class ExperienceService {
    @Autowired
    ExperienceDao experienceDao;
    @Autowired
    DatadictDao datadictDao;
    @Autowired
    SchoolDao schoolDao;
    // 查询
    public Experience selectById(int id){
        Experience experience=experienceDao.selectById(id);
        return experience;
    }
    public List<Experience> selectByCondition(String userId){
        List<Experience> experienceList=experienceDao.selectByCondition(userId);
        return experienceList;
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
