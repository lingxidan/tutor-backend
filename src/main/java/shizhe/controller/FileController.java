package shizhe.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shizhe.bean.Recruiter;
import shizhe.bean.ResumeFile;
import shizhe.bean.User;
import shizhe.bean.Volunteer;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.FileService;
import shizhe.service.UserService;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/file")
public class FileController {
    @Autowired
    @Resource
    FileService fileService;

    @ApiOperation(value = "上传文件", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/upload")
    @ResponseBody
    public ApiResult uploadFile(@RequestParam("file") MultipartFile file,
                                @RequestParam("userId") int userId) throws IOException {
        ApiResult<Object> result = new ApiResult<>();
        ResumeFile resumeFile = fileService.transformToShow(file);
        if(resumeFile.getStatus()==1) {
            resumeFile.setUserId(userId);
            resumeFile.setUpDt((new SimpleDateFormat("yyyy-MM-dd"/*你想要的格式*/)).format(new Date()));fileService.insertFile(resumeFile);
            result.setStatus(StatusCode.SC_SUCCESS);
            result.setData("成功");
            return result;
        }
        result.setStatus(StatusCode.SC_SYS_ERROR);
        result.setData("失败");
        return result;
    }

    @ApiOperation(value = "筛选文件列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/selectByCondition")
    @ResponseBody
    public ApiResult selectByCondition(@RequestParam("userId") String userId,
                                String upDt){
        ApiResult<Object> result = new ApiResult<>();
        List<ResumeFile> resumeFileList = fileService.selectByCondition(userId, upDt);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(resumeFileList);
        return result;
    }

    @ApiOperation(value = "查看文件详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/selectById")
    @ResponseBody
    public ApiResult selectById(@RequestParam("id") int id){
        ApiResult<Object> result = new ApiResult<>();
        ResumeFile file = fileService.selectById(id);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(file);
        return result;
    }

    @ApiOperation(value = "更新文件状态", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/updateFile")
    @ResponseBody
    public ApiResult updateFile(ResumeFile resumeFile){
        ApiResult<Object> result = new ApiResult<>();
        Long res=fileService.updateFile(resumeFile);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "删除文件", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/deleteFile")
    @ResponseBody
    public ApiResult deleteFile(int id){
        ApiResult<Object> result = new ApiResult<>();
        int res=fileService.deleteFile(id);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }
}
