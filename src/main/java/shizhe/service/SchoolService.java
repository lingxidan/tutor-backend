package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import shizhe.bean.Address;
import shizhe.bean.School;
import shizhe.dao.DatadictDao;
import shizhe.dao.SchoolDao;

import java.util.List;

@Service("SchoolService")
public class SchoolService {
    @Autowired
    SchoolDao schoolDao;
    @Autowired
    DatadictDao datadictDao;
    // 查询
    public School selectById(int id){
        School school=schoolDao.selectById(id);
        school.setAddressName(datadictDao.selectAddressByCode(school.getAddress()));
//        addAddrName(school);
        return school;
    }
    public List<School> selectByCondition(String userId,
                                          String scale,
                                          String address,
                                          String keyword,
                                          String status){
        List<School> schoolList=schoolDao.selectByCondition(userId,scale,
                address,keyword,status);
        for(int i=0;i<schoolList.size();i++){
            schoolList.get(i).setAddressName(datadictDao.selectAddressByCode(schoolList.get(i).getAddress()));
        }
//        schoolList.forEach(this::addAddrName);
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
//        school=addAddrName(school);
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

    private School addAddrName(School school){
        String address =school.getAddress();
        String addressName="";
        String province = address.substring(0,2);
        String city = address.substring(0,4);
        String county = address.substring(0,6);
//        addressName+=datadictDao.selectByCode(province).getName();
//        addressName+=datadictDao.selectByCode(city).getName();
//        addressName+=datadictDao.selectByCode(county).getName();
        addressName=datadictDao.selectAddressByCode(address);
        school.setAddressName(addressName);
        return school;
    }
}
