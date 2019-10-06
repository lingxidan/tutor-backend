package shizhe.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shizhe.bean.ExpectJob;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.ExpectJobService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/api/expectJob")
public class ExpectJobController {
    @Autowired
    @Resource
    ExpectJobService expectJobService;

//    @ApiOperation(value = "查看期望岗位详情", produces = MediaType.APPLICATION_JSON_VALUE)
//    @GetMapping("/selectById")
//    @ResponseBody
//    public ApiResult selectById(int expectJobId){
//        ApiResult<Object> result = new ApiResult<>();
//        ExpectJob expectJob=expectJobService.selectById(expectJobId);
//        result.setStatus(StatusCode.SC_SUCCESS);
//        result.setData(expectJob);
//        return result;
//    }

    @ApiOperation(value = "根据条件筛选期望岗位", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectByCondition")
    @ResponseBody
    public ApiResult selectByCondition(String userId){
        ApiResult<Object> result = new ApiResult<>();
        List<ExpectJob> expectJobList=expectJobService.selectByCondition(userId);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(expectJobList);
        return result;
    }

    @ApiOperation(value = "增加期望岗位", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/insertExpectJob")
    @DateTimeFormat(pattern = "yyyyMMdd")
    @ResponseBody
    public ApiResult insertExpectJob(ExpectJob expectJob){
        ApiResult<Object> result = new ApiResult<>();
        Long res=expectJobService.insertExpectJob(expectJob);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "更新期望岗位", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/updateExpectJob")
    @ResponseBody
    public ApiResult updateExpectJob(ExpectJob expectJob){
        ApiResult<Object> result = new ApiResult<>();
        Long res=expectJobService.updateExpectJob(expectJob);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "删除期望岗位", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/deleteExpectJob")
    @ResponseBody
    public ApiResult deleteExpectJob(int id){
        System.out.println(id);
        ApiResult<Object> result = new ApiResult<>();
        Long res=expectJobService.deleteById(id);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }
}
