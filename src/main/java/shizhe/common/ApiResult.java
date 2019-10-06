package shizhe.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @program: wechat-farm
 * @description: 结果集
 * @author: WUCHAO
 * @create: 2019-05-06
 **/
public class ApiResult<T> implements Serializable {

    @ApiModelProperty(value = "状态码", required = true)
    private int status;
    @ApiModelProperty(value = "状态码信息", required = true)
    private String msg;
    @ApiModelProperty(value = "数据", required = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;


    public ApiResult() {
        setStatus(StatusCode.SC_SUCCESS);
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        this.msg = StatusCode.SC_ARRAY_MESSAGES[status - 1000];
    }

    public String getMsg() {
        return msg;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
