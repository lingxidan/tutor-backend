package shizhe.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shizhe.bean.Recruiter;
import shizhe.bean.User;
import shizhe.bean.Volunteer;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.UserService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    @Resource
    UserService userService;

    @ApiOperation(value = "注册志愿者", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/registeVolunteer")
    @ResponseBody
    public ApiResult registeVolunteer(Volunteer user){
        ApiResult<Object> result = new ApiResult<>();
        user.setRegsitedt((new SimpleDateFormat("yyyy-MM-dd"/*你想要的格式*/)).format(new Date()));
        int res = -1;
        res = userService.registeVolunteer(user);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "注册招募者", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/registeRecruiter")
    @ResponseBody
    public ApiResult registeRecruiter(Recruiter user){
        ApiResult<Object> result = new ApiResult<>();
        user.setRegsitedt((new SimpleDateFormat("yyyy-MM-dd"/*你想要的格式*/)).format(new Date()));
        int res = -1;
        res = userService.registeRecuiter(user);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
//        map.put("registeRes",res);
//        map.put("status",1);
//        map.put("success",true);
//        return map;
    }

    @ApiOperation(value = "获取招募者", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/getRecruiter")
    @ResponseBody
    public ApiResult getRecruiter(int userId){
        ApiResult<Object> result = new ApiResult<>();
        Recruiter recruiter = userService.getRecruiter(userId);
//        System.out.println(volunteer.toString());
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(recruiter);
        return result;
    }

    @ApiOperation(value = "修改招募者", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/editRecruiter")
    @ResponseBody
    public ApiResult editRecruiter(Recruiter recruiter){
        ApiResult<Object> result = new ApiResult<>();
        int res = userService.editRecruiter(recruiter);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(recruiter);
        return result;
    }

    @ApiOperation(value = "获取所有用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/getUser")
    @ResponseBody
    public ApiResult getUser(){
        ApiResult<Object> result = new ApiResult<>();
        List<User> list = userService.getAll();
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(list);
        return result;
    }

    @ApiOperation(value = "获取志愿者", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/getVolunteer")
    @ResponseBody
    public ApiResult getVolunteer(int userId){
        ApiResult<Object> result = new ApiResult<>();
        Volunteer volunteer = userService.getVolunteer(userId);
//        System.out.println(volunteer.toString());
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(volunteer);
        return result;
    }

    @ApiOperation(value = "修改志愿者", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/editVolunteer")
    @ResponseBody
    public ApiResult editVolunteer(Volunteer volunteer){
        ApiResult<Object> result = new ApiResult<>();
        int res = userService.editVolunteer(volunteer);
        System.out.println(volunteer.toString());
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(volunteer);
        return result;
    }

    @PostMapping("/login")
    @ResponseBody
    public ApiResult login(String name,String password){
        ApiResult<Object> result = new ApiResult<>();
        User user = userService.login(name,password);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(user);
        return result;
    }
}
