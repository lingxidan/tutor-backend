package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.Interest;

import java.util.List;

@Repository
public interface InterestDao {

    List<Interest> selectByCondition(@Param("userId") String userId,
                                     @Param("type") String type);
    int deleteByPrimaryKey(Integer id);

    int insert(Interest record);
}