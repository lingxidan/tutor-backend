package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.ExpectJob;
import shizhe.bean.School;
import shizhe.dao.DatadictDao;
import shizhe.dao.ExpectJobDao;
import shizhe.dao.SchoolDao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("ExpectJobService")
public class ExpectJobService {
    @Autowired
    ExpectJobDao expectJobDao;
    @Autowired
    DatadictDao datadictDao;
    @Autowired
    SchoolDao schoolDao;
    // 查询
    public ExpectJob selectById(int id){
        ExpectJob expectJob=expectJobDao.selectById(id);
        return expectJob;
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
