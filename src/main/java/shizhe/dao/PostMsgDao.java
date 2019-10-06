package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.Comment;

import java.util.List;

@Repository
public interface PostMsgDao {

    List<Comment> selectByCondition(@Param("userId") String userId,
                                    @Param("mainId") String mainId);
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateMsg(Comment record);
}