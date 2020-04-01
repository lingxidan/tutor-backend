package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.VolEducation;
import shizhe.dao.DatadictDAO;
import shizhe.dao.VolEducationDAO;

import java.util.ArrayList;
import java.util.List;

@Service("VolEducationService")
public class VolEducationService {
    @Autowired
    VolEducationDAO volEducationDao;
    @Autowired
    DatadictDAO datadictDao;

    public List<VolEducation> selectByCondition(String userId){
        return volEducationDao.selectByCondition(userId);
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
