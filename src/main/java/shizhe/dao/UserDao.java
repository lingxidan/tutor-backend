package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.annotation.MyBatisBaseDao;
import shizhe.annotation.MyBatisDao;
import shizhe.bean.Recruiter;
import shizhe.bean.User;
import shizhe.bean.Volunteer;

import java.util.List;

/**
 * UserDAO继承基类
 */
@Repository
public interface UserDao {
    List<User> getAll();
    User login(@Param("name") String name, @Param("password") String password);
    Long registe(User user);
    Long edit(Volunteer volunteer);
    Long editRecruiter(Recruiter recruiter);
}