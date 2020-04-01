package shizhe.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.DatadictService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/datadict")
public class DatadictController {
    @Autowired
    @Resource
    DatadictService datadictService;

    @ApiOperation(value = "导入地址数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/insertAddress")
    public ApiResult insertAddress() throws IOException {

        ApiResult<Object> result = new ApiResult<>();
        Long res = -1L;
        res = datadictService.deleteAddress();
        res = datadictService.insertAddress();
        Map map = new HashMap();
//        List<User> list = userService.getAll();
        result.setStatus(StatusCode.SC_SUCCESS);
        map.put("registeRes",res);
        result.setData(map);
        return result;
    }

    @ApiOperation(value = "获取省市区县", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectAddress")
    public ApiResult selectAddress(int level,String pcode){

        ApiResult<Object> result = new ApiResult<>();
//        Map map = new HashMap();
//        List<User> list = userService.getAll();
        result.setStatus(StatusCode.SC_SUCCESS);
//        map.put("data",);
        result.setData(datadictService.selectAddress(level, pcode));
        return result;
    }

    @ApiOperation(value = "获取省市区县名称", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectAddressByCode")
    public ApiResult selectAddressByCode(String code){

        ApiResult<Object> result = new ApiResult<>();
//        Map map = new HashMap();
//        List<User> list = userService.getAll();
        result.setStatus(StatusCode.SC_SUCCESS);
//        map.put("data",);
        result.setData(datadictService.selectAddressByCode(code));
        return result;
    }

    @ApiOperation(value = "导入工作类型数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/insertJobtype")
    public ApiResult insertJobtype() throws IOException {

        ApiResult<Object> result = new ApiResult<>();
        Long res = -1L;
        res = datadictService.deleteJobType();
        res = datadictService.insertJobtype();
        Map map = new HashMap();
//        List<User> list = userService.getAll();
        result.setStatus(StatusCode.SC_SUCCESS);
        map.put("registeRes",res);
        result.setData(map);
        return result;
    }

    @ApiOperation(value = "获取工作类型", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectJobtype")
    public ApiResult selectJobtype(){

        ApiResult<Object> result = new ApiResult<>();
//        Map map = new HashMap();
//        List<User> list = userService.getAll();
        result.setStatus(StatusCode.SC_SUCCESS);
//        map.put("data",);
        result.setData(datadictService.selectJobtype());
        return result;
    }

    @ApiOperation(value = "导入公司行业数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/insertTrade")
    public ApiResult insertTrade() throws IOException {

        ApiResult<Object> result = new ApiResult<>();
        Long res = -1L;
        res = datadictService.deleteTrade();
        res = datadictService.insertTrade();
        Map map = new HashMap();
//        List<User> list = userService.getAll();
        result.setStatus(StatusCode.SC_SUCCESS);
        map.put("registeRes",res);
        result.setData(map);
        return result;
    }

    @ApiOperation(value = "获取公司行业", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectTrade")
    public ApiResult selectTrade(){

        ApiResult<Object> result = new ApiResult<>();
//        Map map = new HashMap();
//        List<User> list = userService.getAll();
        result.setStatus(StatusCode.SC_SUCCESS);
//        map.put("data",);
        result.setData(datadictService.selectTrade());
        return result;
    }

    @ApiOperation(value = "导入资格证书数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/insertLicense")
    public ApiResult insertLicense() throws IOException {

        ApiResult<Object> result = new ApiResult<>();
        Long res = -1L;
        res = datadictService.deleteLicense();
        res = datadictService.insertLicense();
        Map map = new HashMap();
//        List<User> list = userService.getAll();
        result.setStatus(StatusCode.SC_SUCCESS);
        map.put("registeRes",res);
        result.setData(map);
        return result;
    }

    @ApiOperation(value = "获取资格证书", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectLicense")
    public ApiResult selectLicense(){

        ApiResult<Object> result = new ApiResult<>();
//        Map map = new HashMap();
//        List<User> list = userService.getAll();
        result.setStatus(StatusCode.SC_SUCCESS);
//        map.put("data",);
        result.setData(datadictService.selectLicense());
        return result;
    }
}
