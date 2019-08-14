package com.tecsoon.www.vo;

import java.util.Date;

/**
 * Sys_user Entity
 * @author Sat Aug 26 21:07:38 CST 2017 WangHuaxin
 */ 
public class Sys_user {

	private String user_id;
	private String user_cd;
	private String user_nm;
	private String user_role;
	private String password;
	private String real_nm;
	private String sex;
	private String tel;
	private String is_frozen;
	private String creator;
	private Date crt_dt;
	private String updater;
	private Date update_dt;
	private String remark;
	private String identity_flag;
	private String email;
	private String http;
	private Date birth_date;
	private String post;
	private String org;

    /**
     * 设置 user_id
     * @param String user_id
     */ 
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

    /**
     * 获取 user_id
     * @return String user_id
     */ 
	public String getUser_id() {
		return user_id;
	}

    /**
     * 设置 user_cd
     * @param String user_cd
     */ 
	public void setUser_cd(String user_cd) {
		this.user_cd = user_cd;
	}

    /**
     * 获取 user_cd
     * @return String user_cd
     */ 
	public String getUser_cd() {
		return user_cd;
	}

    /**
     * 设置 user_nm
     * @param String user_nm
     */ 
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}

    /**
     * 获取 user_nm
     * @return String user_nm
     */ 
	public String getUser_nm() {
		return user_nm;
	}

    /**
     * 设置 user_role
     * @param String user_role
     */ 
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

    /**
     * 获取 user_role
     * @return String user_role
     */ 
	public String getUser_role() {
		return user_role;
	}

    /**
     * 设置 password
     * @param String password
     */ 
	public void setPassword(String password) {
		this.password = password;
	}

    /**
     * 获取 password
     * @return String password
     */ 
	public String getPassword() {
		return password;
	}

    /**
     * 设置 real_nm
     * @param String real_nm
     */ 
	public void setReal_nm(String real_nm) {
		this.real_nm = real_nm;
	}

    /**
     * 获取 real_nm
     * @return String real_nm
     */ 
	public String getReal_nm() {
		return real_nm;
	}

    /**
     * 设置 sex
     * @param String sex
     */ 
	public void setSex(String sex) {
		this.sex = sex;
	}

    /**
     * 获取 sex
     * @return String sex
     */ 
	public String getSex() {
		return sex;
	}

    /**
     * 设置 tel
     * @param String tel
     */ 
	public void setTel(String tel) {
		this.tel = tel;
	}

    /**
     * 获取 tel
     * @return String tel
     */ 
	public String getTel() {
		return tel;
	}

    /**
     * 设置 is_frozen
     * @param String is_frozen
     */ 
	public void setIs_frozen(String is_frozen) {
		this.is_frozen = is_frozen;
	}

    /**
     * 获取 is_frozen
     * @return String is_frozen
     */ 
	public String getIs_frozen() {
		return is_frozen;
	}

    /**
     * 设置 creator
     * @param String creator
     */ 
	public void setCreator(String creator) {
		this.creator = creator;
	}

    /**
     * 获取 creator
     * @return String creator
     */ 
	public String getCreator() {
		return creator;
	}

    /**
     * 设置 crt_dt
     * @param Date crt_dt
     */ 
	public void setCrt_dt(Date crt_dt) {
		this.crt_dt = crt_dt;
	}

    /**
     * 获取 crt_dt
     * @return Date crt_dt
     */ 
	public Date getCrt_dt() {
		return crt_dt;
	}

    /**
     * 设置 updater
     * @param String updater
     */ 
	public void setUpdater(String updater) {
		this.updater = updater;
	}

    /**
     * 获取 updater
     * @return String updater
     */ 
	public String getUpdater() {
		return updater;
	}

    /**
     * 设置 update_dt
     * @param Date update_dt
     */ 
	public void setUpdate_dt(Date update_dt) {
		this.update_dt = update_dt;
	}

    /**
     * 获取 update_dt
     * @return Date update_dt
     */ 
	public Date getUpdate_dt() {
		return update_dt;
	}

    /**
     * 设置 remark
     * @param String remark
     */ 
	public void setRemark(String remark) {
		this.remark = remark;
	}

    /**
     * 获取 remark
     * @return String remark
     */ 
	public String getRemark() {
		return remark;
	}

    /**
     * 设置 identity_flag
     * @param String identity_flag
     */ 
	public void setIdentity_flag(String identity_flag) {
		this.identity_flag = identity_flag;
	}

    /**
     * 获取 identity_flag
     * @return String identity_flag
     */ 
	public String getIdentity_flag() {
		return identity_flag;
	}

    /**
     * 设置 email
     * @param String email
     */ 
	public void setEmail(String email) {
		this.email = email;
	}

    /**
     * 获取 email
     * @return String email
     */ 
	public String getEmail() {
		return email;
	}

    /**
     * 设置 http
     * @param String http
     */ 
	public void setHttp(String http) {
		this.http = http;
	}

    /**
     * 获取 http
     * @return String http
     */ 
	public String getHttp() {
		return http;
	}

    /**
     * 设置 birth_date
     * @param Date birth_date
     */ 
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

    /**
     * 获取 birth_date
     * @return Date birth_date
     */ 
	public Date getBirth_date() {
		return birth_date;
	}

    /**
     * 设置 post
     * @param String post
     */ 
	public void setPost(String post) {
		this.post = post;
	}

    /**
     * 获取 post
     * @return String post
     */ 
	public String getPost() {
		return post;
	}

    /**
     * 设置 org
     * @param String org
     */ 
	public void setOrg(String org) {
		this.org = org;
	}

    /**
     * 获取 org
     * @return String org
     */ 
	public String getOrg() {
		return org;
	}

    /**
     * 无参构造方法. 
     */ 
	public Sys_user() {
		super();
	}

    /**
     * 有参构造方法. 
     */ 
	public Sys_user(String user_id, String user_cd, String user_nm, String user_role, String password, String real_nm, String sex, String tel, String is_frozen, String creator, Date crt_dt, String updater, Date update_dt, String remark, String identity_flag, String email, String http, Date birth_date, String post, String org) {
		this.user_id = user_id;
		this.user_cd = user_cd;
		this.user_nm = user_nm;
		this.user_role = user_role;
		this.password = password;
		this.real_nm = real_nm;
		this.sex = sex;
		this.tel = tel;
		this.is_frozen = is_frozen;
		this.creator = creator;
		this.crt_dt = crt_dt;
		this.updater = updater;
		this.update_dt = update_dt;
		this.remark = remark;
		this.identity_flag = identity_flag;
		this.email = email;
		this.http = http;
		this.birth_date = birth_date;
		this.post = post;
		this.org = org;
	}
}

