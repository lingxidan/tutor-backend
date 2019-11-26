package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.ResumeFile;

import java.util.List;

@Repository
public interface FileDao {
    // 查询
    ResumeFile selectById(@Param("id") int id);
    List<ResumeFile> selectByCondition(@Param("userId") String userId,
                                @Param("upDt") String upDt);

    // 新增
    Long insertFile(ResumeFile resumeFile);
    // 修改
    Long updateFile(ResumeFile resumeFile);

    Integer deleteFile(@Param("id") int id);

//    int deleteByPrimaryKey(Integer id);
//
//    int insert(ResumeFile record);
//
//    int insertSelective(ResumeFile record);
//
//    ResumeFile selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(ResumeFile record);
//
//    int updateByPrimaryKey(ResumeFile record);
}