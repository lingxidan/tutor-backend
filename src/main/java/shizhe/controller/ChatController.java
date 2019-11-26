package shizhe.controller;

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

    @ApiOperation(value = "查看发送者以及接受者之间的消息", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectByFromTo")
    @ResponseBody
    public ApiResult selectByFromTo(int fromId,int toId){
        ApiResult<Object> result = new ApiResult<>();
        List<Chat> chatList=chatService.selectByFromTo(fromId,toId);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(chatList);
        return result;
    }

    @ApiOperation(value = "查看某个接受者的所有发送者新消息", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectLastChats")
    @ResponseBody
    public ApiResult selectLastChats(int userId){
        ApiResult<Object> result = new ApiResult<>();
        List<Chat> chatList=chatService.selectLastChats(userId);
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
