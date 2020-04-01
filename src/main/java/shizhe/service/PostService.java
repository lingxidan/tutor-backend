package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.Post;
import shizhe.dao.PostDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("PostService")
public class PostService {
    @Autowired
    PostDAO postDao;
    // 查询
    public Post selectById(int id){
        return postDao.selectById(id);
    }
    public List<Post> selectByCondition(String userId,
                                       String keyword,
                                       String establishDt){
        return postDao.selectByCondition(userId,keyword,
                establishDt);
    }

    // 新增
    public Long insertPost(Post post){
        post.setEstablishDt(new Date());
        return postDao.insertPost(post);
    }
    // 修改
    public Long updatePost(Post post){
        return postDao.updatePost(post);
    }
    // 删除学校
    public Long deletePost(int id){
        return postDao.deletePost(id);
    }
}
