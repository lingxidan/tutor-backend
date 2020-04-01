package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.Job;
import shizhe.dao.DatadictDAO;
import shizhe.dao.JobDAO;
import shizhe.dao.SchoolDAO;

import java.util.Date;
import java.util.List;

@Service("JobService")
public class JobService {
    @Autowired
    JobDAO jobDao;
    @Autowired
    DatadictDAO datadictDao;
    @Autowired
    SchoolDAO schoolDao;
    // 查询
    public Job selectById(int id){
        Job job=jobDao.selectById(id);
        job.setAddressName(datadictDao.selectAddressByCode(job.getAddress()));
        return job;
    }
    public List<Job> selectByCondition(String userId,
                                       String schoolId,
                                       String address,
                                       String keyword,
                                       String education,
                                       String status){
        return jobDao.selectByCondition(userId,schoolId,address,keyword,
                education,status);
    }

    // 新增
    public Long insertJob(Job job){
        job.setEstablishDt(new Date());
        job.setAddressName(datadictDao.selectAddressByCode(job.getAddress()));
        job.setStatus(1);
        return jobDao.insertJob(job);
    }
    // 修改
    public Long updateJob(Job job){
        return jobDao.updateJob(job);
    }
    // 删除学校
    public int deleteJob(int id){
        return jobDao.deleteJob(id);
    }

}
