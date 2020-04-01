package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.Article;

import java.util.List;

@Repository
public interface ArticleDAO {
    // 查询
    Article selectById(@Param("id") int id);
    Long deleteArticle(@Param("id") int id);
    List<Article> selectByCondition(@Param("userId") String userId,
                                @Param("keyword") String keyword,
                                @Param("establishDt") String establishDt);

    // 新增
    Long insertArticle(Article article);
    // 修改
    Long updateArticle(Article article);
}