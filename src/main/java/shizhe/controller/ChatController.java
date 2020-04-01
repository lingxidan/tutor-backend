package shizhe.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shizhe.bean.Chat;
import shizhe.common.ApiResult;
import shizhe.common.DateUtils;
import shizhe.common.StatusCode;
import shizhe.service.ChatService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/api/chat")
public class ChatController {
    @Autowired
    @Resource
    ChatService chatService;

    @ApiOperation(value = "查看发送者和某个接受者之间的消息", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectByFromTo")
    @ResponseBody
    public ApiResult selectFromChat(int userId,String dt){
        ApiResult<Object> result = new ApiResult<>();
        List<Chat> chatList=chatService.selectFromChat(userId,dt);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(chatList);
        return result;
    }

    @ApiOperation(value = "获取所有发出或者收到的消息", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectAllChat")
    @ResponseBody
    public ApiResult selectAllChat(int uesrId){
        ApiResult<Object> result = new ApiResult<>();
        List<Chat> chatList=chatService.selectAllChat(uesrId);
//        chatList.forEach(chat -> {
//            chat.setDt(DateUtils.formatDateTime(chat.getDt()));
//        });
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(chatList);
        return result;
    }

    @ApiOperation(value = "发送聊天", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/insertChat")
    @ResponseBody
    public ApiResult insertChat(Chat chat){
        ApiResult<Object> result = new ApiResult<>();
        int res=chatService.insertChat(chat);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }
}
