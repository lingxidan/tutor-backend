package shizhe.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shizhe.bean.Recruiter;
import shizhe.service.RecruiterService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/recruiter")
public class RecruiterController {
    RecruiterService recruiterService;
//    @ApiOperation(value = "注册招募者", produces = MediaType.APPLICATION_JSON_VALUE)
//    @GetMapping("/registe")
//    @ResponseBody
//    public Map<String,Object> registe(Recruiter recruiter){
//        recruiter.setRegsitedt(new Date());
//        Long res = recruiterService.registe(recruiter);
//        Map map = new HashMap();
////        List<User> list = userService.getAll();
//        map.put("registeRes",res);
//        map.put("status",1);
//        map.put("success",true);
//        return map;
//    }
}
