package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.School;
import shizhe.dao.DatadictDAO;
import shizhe.dao.SchoolDAO;

import java.util.ArrayList;
import java.util.List;

@Service("SchoolService")
public class SchoolService {
    @Autowired
    SchoolDAO schoolDao;
    @Autowired
    DatadictDAO datadictDao;
    // 查询
    public School selectById(int id){
        School school=schoolDao.selectById(id);
        school.setAddressName(datadictDao.selectAddressByCode(school.getAddress()));
        return school;
    }
    public List<School> selectByCondition(String userId,
                                          String address,
                                          String keyword,
                                          String status){
        List<School> schoolList=schoolDao.selectByCondition(userId,
                address,keyword,status);
        for(int i=0;i<schoolList.size();i++){
            schoolList.get(i).setAddressName(datadictDao.selectAddressByCode(schoolList.get(i).getAddress()));
        }
        return schoolList;
    }
//    public List<School> selectByScale(String scale){
//        List<School> schoolList=schoolDao.selectByScale(scale);
//        schoolList.forEach(this::addAddrName);
//        return schoolList;
//    }
//    public List<School> selectByAddr(String address){
//        List<School> schoolList=schoolDao.selectByAddr(address);
//        schoolList.forEach(this::addAddrName);
//        return schoolList;
//    }
//    public List<School> selectByName(String keyword){
//        List<School> schoolList=schoolDao.selectByName(keyword);
//        schoolList.forEach(this::addAddrName);
//        return schoolList;
//    }
//    public List<School> selectByStatus(int status){
//        List<School> schoolList=schoolDao.selectByStatus(status);
//        schoolList.forEach(this::addAddrName);
//        return schoolList;
//    }

    // 新增
    public Long insertSchool(School school){
        school.setAddressName(datadictDao.selectAddressByCode(school.getAddress()));
        school.setStatus(1);
        return schoolDao.insertSchool(school);
    }
    // 修改
    public Long updateSchool(School school){
        return schoolDao.updateSchool(school);
    }
    // 删除学校
    public Long deleteSchool(int id){
        return schoolDao.deleteSchool(id);
    }
}
