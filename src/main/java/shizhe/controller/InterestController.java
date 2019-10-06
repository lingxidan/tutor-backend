package shizhe.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shizhe.bean.Interest;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.InterestService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/api/interest")
public class InterestController {
    @Autowired
    @Resource
    InterestService interestService;

    @ApiOperation(value = "根据条件筛选收藏关注", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectByCondition")
    @ResponseBody
    public ApiResult selectByCondition(String userId,
                                       String type){
        ApiResult<Object> result = new ApiResult<>();
        List<Interest> interestList = interestService.selectByCondition(userId,type);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(interestList);
        return result;
    }

    @ApiOperation(value = "增加收藏关注", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/insertInterest")
    @DateTimeFormat(pattern = "yyyyMMdd")
    @ResponseBody
    public ApiResult insertInterest(Interest interest){
        ApiResult<Object> result = new ApiResult<>();
        int res= interestService.insertInterest(interest);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "删除收藏关注", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/deleteInterest")
    @DateTimeFormat(pattern = "yyyyMMdd")
    @ResponseBody
    public ApiResult deleteInterest(int interestId){
        ApiResult<Object> result = new ApiResult<>();
        int res= interestService.deleteInterest(interestId);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }
}
