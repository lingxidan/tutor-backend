package shizhe.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shizhe.bean.Contact;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.ContactService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/api/contact")
public class ContactController {
    @Autowired
    @Resource
    ContactService contactService;

//    @ApiOperation(value = "查看社交主页详情", produces = MediaType.APPLICATION_JSON_VALUE)
//    @GetMapping("/selectById")
//    @ResponseBody
//    public ApiResult selectById(int contactId){
//        ApiResult<Object> result = new ApiResult<>();
//        Contact contact=contactService.selectById(contactId);
//        result.setStatus(StatusCode.SC_SUCCESS);
//        result.setData(contact);
//        return result;
//    }

    @ApiOperation(value = "根据条件筛选社交主页", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectByCondition")
    @ResponseBody
    public ApiResult selectByCondition(String userId){
        ApiResult<Object> result = new ApiResult<>();
        List<Contact> contactList=contactService.selectByCondition(userId);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(contactList);
        return result;
    }

    @ApiOperation(value = "增加社交主页", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/insertContact")
    @DateTimeFormat(pattern = "yyyyMMdd")
    @ResponseBody
    public ApiResult insertContact(Contact contact){
        ApiResult<Object> result = new ApiResult<>();
        Long res=contactService.insertContact(contact);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }

    @ApiOperation(value = "更新社交主页", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/updateContact")
    @ResponseBody
    public ApiResult updateContact(Contact contact){
        ApiResult<Object> result = new ApiResult<>();
        Long res=contactService.updateContact(contact);
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(res);
        return result;
    }
}
