package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.VolEducation;

import java.util.List;

@Repository
public interface VolEducationDao {
    // 查询
    VolEducation selectById(@Param("id") int id);
    List<VolEducation> selectByCondition(@Param("userId") String userId);

    // 新增
    Long insertVolEducation(VolEducation volEducation);
    // 修改
    Long updateVolEducation(VolEducation volEducation);
    //删除
    Long deleteById(@Param("id") int id);

}