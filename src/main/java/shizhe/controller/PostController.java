package shizhe.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shizhe.bean.Post;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.PostService;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    @Resource
    PostService postService;

    @ApiOperation(value = "删除帖子", produces = MediaType.ALL_VALUE)
    @GetMapping("/deletePost")
    @ResponseBody
    public ApiResult deletePost(int postId){
        ApiResult<Object> result = new ApiResult<>();
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(postService.deletePost(postId));
        return result;
    }

    @ApiOperation(value = "查看帖子详情", produces = MediaType.ALL_VALUE)
    @GetMapping("/selectById")
    @ResponseBody
    public ApiResult selectById(int postId){
        ApiResult<Object> result = new ApiResult<>();
        Post post=postService.selectById(postId);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(post);
        return result;
    }

    @ApiOperation(value = "根据条件筛选帖子", produces = MediaType.ALL_VALUE)
    @GetMapping("/selectByCondition")
    @ResponseBody
    public ApiResult selectByCondition(String userId,
                                       String keyword,
                                       String establishDt){
        ApiResult<Object> result = new ApiResult<>();
        List<Post> postList=postService.selectByCondition(userId,keyword,
                establishDt);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(postList);
        return result;
    }

    @ApiOperation(value = "增加帖子", produces = MediaType.ALL_VALUE)
    @PostMapping("/insertPost")
    @ResponseBody
    public ApiResult insertPost(Post post, MultipartFile[] image,
                                @RequestParam("frontPath") String frontPath) throws IOException {
        ApiResult<Object> result = new ApiResult<>();
        File tmpFile = new File(frontPath);
        //判断是否存在该文件夹，若不存在则创建文件夹
        if(!tmpFile.exists()){
            tmpFile.mkdir();
        }

        ArrayList<String> imageStr = new ArrayList<>();
        for(MultipartFile file:image){
            String path = frontPath + file.getOriginalFilename().replace(",","");
            // 保存图片
            file.transferTo(new File(path));
            imageStr.add(path);
        }
        post.setImgs(imageStr.toString());
        Long res=postService.insertPost(post);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "更新帖子", produces = MediaType.ALL_VALUE)
    @PostMapping("/updatePost")
    @ResponseBody
    public ApiResult updatePost(Post post, MultipartFile[] image,
                                @RequestParam("frontPath") String frontPath) throws IOException {
        ApiResult<Object> result = new ApiResult<>();

        // 新的图片列表
        ArrayList<String> imageStr = new ArrayList<>();
        for(MultipartFile file:image){
            String path = frontPath + file.getOriginalFilename().replace(",","");
            // 保存图片
            file.transferTo(new File(path));
            imageStr.add(path);
        }
        // 之前的图片列表
        ArrayList<String> imageAfter = new ArrayList<>();
        String imgs = post.getImgs();
        imgs = imgs.substring(1, imgs.length()-1);

        if(!"".equals(imgs)){
            String[] beforeImgs = imgs.split(",");
            imageAfter.addAll(Arrays.asList(beforeImgs));
        }
        imageAfter.addAll(imageStr);

        post.setImgs(imageAfter.toString());
        Long res=postService.updatePost(post);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }
}
