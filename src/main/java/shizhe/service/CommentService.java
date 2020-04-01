package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.ArticleMsg;
import shizhe.bean.PostMsg;
import shizhe.dao.ArticleMsgDAO;
import shizhe.dao.PostMsgDAO;
//import shizhe.dao_bak.ArticleMsgDao;
//import shizhe.dao_bak.PostMsgDao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("CommentService")
public class CommentService {
    @Autowired
    ArticleMsgDAO articleMsgDao;
    @Autowired
    PostMsgDAO postMsgDao;
    // 查询
    public ArticleMsg selectArticleCommentById(Integer id){
        return articleMsgDao.selectByPrimaryKey(id);
    }

    public List<ArticleMsg> selectArticleCommentByCondition(Integer userId,
                                       String mainId){
        return articleMsgDao.selectByCondition(userId,mainId);
    }

    // 新增
    public Integer insertArticleComment(ArticleMsg comment){
        comment.setDt(new Date());
        return articleMsgDao.insert(comment);
    }
    // 删除
    public int deleteArticleComment(Integer id){
        return articleMsgDao.deleteByPrimaryKey(id);
    }
    // 查询
    public PostMsg selectPostCommentById(Integer id){
        return postMsgDao.selectByPrimaryKey(id);
    }

    public List<PostMsg> selectPostCommentByCondition(Integer userId,
                                                            String mainId){
        return postMsgDao.selectByCondition(userId,mainId);
    }

    // 新增
    public Integer insertPostComment(PostMsg comment){
        comment.setDt(new Date());
        return postMsgDao.insert(comment);
    }
    // 删除
    public int deletePostComment(Integer id){
        return postMsgDao.deleteByPrimaryKey(id);
    }
}
