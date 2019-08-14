package com.tecsoon.www.action.ajaxaction;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import net.sf.json.JSONObject;

public class JqueryRandomAction extends ActionSupport implements ServletRequestAware {
	private Map<String, Object> session;
	 private HttpServletRequest request = null;
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(JqueryAjaxAction.class);
	private String typeName;
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	private String result;
	private String keyName;
	@Override
	public void setServletRequest(HttpServletRequest hsr) {

		/**
	     * 声明Request。
	     */
	   
		this.request = hsr;
		
	}
public String ajaxQuery() {
	
   	
   	logger.info(this.getClass() + ":ajaxQuery() method start!");
   	
		/*JSONObject cName = JSONObject.fromObject(typeName);
		String tName =(String)cName.get(cName);
   	
   	setResult(tName+"今天天气不错！");*/
	JSONObject cName = JSONObject.fromObject(keyName);
	String tName = "";
	
	if (cName != null) {
		tName = (String) cName.get("cname");
	}else {
		double ranNum=Math.random()*100;
	
	if(ranNum==Integer.parseInt(tName)) {
		result = tName+"今天天气不错！";
	}
	
	}
	logger.info(this.getClass() + ":ajaxQuery() method end!");
		return SUCCESS;
   	
  		
	}
   
	/**
	 * 获取彩虹柱颜色.
	 * 
	 * @return String
	 */
	
	/**  
	 * 获取request  
	 * @return request request  
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**  
	 * 设置request  
	 * @param request request  
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	/**  
	 * 获取result  
	 * @return result result  
	 */
	
	/**  
	 * 设置result  
	 * @param result result  
	 */
	
	/**  
	 * 获取dataType  
	 * @return dataType dataType  
	 */
	

	/**  
	 * 设置dataType  
	 * @param dataType dataType  
	 */
	
	/**  
	 * 获取typeName  
	 * @return typeName typeName  
	 */
	

	/**  
	 * 设置typeName  
	 * @param typeName typeName  
	 */
	
	
	/**
	 * 继承SessionAware接口重写的方法。
	 * @param sessionAttibutes
	 */
//	@Override
//	public void setSession(Map<String, Object> sessionAttibutes) {
//		this.session = sessionAttibutes;
//	}
//	
//	/**  
//	 * 获取session  
//	 * @return session session  
//	 */
//	public Map<String, Object> getSession() {
//		return session;
//	}

}
