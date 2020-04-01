package shizhe.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shizhe.bean.Accusation;
import shizhe.bean.Attention;
import shizhe.common.ApiResult;
import shizhe.common.StatusCode;
import shizhe.service.AttentionAccuseService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/api/interest")
public class AttentionAccuseController {
    @Autowired
    @Resource
    AttentionAccuseService attentionAccuseService;

    @ApiOperation(value = "根据条件筛选收藏关注", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectAttentionByCondition")
    @ResponseBody
    public ApiResult selectAttentionByCondition(Integer userId,
                                       Integer collectType, Integer collectId){
        ApiResult<Object> result = new ApiResult<>();
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(attentionAccuseService.selectAttentionByCondition(userId,collectType,collectId));
        return result;
    }

    @ApiOperation(value = "增加收藏关注", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/insertAttention")
    @ResponseBody
    public ApiResult insertAttention(Attention attention){
        ApiResult<Object> result = new ApiResult<>();
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(attentionAccuseService.insertAttention(attention));
        return result;
    }

    @ApiOperation(value = "删除收藏关注", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/deleteAttention")
    @ResponseBody
    public ApiResult deleteAttention(int id){
        ApiResult<Object> result = new ApiResult<>();
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(attentionAccuseService.deleteAttention(id));
        return result;
    }

    @ApiOperation(value = "根据条件筛选举报", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/selectAccuseByCondition")
    @ResponseBody
    public ApiResult selectAccuseByCondition(Integer userId,
                                                Integer accuseType,
                                             Integer accuseId,
                                             Integer accuseResult){
        ApiResult<Object> result = new ApiResult<>();
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(attentionAccuseService.selectAccuseByCondition(userId,accuseType,accuseId,accuseResult));
        return result;
    }

    @ApiOperation(value = "增加举报", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/insertAccuse")
    @ResponseBody
    public ApiResult insertAccuse(Accusation accusation){
        ApiResult<Object> result = new ApiResult<>();
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(attentionAccuseService.insertAccuse(accusation));
        return result;
    }

    @ApiOperation(value = "添加举报结果", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/updateAccuse")
    @ResponseBody
    public ApiResult updateAccuse(Integer id,Integer accuseRes){
        ApiResult<Object> result = new ApiResult<>();
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(attentionAccuseService.updateAccuse(id,accuseRes));
        return result;
    }

    @ApiOperation(value = "取消举报", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/deleteAccuse")
    @ResponseBody
    public ApiResult deleteAccuse(Integer id){
        ApiResult<Object> result = new ApiResult<>();
        result.setStatus(StatusCode.SC_SUCCESS);
        result.setData(attentionAccuseService.deleteAccuse(id));
        return result;
    }
}
