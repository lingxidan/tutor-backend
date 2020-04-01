package shizhe.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shizhe.bean.RecrIdentity;
import shizhe.bean.VolIdentity;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.IdentyService;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/identy")
public class IdentyController {
    @Autowired
    @Resource
    IdentyService identyService;

    @ApiOperation(value = "招募者申请认证", produces = MediaType.ALL_VALUE)
    @PostMapping("/applyRecrIdenty")
    @ResponseBody
    public ApiResult applyRecrIdenty(@RequestParam("recrId") Integer recrId,
                                     @RequestParam("companyName") String companyName,
                                     @RequestParam("companyPhone") String companyPhone,
                                     @RequestParam("applyName") String applyName,
                                     String applyId,
                                     MultipartFile[] image,
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
        RecrIdentity recrIdentity = new RecrIdentity();
        recrIdentity.setCompanyName(companyName);
        recrIdentity.setCompanyPhone(companyPhone);
        recrIdentity.setApplyName(applyName);
        recrIdentity.setApplyId(applyId);
        recrIdentity.setImage(imageStr.toString());
        recrIdentity.setApplyDt(new Date());
        recrIdentity.setRecrId(recrId);
        recrIdentity.setResult(-1);
        identyService.applyRecrIdenty(recrIdentity);

        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData("成功");
        return result;
    }

    @ApiOperation(value = "招募者申请认证历史", produces = MediaType.ALL_VALUE)
    @GetMapping("/listRecrIdenty")
    @ResponseBody
    public ApiResult listRecrIdenty(@RequestParam("recrId") Integer recrId) {
        ApiResult<Object> result = new ApiResult<>();
        List<RecrIdentity> identities = identyService.selectRecrIdentys(recrId);

        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(identities);
        return result;
    }

    @ApiOperation(value = "所有招募者申请认证历史", produces = MediaType.ALL_VALUE)
    @GetMapping("/listAllRecrIdenty")
    @ResponseBody
    public ApiResult listAllRecrIdenty(@RequestParam("result") Integer result) {
        ApiResult<Object> res = new ApiResult<>();
        List<RecrIdentity> identities = identyService.selectAllRecrIdentys(result);

        res.setStatus(StatusCode.SC_SUCCESS);
        res.setData(identities);
        return res;
    }

    @ApiOperation(value = "招募者申请认证结果", produces = MediaType.ALL_VALUE)
    @GetMapping("/updateRecrIdenty")
    @ResponseBody
    public ApiResult updateRecrIdenty(@RequestParam("id") Integer id,
                                      @RequestParam("describe") String describe,
                                      @RequestParam("result") Integer result) throws IOException {
        ApiResult<Object> resultRes = new ApiResult<>();
        Boolean res = identyService.updateRecrIdenty(id, describe, result);

        resultRes.setStatus(StatusCode.SC_SUCCESS);
        resultRes.setData(res);
        return resultRes;
    }

    @ApiOperation(value = "招募者最新认证", produces = MediaType.ALL_VALUE)
    @GetMapping("/getLasrRecrIdenty")
    @ResponseBody
    public ApiResult getLasrRecrIdenty(@RequestParam("recrId") Integer recrId){
        ApiResult<Object> result = new ApiResult<>();
        RecrIdentity recrIdentity = identyService.getLasrRecrIdenty(recrId);

        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(recrIdentity);
        return result;
    }

    @ApiOperation(value = "志愿者申请认证", produces = MediaType.ALL_VALUE)
    @PostMapping("/applyVolIdenty")
    @ResponseBody
    public ApiResult applyVolIdenty(VolIdentity volIdentitySrc,
                                     String applyId,
                                     MultipartFile[] image,
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
        VolIdentity volIdentity = new VolIdentity();
        volIdentity.setApplyStartdt(volIdentitySrc.getApplyStartdt());
        volIdentity.setApplyEnddt(volIdentitySrc.getApplyEnddt());
        volIdentity.setApplyId(applyId);
        volIdentity.setImg(imageStr.toString());
        volIdentity.setApplyDt(new Date());
        volIdentity.setVolId(volIdentitySrc.getVolId());
        volIdentity.setResult(-1);
        identyService.applyVolIdenty(volIdentity);

        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData("成功");
        return result;
    }

    @ApiOperation(value = "志愿者申请认证历史", produces = MediaType.ALL_VALUE)
    @GetMapping("/listVolIdenty")
    @ResponseBody
    public ApiResult listVolIdenty(@RequestParam("volId") Integer volId) {
        ApiResult<Object> result = new ApiResult<>();
        List<VolIdentity> identities = identyService.selectVolIdentys(volId);

        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(identities);
        return result;
    }

    @ApiOperation(value = "所有志愿者申请认证历史", produces = MediaType.ALL_VALUE)
    @GetMapping("/listAllVolIdenty")
    @ResponseBody
    public ApiResult listAllVolIdenty(Integer result) {
        ApiResult<Object> res = new ApiResult<>();
        res.setStatus(StatusCode.SC_SUCCESS);
        res.setData(identyService.selectAllVolIdentys(result));
        return res;
    }

    @ApiOperation(value = "志愿者申请认证结果", produces = MediaType.ALL_VALUE)
    @GetMapping("/updateVolIdenty")
    @ResponseBody
    public ApiResult updateVolIdenty(@RequestParam("id") Integer id,
                                      @RequestParam("describe") String describe,
                                      @RequestParam("result") Integer result){
        ApiResult<Object> resultRes = new ApiResult<>();
        Boolean res = identyService.updateVolIdenty(id, describe, result);

        resultRes.setStatus(StatusCode.SC_SUCCESS);
        resultRes.setData(res);
        return resultRes;
    }

    @ApiOperation(value = "志愿者最新认证", produces = MediaType.ALL_VALUE)
    @GetMapping("/getLasrVolIdenty")
    @ResponseBody
    public ApiResult getLasrVolIdenty(@RequestParam("volId") Integer volId){
        ApiResult<Object> result = new ApiResult<>();
        VolIdentity volIdentity = identyService.getLasrVolIdenty(volId);

        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(volIdentity);
        return result;
    }
}
