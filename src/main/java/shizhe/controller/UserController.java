package shizhe.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shizhe.bean.RecrIdentity;
import shizhe.bean.Recruiter;
import shizhe.bean.User;
import shizhe.bean.Volunteer;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.UserService;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        int res = userService.registeVolunteer(user);
        result.setStatus(StatusCode.SC_SUCCESS);
        JSONObject object=new JSONObject();
        object.put("userId", res);
        object.put("userType", 1);
        result.setData(object);
        return result;
    }

    @ApiOperation(value = "注册招募者", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/registeRecruiter")
    @ResponseBody
    public ApiResult registeRecruiter(Recruiter user){
        ApiResult<Object> result = new ApiResult<>();
        user.setUserType(2);
        user.setRegsitedt(new Date());
        int res = userService.registeRecuiter(user);
        result.setStatus(StatusCode.SC_SUCCESS);
        JSONObject object=new JSONObject();
        object.put("userId", res);
        object.put("userType", 2);
        result.setData(object);
        return result;
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
    @GetMapping("/editRecruiter")
    @ResponseBody
    public ApiResult editRecruiter(Recruiter recruiter) throws CloneNotSupportedException {
        ApiResult<Object> result = new ApiResult<>();
        Boolean res = userService.editRecruiter(recruiter);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "获取所有招募者", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/getRecrs")
    @ResponseBody
    public ApiResult getRecrs(String address,
                              String companyName){
        ApiResult<Object> result = new ApiResult<>();
        List<Recruiter> list = userService.getRecrs(address, companyName);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(list);
        return result;
    }

    @ApiOperation(value = "获取所有志愿者", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/getVols")
    @ResponseBody
    public ApiResult getVols(String address,
                             String education,
                             String status,
                             String certificate,
                             String keyword){
        ApiResult<Object> result = new ApiResult<>();
        List<Volunteer> list = userService.getVols(address, education, status, certificate, keyword);
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
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(volunteer);
        return result;
    }

    @ApiOperation(value = "修改志愿者", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/editVolunteer")
    @ResponseBody
    public ApiResult editVolunteer(Volunteer volunteer) throws CloneNotSupportedException {
        ApiResult<Object> result = new ApiResult<>();
        Boolean res = userService.editVolunteer(volunteer);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
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

    @ApiOperation(value = "招募者申请认证", produces = MediaType.ALL_VALUE)
    @PostMapping("/applyRecrIdenty")
    @ResponseBody
    public ApiResult applyRecrIdenty(@RequestParam("recrId") Integer recrId,
                                     @RequestParam("companyName") String companyName,
                                     @RequestParam("companyPhone") String companyPhone,
                                     @RequestParam("applyName") String applyName,
                                     @RequestParam("applyId") String applyId,
                                     @RequestParam("image") MultipartFile[] image) throws IOException {
        ApiResult<Object> result = new ApiResult<>();
        File directory = new File(".");
        String filePath = directory.getAbsolutePath() + "/upload/";
        File tmpFile = new File(filePath);
        //判断是否存在该文件夹，若不存在则创建文件夹
        if(!tmpFile.exists()){
            tmpFile.mkdir();
        }

        ArrayList<String> imageStr = new ArrayList<>();
        for(MultipartFile file:image){
            System.out.println(filePath+file.getOriginalFilename());
            // 保存图片
            file.transferTo(new File(filePath+file.getOriginalFilename()));
            imageStr.add(filePath+file.getOriginalFilename());
        }
        RecrIdentity recrIdentity = new RecrIdentity();
        recrIdentity.setCompanyName(companyName);
        recrIdentity.setCompanyPhone(companyPhone);
        recrIdentity.setApplyName(applyName);
        recrIdentity.setApplyId(applyId);
        recrIdentity.setImage(imageStr.toString());
        recrIdentity.setApplyDt(new Date());
        recrIdentity.setRecrId(recrId);
        recrIdentity.setResult(-1);
        userService.applyRecrIdenty(recrIdentity);

        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData("成功");
        return result;
    }

    @ApiOperation(value = "获取用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/getUser")
    @ResponseBody
    public ApiResult getUser(int userId){
        ApiResult<Object> result = new ApiResult<>();
//        System.out.println(volunteer.toString());
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(userService.getUser(userId));
        return result;
    }
}
