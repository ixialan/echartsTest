/**
 * 
 */
package com.tecsoon.www.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * @author ZEROONE
 *
 */
@Scope("request")
@Controller("tecsoonecharts-changetemplate") // 注释类别名，-struts.xml文件中action的class的名称,添加注释后由spring托管创建
public class ChangeTemplateAction extends ActionSupport implements SessionAware {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4819130203782677695L;

	private Logger logger = LoggerFactory.getLogger(ChangeTemplateAction.class);

	private String typeName = "";
	private String dataType = "";

    /**
     * 存储用户登录信息用Session。
     */
    private Map<String, Object> session;
    
    /**
     * 用户信息类。
     */
    private String templateName;
	private String layoutId;
    
	/**
	 * 处理AJAX请求
	 * @return SUCCESS
	 */
	public String execute() {

		logger.info(this.getClass() + ":execute() method start!");
		
		try {
			String userId = String.valueOf(session.get("user"));

			if (userId == null || "".equals(userId)) {
				return "";
			}

			if ("".equals(layoutId) || layoutId == null) {
				layoutId = String.valueOf(session.get("layout"));
			}

			if ("layout1".equals(layoutId)) {
				templateName = "jsp/main-index1.jsp";	
			} else if ("layout2".equals(layoutId)) {
				templateName = "jsp/main-index2.jsp";	
			} else if ("layout3".equals(layoutId)) {
				templateName = "jsp/main-index3.jsp";	
			} else if ("layout4".equals(layoutId)) {
				templateName = "jsp/main-index4.jsp";	
			} else if ("layout5".equals(layoutId)) {
				templateName = "jsp/main-index5.jsp";	
			} else if ("layout6".equals(layoutId)) {
				templateName = "jsp/main-index6.jsp";	
			} else {
				templateName = INPUT;
			}


		} catch (Exception e) {
			
			e.printStackTrace();
			
			// 发生异常提示信息
			logger.debug(e.getMessage());
			throw e;
		}

		logger.info(this.getClass() + ":execute() method end!");

		return SUCCESS;
	}

	/**  
	 * 获取dataType  
	 * @return dataType dataType  
	 */
	public String getDataType() {
		return dataType;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	/**  
	 * 设置dataType  
	 * @param dataType dataType  
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**  
	 * 获取typeName  
	 * @return typeName typeName  
	 */
	public String getTypeName() {
		return typeName;
	}

	/**  
	 * 设置typeName  
	 * @param typeName typeName  
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public void setSession(Map<String, Object> sessionAttibutes) {
		this.session = sessionAttibutes;
	}
	
	public String getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(String layoutId) {
		this.layoutId = layoutId;
	}
	
	public String getTemplateName() {
		return templateName;
	}

	 public void setTemplateName(String templateName) {
		 this.templateName = templateName;
	 }
}
