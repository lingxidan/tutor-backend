package shizhe.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shizhe.bean.Post;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.PostService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    @Resource
    PostService postService;

    @ApiOperation(value = "查看帖子详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectById")
    @ResponseBody
    public ApiResult selectById(int postId){
        ApiResult<Object> result = new ApiResult<>();
        Post post=postService.selectById(postId);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(post);
        return result;
    }

    @ApiOperation(value = "根据条件筛选帖子", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectByCondition")
    @ResponseBody
    public ApiResult selectByCondition(String userId,
                                       String keyword,
                                       String establishDt,
                                       String status){
        ApiResult<Object> result = new ApiResult<>();
        List<Post> postList=postService.selectByCondition(userId,keyword,
                establishDt,status);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(postList);
        return result;
    }

    @ApiOperation(value = "增加帖子", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/insertPost")
    @DateTimeFormat(pattern = "yyyyMMdd")
    @ResponseBody
    public ApiResult insertPost(Post post){
        ApiResult<Object> result = new ApiResult<>();
        Long res=postService.insertPost(post);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "更新帖子", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/updatePost")
    @DateTimeFormat(pattern = "yyyyMMdd")
    @ResponseBody
    public ApiResult updatePost(Post post){
        ApiResult<Object> result = new ApiResult<>();
        Long res=postService.updatePost(post);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }
}
