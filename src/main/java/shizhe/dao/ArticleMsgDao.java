package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.ArticleMsg;

import java.util.List;

/**
 * ArticleMsgDAO继承基类
 */
@Repository
public interface ArticleMsgDAO extends MyBatisBaseDao<ArticleMsg, Integer> {

    List<ArticleMsg> selectByCondition(@Param("userId") Integer userId,
                                       @Param("mainId") String mainId);
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleMsg record);

    ArticleMsg selectByPrimaryKey(Integer id);
}