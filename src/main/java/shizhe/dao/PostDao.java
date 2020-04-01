package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.Post;

import java.util.List;

@Repository
public interface PostDAO {
    // 查询
    Post selectById(@Param("id") int id);
    Long deletePost(@Param("id") int id);
    List<Post> selectByCondition(@Param("userId") String userId,
                                @Param("keyword") String keyword,
                                @Param("establishDt") String establishDt);

    // 新增
    Long insertPost(Post post);
    // 修改
    Long updatePost(Post post);
}