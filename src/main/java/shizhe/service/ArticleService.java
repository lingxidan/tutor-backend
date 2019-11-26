package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.Article;
import shizhe.bean.School;
import shizhe.dao.DatadictDao;
import shizhe.dao.ArticleDao;
import shizhe.dao.SchoolDao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("ArticleService")
public class ArticleService {
    @Autowired
    ArticleDao articleDao;
    // 查询
    public Article selectById(int id){
        Article article=articleDao.selectById(id);
//        addAddrName(article);
        return article;
    }
    public List<Article> selectByCondition(String userId,
                                       String keyword,
                                       String establishDt,
                                       String status){
        List<Article> articleList=articleDao.selectByCondition(userId,keyword,
                establishDt,status);
//        articleList.forEach(this::addAddrName);
        return articleList;
    }

    // 新增
    public Long insertArticle(Article article){
        article.setEstablishDt((new SimpleDateFormat("yyyy-MM-dd"/*你想要的格式*/)).format(new Date()));
//        article=addAddrName(article);
        return articleDao.insertArticle(article);
    }
    // 修改
    public Long updateArticle(Article article){
        return articleDao.updateArticle(article);
    }
//    // 删除学校
//    public Long deleteArticle(int id){
//        return articleDao.deleteArticle(id);
//    }

//    private Article addAddrName(Article article){
//        int schoolId=article.getSchoolId();
//        School school = schoolDao.selectById(schoolId);
//        article.setAddress(school.getAddress());
//        article.setAddressName(school.getAddressName());
//        return article;
//    }
}
