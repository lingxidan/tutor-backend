package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.PostMsg;

import java.util.List;

/**
 * PostMsgDAO继承基类
 */
@Repository
public interface PostMsgDAO extends MyBatisBaseDao<PostMsg, Integer> {

    List<PostMsg> selectByCondition(@Param("userId") Integer userId,
                                    @Param("mainId") String mainId);
    int deleteByPrimaryKey(Integer id);

    int insert(PostMsg record);

    PostMsg selectByPrimaryKey(Integer id);
}