package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.Article;
import shizhe.dao.ArticleDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("ArticleService")
public class ArticleService {
    @Autowired
    ArticleDAO articleDao;
    // 查询
    public Article selectById(int id){
        return articleDao.selectById(id);
    }
    public List<Article> selectByCondition(String userId,
                                       String keyword,
                                       String establishDt){
        return articleDao.selectByCondition(userId,keyword,
                establishDt);
    }

    // 新增
    public Long insertArticle(Article article){
        article.setEstablishDt(new Date());
        return articleDao.insertArticle(article);
    }
    // 修改
    public Long updateArticle(Article article){
        return articleDao.updateArticle(article);
    }
    // 删除学校
    public Long deleteArticle(int id){
        return articleDao.deleteArticle(id);
    }

}
