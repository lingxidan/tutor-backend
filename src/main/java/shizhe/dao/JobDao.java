package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.Job;

import java.util.List;

@Repository
public interface JobDao {
    // 查询
    Job selectById(@Param("id") int id);
    List<Job> selectByCondition(@Param("userId") String userId,
                                @Param("schoolId") String schoolId,
                                @Param("address") String address,
                                @Param("keyword") String keyword,
                                @Param("education") String education,
                                @Param("establishDt") String establishDt,
                                @Param("status") String status);

    // 新增
    Long insertJob(Job job);
    // 修改
    Long updateJob(Job job);
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(Job record);
//
//    int insertSelective(Job record);
//
//    Job selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(Job record);
//
//    int updateByPrimaryKey(Job record);
}