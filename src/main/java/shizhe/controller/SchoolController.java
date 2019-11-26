package shizhe.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shizhe.bean.School;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.SchoolService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/school")
public class SchoolController {
    @Autowired
    @Resource
    SchoolService schoolService;

    @ApiOperation(value = "查看学校详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectById")
    @ResponseBody
    public ApiResult selectById(int schoolId){
        ApiResult<Object> result = new ApiResult<>();
        School school=schoolService.selectById(schoolId);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(school);
        return result;
    }

    @ApiOperation(value = "根据条件筛选学校", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectByCondition")
    @ResponseBody
    public ApiResult selectByCondition(String userId,String scale,
                                       String address,
                                       String keyword,
                                       String status){
        ApiResult<Object> result = new ApiResult<>();
        List<School> schoolList=schoolService.selectByCondition(userId,scale,
                address,keyword,status);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(schoolList);
        return result;
    }

    @ApiOperation(value = "增加学校", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/insertSchool")
    @DateTimeFormat(pattern = "yyyyMMdd")
    @ResponseBody
    public ApiResult insertSchool(School school){
        ApiResult<Object> result = new ApiResult<>();
        Long res=schoolService.insertSchool(school);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "更新学校", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/updateSchool")
    @DateTimeFormat(pattern = "yyyyMMdd")
    @ResponseBody
    public ApiResult updateSchool(School school){
        ApiResult<Object> result = new ApiResult<>();
        Long res=schoolService.updateSchool(school);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }


    @ApiOperation(value = "更新学校", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/deleteSchool")
    @DateTimeFormat(pattern = "yyyyMMdd")
    @ResponseBody
    public ApiResult deleteSchool(int schoolId){
        ApiResult<Object> result = new ApiResult<>();
        Long res=schoolService.deleteSchool(schoolId);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }
}
