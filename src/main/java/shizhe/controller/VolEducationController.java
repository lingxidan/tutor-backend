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
import shizhe.bean.VolEducation;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.VolEducationService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/api/volEducation")
public class VolEducationController {
    @Autowired
    @Resource
    VolEducationService volEducationService;
    
    @ApiOperation(value = "根据条件筛选教育经历", produces = MediaType.ALL_VALUE)
    @GetMapping("/selectByCondition")
    @ResponseBody
    public ApiResult selectByCondition(String userId){
        ApiResult<Object> result = new ApiResult<>();
        List<VolEducation> volEducationList=volEducationService.selectByCondition(userId);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(volEducationList);
        return result;
    }

    @ApiOperation(value = "增加教育经历", produces = MediaType.ALL_VALUE)
    @GetMapping("/insertVolEducation")
    @ResponseBody
    public ApiResult insertVolEducation(VolEducation volEducation){
        ApiResult<Object> result = new ApiResult<>();
        Long res=volEducationService.insertVolEducation(volEducation);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "更新教育经历", produces = MediaType.ALL_VALUE)
    @GetMapping("/updateVolEducation")
    @ResponseBody
    public ApiResult updateVolEducation(VolEducation volEducation){
        ApiResult<Object> result = new ApiResult<>();
        Long res=volEducationService.updateVolEducation(volEducation);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "删除教育经历", produces = MediaType.ALL_VALUE)
    @PostMapping("/deleteVolEducation")
    @ResponseBody
    public ApiResult deleteVolEducation(int id){
        ApiResult<Object> result = new ApiResult<>();
        Long res=volEducationService.deleteById(id);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }
}
