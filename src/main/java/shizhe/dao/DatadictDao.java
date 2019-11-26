package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.Address;
import shizhe.bean.Jobtype;
import shizhe.bean.License;
import shizhe.bean.Trade;

import java.util.List;

@Repository
public interface DatadictDao {

    // 地区
    int insertAddress(Address record);
    int deleteAddress();
    List<Address> selectAddress(@Param("level") int level, @Param("pcode") String pcode);
    String selectAddressByCode(@Param("code") String code);


    // 公司行业
    int insertTrade(Trade record);
    int deleteTrade();
    List<Trade> selectTrade();

    // 职业类型
    int insertJobtype(Jobtype record);
    int deleteJobtype();
    List<Jobtype> selectJobtype();

    // 资格证书
    int insertLicense(License record);
    int deleteLicense();
    List<License> selectLicense();


}