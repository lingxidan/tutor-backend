package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.Interest;
import shizhe.bean.Volunteer;

/**
 * VolunteerDao继承基类
 */
@Repository
public interface VolunteerDao{
    Long registe(Volunteer volunteer);
    Volunteer getVolunteer(@Param("userId") int userId);
    Integer edit(Volunteer volunteer);
}