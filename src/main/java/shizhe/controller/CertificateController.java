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
import shizhe.bean.Certificate;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.CertificateService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/api/certificate")
public class CertificateController {
    @Autowired
    @Resource
    CertificateService certificateService;

//    @ApiOperation(value = "查看资格证书详情", produces = MediaType.APPLICATION_JSON_VALUE)
//    @GetMapping("/selectById")
//    @ResponseBody
//    public ApiResult selectById(int certificateId){
//        ApiResult<Object> result = new ApiResult<>();
//        Certificate certificate=certificateService.selectById(certificateId);
//        result.setStatus(StatusCode.SC_SUCCESS);
//        result.setData(certificate);
//        return result;
//    }

    @ApiOperation(value = "根据条件筛选资格证书", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectByCondition")
    @ResponseBody
    public ApiResult selectByCondition(String userId){
        ApiResult<Object> result = new ApiResult<>();
        List<Certificate> certificateList=certificateService.selectByCondition(userId);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(certificateList);
        return result;
    }

    @ApiOperation(value = "增加资格证书", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/insertCertificate")
    @DateTimeFormat(pattern = "yyyyMMdd")
    @ResponseBody
    public ApiResult insertCertificate(Certificate certificate){
        ApiResult<Object> result = new ApiResult<>();
        Long res=certificateService.insertCertificate(certificate);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "更新资格证书", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/updateCertificate")
    @ResponseBody
    public ApiResult updateCertificate(Certificate certificate){
        ApiResult<Object> result = new ApiResult<>();
        Long res=certificateService.updateCertificate(certificate);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }
}
