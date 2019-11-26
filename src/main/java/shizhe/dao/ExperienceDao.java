package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.Experience;

import java.util.List;

@Repository
public interface ExperienceDao {
    // 查询
    Experience selectById(@Param("id") int id);
    List<Experience> selectByCondition(@Param("userId") String userId);

    // 新增
    Long insertExperience(Experience experience);
    // 修改
    Long updateExperience(Experience experience);
    //删除
    Long deleteById(@Param("id") int id);

}