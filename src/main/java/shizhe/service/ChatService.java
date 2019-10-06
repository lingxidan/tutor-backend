package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.Chat;
import shizhe.dao.ChatDao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("ChatService")
public class ChatService {
    @Autowired
    ChatDao chatDao;
    // 查询
    public List<Chat> selectByFromTo(int fromId,int toId){
        return chatDao.selectByFromTo(fromId,toId);
    }
    public List<Chat> selectLastChats(int userId){
        return chatDao.selectLastChats(userId);
    }

    // 新增
    public int insertChat(Chat chat){
        chat.setDt((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"/*你想要的格式*/)).format(new Date()));
        return chatDao.insertChat(chat);
    }
}
