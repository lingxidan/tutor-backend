package shizhe.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shizhe.bean.Volunteer;
import shizhe.service.UserService;
import shizhe.service.VolunteerService;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/volunteer")
public class VolunteerController {

    VolunteerService volunteerService;

//    @ApiOperation(value = "注册志愿者", produces = MediaType.APPLICATION_JSON_VALUE)
//    @GetMapping("/registe")
//    @ResponseBody
//    public Map<String,Object> registe(Volunteer volunteer) throws IOException {
//        volunteer.setRegsitedt(new Date());
//        Long res = volunteerService.registe(volunteer);
//        Map map = new HashMap();
//
//        map.put("registeRes",res);
//        map.put("status",1);
//        map.put("success",true);
//        return map;
//    }
}
