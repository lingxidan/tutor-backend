package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.Accusation;

import java.util.List;

/**
 * AccusationDAO继承基类
 */
@Repository
public interface AccusationDAO extends MyBatisBaseDao<Accusation, Integer> {

    List<Accusation> selectByCondition(@Param("userId") Integer userId,
                                       @Param("accuseType") Integer accuseType,
                                       @Param("accuseId") Integer accuseId,
                                       @Param("accuseResult") Integer accuseResult);
    int update(@Param("id") Integer id,
               @Param("accuseResult") Integer accuseResult);

    int insert(Accusation record);
    int deleteByPrimaryKey(Integer id);
}