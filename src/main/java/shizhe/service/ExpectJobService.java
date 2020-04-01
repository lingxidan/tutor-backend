package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.ExpectJob;
import shizhe.dao.DatadictDAO;
import shizhe.dao.ExpectJobDAO;
//import shizhe.dao_bak.SchoolDao;

import java.util.ArrayList;
import java.util.List;

@Service("ExpectJobService")
public class ExpectJobService {
    @Autowired
    ExpectJobDAO expectJobDao;
    @Autowired
    DatadictDAO datadictDao;
//    @Autowired
//    SchoolDao schoolDao;
    // 查询
    public ExpectJob selectById(int id){
        return expectJobDao.selectById(id);
    }
    public List<ExpectJob> selectByCondition(String userId){
        List<ExpectJob> expectJobList=expectJobDao.selectByCondition(userId);
        for(int i=0;i<expectJobList.size();i++){
            ExpectJob expectJob=expectJobList.get(i);
            String[] addrs = expectJob.getAddrs().split(";");
            List<String> addrNames = new ArrayList<>();
            for(int j=0;j<addrs.length;j++){
                String addr=addrs[j];
                String addrName=datadictDao.selectAddressByCode(addr);
                addrNames.add(addrName);
            }
            expectJob.setAddrNames(addrNames);
        }
        return expectJobList;
    }

    // 新增
    public Long insertExpectJob(ExpectJob expectJob){
        return expectJobDao.insertExpectJob(expectJob);
    }
    // 修改
    public Long updateExpectJob(ExpectJob expectJob){
        return expectJobDao.updateExpectJob(expectJob);
    }
    // 删除
    public Long deleteById(int id){
        return expectJobDao.deleteById(id);
    }
}
