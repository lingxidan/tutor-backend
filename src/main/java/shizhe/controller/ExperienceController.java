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
import shizhe.bean.Experience;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.ExperienceService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/api/experience")
public class ExperienceController {
    @Autowired
    @Resource
    ExperienceService experienceService;

//    @ApiOperation(value = "查看工作经历详情", produces = MediaType.APPLICATION_JSON_VALUE)
//    @GetMapping("/selectById")
//    @ResponseBody
//    public ApiResult selectById(int experienceId){
//        ApiResult<Object> result = new ApiResult<>();
//        Experience experience=experienceService.selectById(experienceId);
//        result.setStatus(StatusCode.SC_SUCCESS);
//        result.setData(experience);
//        return result;
//    }

    @ApiOperation(value = "根据条件筛选工作经历", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectByCondition")
    @ResponseBody
    public ApiResult selectByCondition(String userId){
        ApiResult<Object> result = new ApiResult<>();
        List<Experience> experienceList=experienceService.selectByCondition(userId);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(experienceList);
        return result;
    }

    @ApiOperation(value = "增加工作经历", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/insertExperience")
    @DateTimeFormat(pattern = "yyyyMMdd")
    @ResponseBody
    public ApiResult insertExperience(Experience experience){
        ApiResult<Object> result = new ApiResult<>();
        Long res=experienceService.insertExperience(experience);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "更新工作经历", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/updateExperience")
    @ResponseBody
    public ApiResult updateExperience(Experience experience){
        ApiResult<Object> result = new ApiResult<>();
        Long res=experienceService.updateExperience(experience);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "删除工作经历", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/deleteExperience")
    @ResponseBody
    public ApiResult deleteExperience(int id){
        ApiResult<Object> result = new ApiResult<>();
        Long res=experienceService.deleteById(id);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }
}
