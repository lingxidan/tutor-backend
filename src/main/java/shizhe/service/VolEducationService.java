package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.VolEducation;
import shizhe.dao.DatadictDao;
import shizhe.dao.VolEducationDao;
import shizhe.dao.SchoolDao;

import java.util.List;

@Service("VolEducationService")
public class VolEducationService {
    @Autowired
    VolEducationDao volEducationDao;
    @Autowired
    DatadictDao datadictDao;
    @Autowired
    SchoolDao schoolDao;
    // 查询
    public VolEducation selectById(int id){
        VolEducation volEducation=volEducationDao.selectById(id);
        return volEducation;
    }
    public List<VolEducation> selectByCondition(String userId){
        List<VolEducation> volEducationList=volEducationDao.selectByCondition(userId);
        return volEducationList;
    }

    // 新增
    public Long insertVolEducation(VolEducation volEducation){
        return volEducationDao.insertVolEducation(volEducation);
    }
    // 修改
    public Long updateVolEducation(VolEducation volEducation){
        return volEducationDao.updateVolEducation(volEducation);
    }
    // 删除
    public Long deleteById(int id){
        return volEducationDao.deleteById(id);
    }
}
