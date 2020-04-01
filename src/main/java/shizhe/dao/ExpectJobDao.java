package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.ExpectJob;

import java.util.List;

/**
 * ExpectJobDAO继承基类
 */
@Repository
public interface ExpectJobDAO extends MyBatisBaseDao<ExpectJob, Integer> {
    // 查询
    ExpectJob selectById(@Param("id") int id);
    List<ExpectJob> selectByCondition(@Param("userId") String userId);

    // 新增
    Long insertExpectJob(ExpectJob expectJob);
    // 修改
    Long updateExpectJob(ExpectJob expectJob);
    //删除
    Long deleteById(@Param("id") int id);
}