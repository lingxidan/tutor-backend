package shizhe.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shizhe.bean.Article;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.ArticleService;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    @Resource
    ArticleService articleService;

    @ApiOperation(value = "删除文章", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/deleteArticle")
    @ResponseBody
    public ApiResult deleteArticle(int articleId){
        ApiResult<Object> result = new ApiResult<>();
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(articleService.deleteArticle(articleId));
        return result;
    }

    @ApiOperation(value = "查看文章详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectById")
    @ResponseBody
    public ApiResult selectById(int articleId){
        ApiResult<Object> result = new ApiResult<>();
        Article article=articleService.selectById(articleId);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(article);
        return result;
    }

    @ApiOperation(value = "根据条件筛选文章", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectByCondition")
    @ResponseBody
    public ApiResult selectByCondition(String userId,
                                       String keyword,
                                       String establishDt){
        ApiResult<Object> result = new ApiResult<>();
        List<Article> articleList=articleService.selectByCondition(userId,keyword,
                establishDt);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(articleList);
        return result;
    }

    @ApiOperation(value = "增加文章", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/insertArticle")
    @ResponseBody
    public ApiResult insertArticle(Article article, MultipartFile[] image,
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
        article.setImgs(imageStr.toString());
        Long res=articleService.insertArticle(article);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "更新文章", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/updateArticle")
    @ResponseBody
    public ApiResult updateArticle(Article article, MultipartFile[] image,
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
        String imgs = article.getImgs();
        imgs = imgs.substring(1, imgs.length()-1);

        if(!"".equals(imgs)){
            String[] beforeImgs = imgs.split(",");
            imageAfter.addAll(Arrays.asList(beforeImgs));
        }
        imageAfter.addAll(imageStr);

        article.setImgs(imageAfter.toString());
        Long res=articleService.updateArticle(article);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }
}
