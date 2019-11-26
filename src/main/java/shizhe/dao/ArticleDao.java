package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.Article;

import java.util.List;

@Repository
public interface ArticleDao {
    // 查询
    Article selectById(@Param("id") int id);
    List<Article> selectByCondition(@Param("userId") String userId,
                                @Param("keyword") String keyword,
                                @Param("establishDt") String establishDt,
                                @Param("status") String status);

    // 新增
    Long insertArticle(Article article);
    // 修改
    Long updateArticle(Article article);
}