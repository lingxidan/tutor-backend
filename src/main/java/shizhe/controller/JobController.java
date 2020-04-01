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
import shizhe.bean.Job;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.JobService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/api/job")
public class JobController {
    @Autowired
    @Resource
    JobService jobService;

    @ApiOperation(value = "查看招募岗位详情", produces = MediaType.ALL_VALUE)
    @GetMapping("/selectById")
    @ResponseBody
    public ApiResult selectById(int jobId){
        ApiResult<Object> result = new ApiResult<>();
        Job job=jobService.selectById(jobId);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(job);
        return result;
    }

    @ApiOperation(value = "查看招募岗位详情", produces = MediaType.ALL_VALUE)
    @GetMapping("/deleteJob")
    @ResponseBody
    public ApiResult deleteJob(int jobId){
        ApiResult<Object> result = new ApiResult<>();
        int res=jobService.deleteJob(jobId);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "根据条件筛选招募岗位", produces = MediaType.ALL_VALUE)
    @GetMapping("/selectByCondition")
    @ResponseBody
    public ApiResult selectByCondition(String userId,
                                       String schoolId,
                                       String address,
                                       String keyword,
                                       String education,
                                       String status){
        ApiResult<Object> result = new ApiResult<>();
        List<Job> jobList=jobService.selectByCondition(userId,schoolId,address,keyword,
                education,status);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(jobList);
        return result;
    }

    @ApiOperation(value = "增加招募岗位", produces = MediaType.ALL_VALUE)
    @PostMapping("/insertJob")
    @ResponseBody
    public ApiResult insertJob(Job job){
        ApiResult<Object> result = new ApiResult<>();
        Long res=jobService.insertJob(job);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "更新招募岗位", produces = MediaType.ALL_VALUE)
    @PostMapping("/updateJob")
    @ResponseBody
    public ApiResult updateJob(Job job){
        ApiResult<Object> result = new ApiResult<>();
        Long res=jobService.updateJob(job);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }
}
