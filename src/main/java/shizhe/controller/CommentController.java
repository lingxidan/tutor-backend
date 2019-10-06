package shizhe.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shizhe.bean.Comment;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.CommentService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    @Resource
    CommentService commentService;

    @ApiOperation(value = "查看评论详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectById")
    @ResponseBody
    public ApiResult selectById(int commentId,int type){
        ApiResult<Object> result = new ApiResult<>();
        Comment comment=commentService.selectById(commentId,type);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(comment);
        return result;
    }

    @ApiOperation(value = "根据条件筛选评论", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectByCondition")
    @ResponseBody
    public ApiResult selectByCondition(String userId,
                                       String mainId,
                                       int type){
        ApiResult<Object> result = new ApiResult<>();
        List<Comment> commentList=commentService.selectByCondition(userId,mainId,
                type);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(commentList);
        return result;
    }

    @ApiOperation(value = "增加评论", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/insertComment")
    @DateTimeFormat(pattern = "yyyyMMdd")
    @ResponseBody
    public ApiResult insertComment(Comment comment){
        ApiResult<Object> result = new ApiResult<>();
        int res=commentService.insertComment(comment);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "更新评论", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/updateComment")
    @DateTimeFormat(pattern = "yyyyMMdd")
    @ResponseBody
    public ApiResult updateComment(Comment comment){
        ApiResult<Object> result = new ApiResult<>();
        int res=commentService.updateComment(comment);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }
}
