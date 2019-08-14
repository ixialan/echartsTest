package com.tecsoon.www.action.ajaxaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tecsoon.www.dao.entity.UviewEntity;
import com.tecsoon.www.service.QueryAjaxService;

import net.sf.json.JSONObject;

public class QueryAjaxAction extends ActionSupport implements ServletRequestAware{


	/**
	 * 
	 */
	private static final long serialVersionUID = -4426864283630967907L;
	@Autowired
	private QueryAjaxService queryAjaxService;
	private HttpServletRequest request;
	private String result;
	public QueryAjaxService getQueryAjaxService() {
		return queryAjaxService;
	}

	public void setQueryAjaxService(QueryAjaxService queryAjaxService) {
		this.queryAjaxService = queryAjaxService;
	}


	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub

	}
	public String execute() {
		List<UviewEntity> queryLst = queryAjaxService.getQueryList();
//		Map<String,String>map=new HashMap<String,String>();
//		for (int i = 0; i < queryLst.size(); i++) {
//			UviewEntity sbjEntity = queryLst.get(i);
//
//			map.put("uview_id",sbjEntity.getUview_id());
//			map.put("uview_nm",sbjEntity.getUview_nm());
//			map.put("uview_no",sbjEntity.getUview_no());
//		}
//		JSONObject cName = JSONObject.fromObject(map);
//		//JSONObject cName = new JSONObject();
//		//cName.put(key, value)
//		result=cName.toString();
		JSONObject cn = new JSONObject();
		cn.put("uview_id",queryLst.get(0).getUview_id());
		cn.put("uview_nm",queryLst.get(0).getUview_nm());
		cn.put("uview_no",queryLst.get(0).getUview_no());
		result=cn.toString();
		return SUCCESS;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
