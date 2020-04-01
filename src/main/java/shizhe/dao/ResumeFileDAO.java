package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.ResumeFile;

import java.util.List;

/**
 * ResumeFileDAO继承基类
 */
@Repository
public interface ResumeFileDAO extends MyBatisBaseDao<ResumeFile, Integer> {
    // 查询
    ResumeFile selectById(@Param("id") int id);
    List<ResumeFile> selectByCondition(@Param("userId") String userId);

    // 新增
    Long insertFile(ResumeFile resumeFile);

    Integer deleteFile(@Param("id") int id);
}