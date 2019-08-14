package com.tecsoon.www.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.tecsoon.www.service.ArchService;
@Scope("request")
@Controller("archAction")

public class Arch_busi_uviewAction extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(Arch_busi_uviewAction.class);

	private String uview_nm;
	private String uview_id;
	private String uview_type;
	private String uview_no;
	private String par_uview_id;
	private String exist_media;
	private String uview_desc;
	private String used;
	private String complex;
	private String important;
	private String max_occurs;
	private String busidomn_id;
	private String proj_id;
	private String update_dt;
	public String getUview_id() {
		return uview_id;
	}
	public void setUview_id(String uview_id) {
		this.uview_id = uview_id;
	}
	public String getUview_type() {
		return uview_type;
	}
	public void setUview_type(String uview_type) {
		this.uview_type = uview_type;
	}
	public String getPar_uview_id() {
		return par_uview_id;
	}
	public void setPar_uview_id(String par_uview_id) {
		this.par_uview_id = par_uview_id;
	}
	public String getExist_media() {
		return exist_media;
	}
	public void setExist_media(String exist_media) {
		this.exist_media = exist_media;
	}
	public String getUview_desc() {
		return uview_desc;
	}
	public void setUview_desc(String uview_desc) {
		this.uview_desc = uview_desc;
	}
	public String getUsed() {
		return used;
	}
	public void setUsed(String used) {
		this.used = used;
	}
	public String getComplex() {
		return complex;
	}
	public void setComplex(String complex) {
		this.complex = complex;
	}
	public String getImportant() {
		return important;
	}
	public void setImportant(String important) {
		this.important = important;
	}
	public String getMax_occurs() {
		return max_occurs;
	}
	public void setMax_occurs(String max_occurs) {
		this.max_occurs = max_occurs;
	}
	public String getBusidomn_id() {
		return busidomn_id;
	}
	public void setBusidomn_id(String busidomn_id) {
		this.busidomn_id = busidomn_id;
	}
	public String getProj_id() {
		return proj_id;
	}
	public void setProj_id(String proj_id) {
		this.proj_id = proj_id;
	}
	public String getUpdate_dt() {
		return update_dt;
	}
	public void setUpdate_dt(String update_dt) {
		this.update_dt = update_dt;
	}
	private  Map<String, Object> session=null;
	 @Autowired
	private ArchService service=null;
	 @Override
		public void setSession(Map<String, Object> sessionAttibutes) {
			this.session = sessionAttibutes;
		}
	public String getUview_nm() {
		return uview_nm;
	}
	public void setUview_nm(String uview_nm) {
		this.uview_nm = uview_nm;
	}
	public String getUview_no() {
		return uview_no;
	}
	public void setUview_no(String uview_no) {
		this.uview_no = uview_no;
	}
	public ArchService getService() {
		return service;
	}
	public void setService(ArchService service) {
		this.service = service;
	}
	public Map<String, Object> getSession() {
		return session;
	}
   public String execute() {
	   logger.info(this.getClass() + ":execute() method start!");
		Map<String,String>map=new HashMap<String,String>();
		map.put("uview_nm",uview_nm);
		map.put("uview_no",uview_no);
	     service.archMap(map);
		return "uviewList";
		
	   
   }


}
