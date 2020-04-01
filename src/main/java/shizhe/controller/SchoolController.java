package shizhe.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shizhe.bean.School;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.SchoolService;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/api/school")
public class SchoolController {
    @Autowired
    @Resource
    SchoolService schoolService;

    @ApiOperation(value = "查看学校详情", produces = MediaType.ALL_VALUE)
    @GetMapping("/selectById")
    @ResponseBody
    public ApiResult selectById(int schoolId){
        ApiResult<Object> result = new ApiResult<>();
        School school=schoolService.selectById(schoolId);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(school);
        return result;
    }

    @ApiOperation(value = "根据条件筛选学校", produces = MediaType.ALL_VALUE)
    @GetMapping("/selectByCondition")
    @ResponseBody
    public ApiResult selectByCondition(String userId,
                                       String address,
                                       String keyword,
                                       String status){
        ApiResult<Object> result = new ApiResult<>();
        List<School> schoolList=schoolService.selectByCondition(userId,
                address,keyword,status);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(schoolList);
        return result;
    }

    @ApiOperation(value = "增加学校", produces = MediaType.ALL_VALUE)
    @PostMapping("/insertSchool")
    @ResponseBody
    public ApiResult insertSchool(School school, MultipartFile[] image,
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
        school.setImgs(imageStr.toString());
        Long res=schoolService.insertSchool(school);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "更新学校", produces = MediaType.ALL_VALUE)
    @PostMapping("/updateSchool")
    @ResponseBody
    public ApiResult updateSchool(School school, MultipartFile[] image,
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
        String imgs = school.getImgs();
        imgs = imgs.substring(1, imgs.length()-1);

        if(!"".equals(imgs)){
            String[] beforeImgs = imgs.split(",");
            imageAfter.addAll(Arrays.asList(beforeImgs));
        }
        imageAfter.addAll(imageStr);

        school.setImgs(imageAfter.toString());
        Long res=schoolService.updateSchool(school);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }


    @ApiOperation(value = "更新学校", produces = MediaType.ALL_VALUE)
    @GetMapping("/deleteSchool")
    @ResponseBody
    public ApiResult deleteSchool(int schoolId){
        ApiResult<Object> result = new ApiResult<>();
        Long res=schoolService.deleteSchool(schoolId);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }
}
