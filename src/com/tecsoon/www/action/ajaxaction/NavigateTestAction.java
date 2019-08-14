/**
 * 
 */
package com.tecsoon.www.action.ajaxaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.tecsoon.www.dao.entity.NavigateEntity;
import com.tecsoon.www.service.NavigateDao;

import net.sf.json.JSONObject;

/**
 * @author ZEROONE
 *
 */
@Scope("request")
@Controller("tecsoonecharts-navigate") // 注释类别名，-struts.xml文件中action的class的名称,添加注释后由spring托管创建
public class NavigateTestAction extends ActionSupport implements ServletRequestAware {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4819130203782677695L;

	private Logger logger = LoggerFactory.getLogger(NavigateTestAction.class);

	/**
	 * 声明Request。
	 */
	private HttpServletRequest request = null;

	@Override
	public void setServletRequest(HttpServletRequest hsr) {
		this.request = hsr;
	}

	/**
	 * 主页面返回数据。
	 */
	private String result = "";

	@Autowired
	private NavigateDao navigateDaoService = null;
	
	private String dataType = "";

	/**
	 * 处理AJAX请求
	 * @return SUCCESS
	 */
	public String ajaxQuery() {

		logger.info(this.getClass() + ":ajaxQuery() method start!");

		try {

			//获取数据
//			String name = request.getParameter("name");
//			int age = Integer.parseInt(request.getParameter("age")); 
//			String position = request.getParameter("position");
			List<NavigateEntity> entLst = navigateDaoService.getNavigateSubInfo();

			if(entLst.size()==0){
				return "";
			}

			//将数据存储在map里，再转换成json类型数据，也可以自己手动构造json类型数据
			Map<String,Object> map = new HashMap<String,Object>();
			for (int i = 0; i < entLst.size(); i++) {
				NavigateEntity sbjEntity = entLst.get(i);
				
				map.put("name" + i, sbjEntity.getObjecType());
				map.put("count" + i, sbjEntity.getNums());
			}
			
			JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
			result = json.toString();//给result赋值，传递给页面

		} catch (Exception e) {

			// 发生异常提示信息
			logger.debug(e.getMessage());

			throw e;
		}

		logger.info(this.getClass() + ":ajaxQuery() method end!");

		return SUCCESS;
	}

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

	/**  
	 * 获取result  
	 * @return result result  
	 */
	public String getResult() {
		return result;
	}

	/**  
	 * 设置result  
	 * @param result result  
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**  
	 * 获取dataType  
	 * @return dataType dataType  
	 */
	public String getDataType() {
		return dataType;
	}

	/**  
	 * 设置dataType  
	 * @param dataType dataType  
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
}
