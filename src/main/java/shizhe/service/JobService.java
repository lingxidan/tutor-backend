package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.Job;
import shizhe.bean.School;
import shizhe.dao.DatadictDao;
import shizhe.dao.JobDao;
import shizhe.dao.JobDao;
import shizhe.dao.SchoolDao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("JobService")
public class JobService {
    @Autowired
    JobDao jobDao;
    @Autowired
    DatadictDao datadictDao;
    @Autowired
    SchoolDao schoolDao;
    // 查询
    public Job selectById(int id){
        Job job=jobDao.selectById(id);
//        addAddrName(job);
        return job;
    }
    public List<Job> selectByCondition(String userId,
                                       String schoolId,
                                       String address,
                                       String keyword,
                                       String education,
                                       String establishDt,
                                       String status){
        List<Job> jobList=jobDao.selectByCondition(userId,schoolId,address,keyword,
                education,establishDt,status);
//        jobList.forEach(this::addAddrName);
        return jobList;
    }

    // 新增
    public Long insertJob(Job job){
        job.setEstablishDt((new SimpleDateFormat("yyyy-MM-dd"/*你想要的格式*/)).format(new Date()));
        job=addAddrName(job);
        return jobDao.insertJob(job);
    }
    // 修改
    public Long updateJob(Job job){
        return jobDao.updateJob(job);
    }
//    // 删除学校
//    public Long deleteJob(int id){
//        return jobDao.deleteJob(id);
//    }

    private Job addAddrName(Job job){
        int schoolId=job.getSchoolId();
        School school = schoolDao.selectById(schoolId);
        job.setAddress(school.getAddress());
        job.setAddressName(school.getAddressName());
        return job;
    }
}
