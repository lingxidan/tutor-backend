package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.User;
import shizhe.bean.Volunteer;
import shizhe.bean.Recruiter;

import java.util.List;

/**
 * UserDAO继承基类
 */
@Repository
public interface UserDAO extends MyBatisBaseDao<User, Integer> {
    // 登录
    User login(@Param("name") String name, @Param("password") String password);

    // 注册
    Long registeUser(User user);
    Long registeVolunteer(Volunteer volunteer);
    Long registeRecruiter(Recruiter recruiter);

    // 修改
    Integer editUser(User user);
    Integer editVolunteer(Volunteer volunteer);
    Integer editRecruiter(Recruiter recruiter);

    // 查询列表
    List<Volunteer> selectVols(@Param("address") String address,
                               @Param("education") String education,
                               @Param("status") String status,
                               @Param("certificate") String certificate,
                               @Param("keyword") String keyword);
    List<Recruiter> selectRecrs(@Param("address") String address,
                                @Param("company_name") String companyName);

    // 查询详情
    Volunteer getVolunteer(@Param("userId") int userId);
    Recruiter getRecruiter(@Param("userId") int userId);
    User getUser(@Param("userId") int userId);

}