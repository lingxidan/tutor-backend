package shizhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shizhe.bean.Chat;
import shizhe.dao.ChatDAO;
//import shizhe.dao_bak.ChatDao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("ChatService")
public class ChatService {
    @Autowired
    ChatDAO chatDao;
    // 查询
    public List<Chat> selectFromChat(int userId,String dt){
        return chatDao.selectFromChat(userId,dt);
    }
    public List<Chat> selectAllChat(int uesrId){
        return chatDao.selectAllChat(uesrId);
    }

    // 新增
    public int insertChat(Chat chat){
        chat.setDt(new Date());
        return chatDao.insertChat(chat);
    }
}
