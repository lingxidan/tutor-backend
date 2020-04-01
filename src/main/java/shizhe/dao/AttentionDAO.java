package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.Attention;

import java.util.List;

/**
 * CollectionDAO继承基类
 */
@Repository
public interface AttentionDAO extends MyBatisBaseDao<Attention, Integer> {

    List<Attention> selectByCondition(@Param("userId") Integer userId,
                                      @Param("collectType") Integer collectType,
                                      @Param("collectId") Integer collectId);
    int deleteByPrimaryKey(Integer id);

    int insert(Attention record);
}