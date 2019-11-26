package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.Post;
import shizhe.dao.PostDao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("PostService")
public class PostService {
    @Autowired
    PostDao postDao;
    // 查询
    public Post selectById(int id){
        Post post=postDao.selectById(id);
//        addAddrName(post);
        return post;
    }
    public List<Post> selectByCondition(String userId,
                                       String keyword,
                                       String establishDt,
                                       String status){
        List<Post> postList=postDao.selectByCondition(userId,keyword,
                establishDt,status);
//        postList.forEach(this::addAddrName);
        return postList;
    }

    // 新增
    public Long insertPost(Post post){
        post.setEstablishDt((new SimpleDateFormat("yyyy-MM-dd"/*你想要的格式*/)).format(new Date()));
//        post=addAddrName(post);
        return postDao.insertPost(post);
    }
    // 修改
    public Long updatePost(Post post){
        return postDao.updatePost(post);
    }
//    // 删除学校
//    public Long deletePost(int id){
//        return postDao.deletePost(id);
//    }

//    private Post addAddrName(Post post){
//        int schoolId=post.getSchoolId();
//        School school = schoolDao.selectById(schoolId);
//        post.setAddress(school.getAddress());
//        post.setAddressName(school.getAddressName());
//        return post;
//    }
}
