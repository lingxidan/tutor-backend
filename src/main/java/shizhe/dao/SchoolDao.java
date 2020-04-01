package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.School;

import java.util.List;

/**
 * SchoolDao继承基类
 */
@Repository
public interface SchoolDAO {
    // 查询
    School selectById(@Param("id") int id);
    List<School> selectByCondition(@Param("userId") String userId,
                                   @Param("address") String address,
                                   @Param("keyword") String keyword,
                                   @Param("status") String status);

    // 新增
    Long insertSchool(School school);
    // 修改
    Long updateSchool(School school);
    // 删除学校
    Long deleteSchool(@Param("id") int id);
}