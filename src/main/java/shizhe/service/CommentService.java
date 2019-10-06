package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.Comment;
import shizhe.dao.ArticleMsgDao;
import shizhe.dao.PostMsgDao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("CommentService")
public class CommentService {
    @Autowired
    ArticleMsgDao articleMsgDao;
    @Autowired
    PostMsgDao postMsgDao;
    // 查询
    public Comment selectById(int id,int type){
        Comment comment=new Comment();
        if(type==1){
            return articleMsgDao.selectByPrimaryKey(id);
        }
        if(type==2){
            return postMsgDao.selectByPrimaryKey(id);
        }
        return comment;
    }
    public List<Comment> selectByCondition(String userId,
                                       String mainId,
                                       int type){
        List<Comment> commentList=new ArrayList<>();
        if(type==1){
            return articleMsgDao.selectByCondition(userId,mainId);
        }
        if(type==2){
            return postMsgDao.selectByCondition(userId,mainId);
        }
        return commentList;
    }

    // 新增
    public Integer insertComment(Comment comment){
        comment.setDt((new SimpleDateFormat("yyyy-MM-dd"/*你想要的格式*/)).format(new Date()));
        if(comment.getType()==1){
            return articleMsgDao.insert(comment);
        }
        if(comment.getType()==2){
            return postMsgDao.insert(comment);
        }
        return -1;
    }
    // 修改
    public int updateComment(Comment comment){
        if(comment.getType()==1){
            return articleMsgDao.updateMsg(comment);
        }
        if(comment.getType()==2){
            return postMsgDao.updateMsg(comment);
        }
        return -1;
    }
}
