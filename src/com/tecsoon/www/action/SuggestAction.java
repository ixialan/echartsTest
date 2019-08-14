package com.tecsoon.www.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class SuggestAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String key;

	private List<String> items = null;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	private void init() {
		items = new ArrayList<String>();
		items.add("祥子今天很忙");
		items.add("大家都说祥子长的很帅");
		items.add("祥子芳芳");
		items.add("帅帅正在上自习");
		items.add("图书馆今天好多人哦");
		items.add("图书馆的阿姨人很好");
	}

	@Override
	public String execute() throws Exception {
		init();

		if (key != null && key.length() > 0) {
			StringBuffer output = new StringBuffer("");
			output.append("<response>");

			for (String item : items) {
				if (item.contains(key)) {
					output.append("<item>");
					output.append(item);
					output.append("</item>");
				}
			}
			output.append("</response>");

			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.write(output.toString());
			out.flush();
			out.close();
		}

		return null;
	}

}
