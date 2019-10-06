/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package shizhe.config;

import shizhe.common.PropertiesLoader;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局配置类
 * @author ThinkGem
 * @version 2014-06-25
 */
public class Global {

	/**
	 * 当前对象实例
	 */
	private static Global global = new Global();
	
	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = new HashMap<String, String>();
	
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader loader = new PropertiesLoader("pollsurvey.properties");

	/**
	 * 显示/隐藏
	 */
	public static final String SHOW = "1";
	public static final String HIDE = "0";

	/**
	 * 是/否
	 */
	public static final String YES = "1";
	public static final String NO = "0";
	
	/**
	 * 对/错
	 */
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	
	/**
	 * 上传文件基础虚拟路径
	 */
	public static final String USERFILES_BASE_URL = "/userfiles/";
	
	/**
	 * 获取当前对象实例
	 */
	public static Global getInstance() {
		return global;
	}
	
	/**
	 * 获取配置
	 * @see {fns:getConfig('adminPath')}
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null){
			value = loader.getProperty(key);
			map.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}

	public static String getLoginUrl(){return getConfig("login.url"); }
	
	/**
	 * 获取管理端根路径
	 */
	public static String getAdminPath() {
		return getConfig("adminPath");
	}
	
	/**
	 * 获取前端根路径
	 */
	public static String getFrontPath() {
		return getConfig("frontPath");
	}
	
	/**
	 * 获取URL后缀
	 */
	public static String getUrlSuffix() {
		return getConfig("urlSuffix");
	}

	public static String getUploadSysPath() {
		String uploadSysPath = Global.getConfig("uploadSysPath");
		if (StringUtils.isNotBlank(uploadSysPath)){
			return uploadSysPath;
		}
		return getProjectPath();
	}

	/**
	 * 不包含系统路径，相当于web路径
	 * @return
	 */
	public static String getUploadTempDir() {
		return getConfig("uploadTempDir");
	}

	public static String getUploadDir() {
		return getConfig("uploadDir");
	}

	public static String getAvatarDir(){
		return getConfig("uploadAvatarDir");
	}

	public static String getAttachmentDir(){
		return getConfig("uploadAttachmentDir");
	}

	public static String getExportDataDir(){
		return getConfig("exportDataDir");
	}
	/**
	 * 包含系统路径  从/开始
	 * @return
	 */
	public static String getAbsoluteUploadTempDir() {
		return getUploadSysPath() + getConfig("uploadTempDir");
	}

	public static String getAbsoluteUploadDir() {
		return getUploadSysPath() + getConfig("uploadDir");
	}

	public static String getAbsoluteExportDataDir() {
		return getUploadSysPath() + getConfig("exportDataDir");
	}
	/**
	 * 页面获取常量
	 * @see {fns:getConst('YES')}
	 */
	public static Object getConst(String field) {
		try {
			return Global.class.getField(field).get(null);
		} catch (Exception e) {
			// 异常代表无配置，这里什么也不做
		}
		return null;
	}
	
    /**
     * 获取工程路径
     * @return
     */
    public static String getProjectPath(){
    	// 如果配置了工程路径，则直接返回，否则自动获取。
		String projectPath = Global.getConfig("projectPath");
		if (StringUtils.isNotBlank(projectPath)){
			return projectPath;
		}
		try {
			File file = new DefaultResourceLoader().getResource("").getFile();
			if (file != null){
				while(true){
					File f = new File(file.getPath() + File.separator + "src" + File.separator + "main");
					if (f == null || f.exists()){
						break;
					}
					if (file.getParentFile() != null){
						file = file.getParentFile();
					}else{
						break;
					}
				}
				projectPath = file.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return projectPath;
    }
	
}
