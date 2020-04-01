package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.Chat;

import java.util.List;

/**
 * ChatDAO继承基类
 */
@Repository
public interface ChatDAO extends MyBatisBaseDao<Chat, Integer> {
    List<Chat> selectFromChat(@Param("userId") Integer userId,
                              @Param("dt") String dt);
    List<Chat> selectAllChat(@Param("userId") Integer userId);

    int insertChat(Chat record);
}