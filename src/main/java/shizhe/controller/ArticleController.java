package shizhe.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shizhe.bean.Article;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.ArticleService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    @Resource
    ArticleService articleService;

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
                                       String establishDt,
                                       String status){
        ApiResult<Object> result = new ApiResult<>();
        List<Article> articleList=articleService.selectByCondition(userId,keyword,
                establishDt,status);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(articleList);
        return result;
    }

    @ApiOperation(value = "增加文章", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/insertArticle")
    @DateTimeFormat(pattern = "yyyyMMdd")
    @ResponseBody
    public ApiResult insertArticle(Article article){
        ApiResult<Object> result = new ApiResult<>();
        Long res=articleService.insertArticle(article);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "更新文章", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/updateArticle")
    @DateTimeFormat(pattern = "yyyyMMdd")
    @ResponseBody
    public ApiResult updateArticle(Article article){
        ApiResult<Object> result = new ApiResult<>();
        Long res=articleService.updateArticle(article);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }
}
