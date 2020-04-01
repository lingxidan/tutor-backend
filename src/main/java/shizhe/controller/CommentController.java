package shizhe.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shizhe.bean.ArticleMsg;
import shizhe.bean.PostMsg;
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
    @GetMapping("/selectCommentById")
    @ResponseBody
    public ApiResult selectCommentById(Integer commentId,Integer type){
        ApiResult<Object> result = new ApiResult<>();
        if(type == 1){
            result.setData(commentService.selectArticleCommentById(commentId));
        }
        if(type == 2){
            result.setData(commentService.selectPostCommentById(commentId));
        }
        result.setStatus(StatusCode.SC_SUCCESS);
        return result;
    }

    @ApiOperation(value = "根据条件筛选评论", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectByCondition")
    @ResponseBody
    public ApiResult selectByCondition(Integer userId,
                                       String mainId,
                                       Integer type){
        ApiResult<Object> result = new ApiResult<>();
        if(type == 1){
            result.setData(commentService.selectArticleCommentByCondition(userId,mainId));
        }
        if(type == 2){
            result.setData(commentService.selectPostCommentByCondition(userId,mainId));
        }
        result.setStatus(StatusCode.SC_SUCCESS);
        return result;
    }

    @ApiOperation(value = "增加文章评论", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/insertArticleComment")
    @ResponseBody
    public ApiResult insertArticleComment(ArticleMsg comment){
        ApiResult<Object> result = new ApiResult<>();
        result.setData(commentService.insertArticleComment(comment));
        result.setStatus(StatusCode.SC_SUCCESS);
        return result;
    }


    @ApiOperation(value = "增加帖子评论", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/insertPostComment")
    @ResponseBody
    public ApiResult insertPostComment(PostMsg comment){
        ApiResult<Object> result = new ApiResult<>();
        result.setData(commentService.insertPostComment(comment));
        result.setStatus(StatusCode.SC_SUCCESS);
        return result;
    }

    @ApiOperation(value = "删除评论", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/deleteComment")
    @ResponseBody
    public ApiResult updateComment(Integer id,Integer type){
        ApiResult<Object> result = new ApiResult<>();
        if(type == 1){
            result.setData(commentService.deleteArticleComment(id));
        }
        if(type == 2){
            result.setData(commentService.deletePostComment(id));
        }
        result.setStatus(StatusCode.SC_SUCCESS);
        return result;
    }
}
