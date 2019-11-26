package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.Recruiter;

/**
 * RecruiterDao继承基类
 */
@Repository
public interface RecruiterDao {

    Long registe(Recruiter recruiter);
    Recruiter getRecruiter(@Param("userId") int userId);
    Integer edit(Recruiter recruiter);
}