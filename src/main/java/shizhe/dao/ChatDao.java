package shizhe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import shizhe.bean.Chat;

import java.util.List;

@Repository
public interface ChatDao {
    List<Chat> selectByFromTo(@Param("fromId") Integer fromId,
                              @Param("toId") Integer toId);

    List<Chat> selectLastChats(@Param("userId") Integer userId);

    int insertChat(Chat record);
}