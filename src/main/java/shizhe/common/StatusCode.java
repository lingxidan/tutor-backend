package shizhe.common;

/**
 * @program: wechat-farm
 * @description: 状态码
 * @author: WUCHAO
 * @create: 2019-05-06
 **/
public class StatusCode {
    public final static int SC_SUCCESS = 1000; //成功
    public final static int SC_FREQ_LIMIT = 1001;  // 频率限制
    public final static int SC_INVALID_VERIFY_CODE = 1002;  // 手机号与验证码不匹配
    public final static int SC_INVALID_TOKEN = 1003;  // 无效的token
    public final static int SC_USER_ALREADY_LOGINED = 1004;  // 用户已经登录
    public final static int SC_SYS_ERROR = 1005;  // 系统错误
    public final static int SC_UNKNOWN_ERROR = 1006;  // 未知错误
    public final static int SC_INVALID_ARGS = 1007;  // 无效的参数
    public final static int SC_ACCOUNT_FREEZED = 1008;  // 帐号被冻结
    public final static int SC_TOKEN_EXPIRED = 1009;  // token过期
    public final static int SC_VERIFY_CODE_EXPIRED = 1010;  //验证码超时
    public final static int SC_ALREADY_EXIT = 1011;  // 已经存在
    public final static int SC_INVALID_FILE_TYPE = 1012;  // 文件类型不对
    public final static int SC_CURRENT_TIME_NOT_ALLOW = 1013;  //当前时段不允许
    public final static int SC_INVALID_USERNAME_OR_PASSWORD = 1014;  //用户名或密码错误
    public final static int SC_NOT_ENOUGH_PERMISSION = 1015;  //权限不足
    public final static int SC_SEND_AUTH_CODE_FAILED = 1016;  //发送验证码失败
    public final static int SC_MOBILE_NUMBER_ILLEGAL = 1017;  //手机号不支持
    public final static int SC_USER_NOT_EXIT = 1018;  //用户不存在
    public final static int SC_OVER_AUTH_CODE_MAX_COUNT_IN_TIME = 1019;  //超过一天内验证码发送的最大次数限制
    public final static int SC_NOT_FOUND = 1020;  //没有找到
    public final static int SC_ACCOUNT_DELETED = 1021;  //帐号已删除
    public final static int SC_NOT_REST = 1022;  //没有余量
    public final static int SC_SUBMITED_DATA_NOT_ENOUGH = 1023;  //提交数据量不足
    public final static int SC_CANT_ROB_REPEAT = 1024;  //不能重复抢任务
    public final static int SC_OPERATION_FAILED = 1025;  //操作失败
    public final static int SC_OLD_PASSWORD_FAILED = 1026;  //旧密码错误
    public final static int SC_CODE = 1027;  //code为空


    public final static String[] SC_ARRAY_MESSAGES = new String[]{
            "成功",
            "频率限制",
            "手机号与验证码不匹配",
            "无效的token",
            "用户已经登录",
            "系统错误",
            "未知错误",
            "无效的参数",
            "帐号被冻结",
            "token过期",
            "验证码超时",
            "已经存在",
            "文件类型不对",
            "当前时段不允许",
            "用户名或密码错误",
            "权限不足",
            "发送验证码失败",
            "手机号不支持",
            "用户不存在",
            "超过一天内验证码发送的最大次数限制",
            "没有找到",
            "帐号已删除",
            "没有余量",
            "提交数据量不足",
            "不能重复抢任务",
            "操作失败",
            "旧密码错误",
            "code为空"
    };

    public final static String SC_MESSAGE_SUCCESS = "成功"; //成功
    public final static String SC_MESSAGE_FREQ_LIMIT = "频率限制";  // 频率限制
    public final static String SC_MESSAGE_INVALID_VERIFY_CODE = "手机号与验证码不匹配";  // 无效的验证码
    public final static String SC_MESSAGE_INVALID_TOKEN = "无效的token";  // 无效的token
    public final static String SC_MESSAGE_USER_ALREADY_LOGINED = "用户已经登录";  // 用户已经登录
    public final static String SC_MESSAGE_SYS_ERROR = "系统错误";  // 系统错误
    public final static String SC_MESSAGE_UNKNOWN_ERROR = "未知错误";  // 未知错误
    public final static String SC_MESSAGE_INVALID_ARGS = "无效的参数";  // 无效的参数
    public final static String SC_MESSAGE_ACCOUNT_FREEZED = "帐号被冻结";  // 帐号被冻结
    public final static String SC_MESSAGE_TOKEN_EXPIRED = "token过期";  // token过期
    public final static String SC_MESSAGE_VERIFY_CODE_EXPIRED = "验证码超时";  //验证码超时
    public final static String SC_MESSAGE_USER_ALREADY_REGISTERED = "已经存在";  // 已存在
    public final static String SC_MESSAGE_INVALID_FILE_TYPE = "文件类型不对";  // 文件类型不对
    public final static String SC_MESSAGE_CURRENT_TIME_NOT_ALLOW = "当前时段不允许";  //当前时段不允许
    public final static String SC_MESSAGE_INVALID_USERNAME_OR_PASSWORD = "用户名或密码错误";  //用户名或密码错误
    public final static String SC_MESSAGE_NOT_ENOUGH_PERMISSION = "权限不足";  //权限不足
    public final static String SC_MESSAGE_SEND_AUTH_CODE_FAILED = "发送验证码失败";  //发送验证码失败
    public final static String SC_MESSAGE_MOBILE_NUMBER_ILLEGAL = "手机号不支持";  //发送验证码失败
    public final static String SC_MESSAGE_USER_NOT_EXIT = "用户不存在";  //用户不存在
    public final static String SC_MESSAGE_OVER_AUTH_CODE_MAX_COUNT_IN_TIME = "超过一天内验证码发送的最大次数限制";  //超过一天内验证码发送的最大次数限制
    public final static String SC_MESSAGE_NOT_FOUND = "没有找到";  //没有找到
    public final static String SC_MESSAGE_ACCOUNT_DELETED = "帐号已删除";  //没有找到
    public final static String SC_MESSAGE_NOT_REST = "没有余量";  //没有余量
    public final static String SC_MESSAGE_SUBMITED_DATA_NOT_ENOUGH = "提交数据量不足";  //提交数据量不足
    public final static String SC_MESSAGE_CANT_ROB_REPEAT = "不能重复抢任务";  //不能重复抢任务
    public final static String SC_MESSAGE_OPERATION_FAILED = "操作失败";  //操作失败
    public final static String SC_MESSAGE_CODE = "code为空";  //code为空
}
