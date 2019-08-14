package com.tecsoon.www.action.ajaxaction;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.code.AxisType;
//import com.github.abel533.echarts.axis.CategoryAxis;
//import com.github.abel533.echarts.code.AxisType;
//import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.Trigger;
//import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.data.Data;
//import com.github.abel533.echarts.feature.Feature;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Line;
//import com.github.abel533.echarts.series.Pie;
import com.opensymphony.xwork2.ActionSupport;
public class EchartsAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6750012169024613453L;
	private HttpServletRequest request;
	private String typeName="";
	private String result="";
	private Map<String, Object> session;

	public HttpServletRequest getRequest() {
		return request;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	private String dataType="";


	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// 

		
	}
	//@SuppressWarnings("static-access")
	public String execute() {
//		try {
//
//			GsonOption option = new GsonOption();
//			option.tooltip(Trigger.axis);
//			option.calculable(true);
//			CategoryAxis categoryxAxis = new CategoryAxis();
//			option.xAxis(categoryxAxis);
//      		CategoryAxis categoryyAxis = new CategoryAxis();
//			categoryyAxis.type(AxisType.value).position("right");
//			option.yAxis(categoryyAxis);
//			Data data1 = new Data();
//			data1.value(1048).name("百度");
//			Data data2 = new Data();
//			data2.value(251).name("谷歌");
//			Data data3 = new Data();
//			data3.value(147).name("必应");
//			Data data4 = new Data();
//			data4.value(102).name("其他");
//
//			Pie pie = new Pie();
//			pie.name("搜索引擎细分").tooltip().trigger(Trigger.item).formatter( "{a} <br/>{b} : {c} ({d}%)");
//			pie.center(160, 130).radius(0, 50);
//			pie.itemStyle().normal().labelLine().length(20);
//			pie.data(data1, data2, data3, data4);
//			//option.series(bar1, bar2, bar3, bar4, line, pie);
//             option.series(pie);
//			result = option.toPrettyString();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			// 发生异常提示信息
//
//			throw e;
//		}
//GsonOption option = new GsonOption();//第二种写法
//		
//		option.title("某站点用户访问来源");
//		option.title().subtext("纯属虚构");
//		option.title().x(X.center);
//		
//		option.tooltip().trigger(Trigger.item);
//		option.tooltip().formatter("{a} <br/>{b} : {c} ({d}%)");
//		
//		option.legend().orient(Orient.vertical);
//		option.legend().x(X.left);
//		
//		Feature feature = new Feature();
//		feature.mark.show(true);
//		feature.dataView.show(true).readOnly(false);
//		String[] typArr = {"pie", "line"};
//		feature.magicType.show(true).type(typArr);
//		feature.restore.show(true);
//		feature.saveAsImage.show(true);

//		option.toolbox().show(true);
//		option.toolbox().feature(feature);
//		
//		option.calculable(true);
//		//String[] jdata = {"","",""};
//		List<Data> dataList = new ArrayList<Data>();	
//		Data data = new Data();
//		//jdata =new data();
//		data.value(335).name("直接访问");
//		//dataList.add(jdata);
//		dataList.add(data);
//		
//		data = new Data();
//		data.value(310).name("邮件营销");
//		dataList.add(data);
//		
//		data = new Data();
//		data.value(234).name("联盟广告");
//		dataList.add(data);
//		
//		data = new Data();
//		data.value(135).name("视频广告");
//		dataList.add(data);
//		
//		data = new Data();
//		data.value(1548).name("搜索引擎");
//		dataList.add(data);
//		
//		Pie pie = new Pie();
//		pie.setName("访问来源");
//		pie.radius("55%");
//		String[] strArr = {"50%", "60%"};
//		pie.center(strArr);
//		pie.data(dataList.toArray());//转数组
//		
//		option.series(pie);
//		
//		result = option.toPrettyString();
//		
		/*GsonOption joption =new GsonOption();//标准饼状图写法
	    joption.title().text("'某站点用户访问来源'").subtext(" 纯属虚构").x("center");
		joption.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c} ({d}%)");
		joption.legend().orient( Orient.vertical).x(X.left).data("直接访问","邮件营销","联盟广告","视频广告","搜索引擎");
		//String[] data = {"直接访问","邮件营销","联盟广告","视频广告","搜索引擎"};
		List<Data> jdata =new ArrayList<Data>();
		Data data =new Data();
		data.value("直接访问");
		jdata.add(data);
		Data data1 =new Data();
		data1.value("邮件营销");
		jdata.add(data1);
		Data data2 =new Data();
		data2.value("联盟广告");
		jdata.add(data2);
		Data data3 =new Data();
		data3.value("视频广告");
		jdata.add(data3);
		Data data4 =new Data();
		data4.value("搜索引擎");
		jdata.add(data4);
		joption.toolbox().show(true);
		Feature feature =new Feature();
		feature.mark.show(true);
		feature.dataView.show(true).readOnly(false);
		String[] str = {"pre","funnel"};
		feature.magicType.show(true).type(str);
		feature.restore.show(true);
		feature.saveAsImage.show(true);
		List<Data> ldata =new ArrayList<Data>();
		Data dat =new Data();
		dat.value(335).name("直接访问");
		ldata.add(dat);
		Data dat1 =new Data();
		dat1.value(310).name("邮件营销");
		ldata.add(dat1);
		Data dat2 =new Data();
		dat2.value(234).name("联盟广告");
		ldata.add(dat2);
		Data dat3 =new Data();
		dat3.value(135).name("视频广告");
		ldata.add(dat3);
		Data dat4 =new Data();
		dat4.value(1548).name("搜索引擎");
		ldata.add(dat4);
		Pie pie =new Pie();
		pie.name("访问来源");
		pie.radius("55%");
		String[] cen = {"50%","60%"};
		pie.center(cen);
		pie.data(ldata.toArray());
		joption.series(pie);
		result=joption.toPrettyString();*/
		GsonOption option = new GsonOption();//柱状图写法

		option.tooltip(Trigger.axis);
		option.calculable(true);
		option.legend().data("直接访问","邮件营销","联盟广告","视频广告","搜索引擎");
		CategoryAxis categoryxAxis = new CategoryAxis();
		categoryxAxis.type(AxisType.category).splitLine().show(false);
		categoryxAxis.data("周一","周二","周三","周四","周五","周六","周日");
		option.xAxis(categoryxAxis);
  		CategoryAxis categoryyAxis = new CategoryAxis();
		categoryyAxis.type(AxisType.value).position("right");
 		option.yAxis(categoryyAxis);

		Data data = new Data();
		data.value(320);
		Data data10 = new Data();
		data10.value(332);
		Data data11 = new Data();
		data11.value(301);
		Data data12 = new Data();
		data12.value(334);
		Data data13 = new Data();
		data13.value(390);
		Data data14= new Data();
		data14.value(330);
		Data data15 = new Data();
		data15.value(320);

		Bar bar1 = new Bar();
		bar1.name("直接访问");
		bar1.data(data, data10, data11, data12, data13, data14, data15);

		Bar bar2 = new Bar();
		bar2.name("邮件营销").data(120, 132, 101, 134, 90, 230, 210);
		bar2.tooltip().trigger(Trigger.item);
		bar2.stack("广告");

		Bar bar3 = new Bar();
		bar3.name("联盟广告").data(220, 182, 191, 234, 290, 330, 310);
		bar3.tooltip().trigger(Trigger.item);
		bar3.stack("广告");

		Bar bar4 = new Bar();
		bar4.name("视频广告").data(150, 232, 201, 154, 190, 330, 410);
		bar4.tooltip().trigger(Trigger.item);
		bar4.stack("广告");

		Line line = new Line();
		line.name("搜索引擎").data(862, 1018, 964, 1026, 1679, 1600, 1570);


		option.series(bar1,bar2,bar3,bar4,line);
		result = option.toPrettyString();

		return SUCCESS;
		
	}

	}

