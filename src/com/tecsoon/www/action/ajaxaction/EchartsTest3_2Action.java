/**
 * 
 */
package com.tecsoon.www.action.ajaxaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.code.AxisType;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.Pie;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.tecsoon.www.dao.entity.DiagramEntity;
import com.tecsoon.www.service.DiagramDao;

/**
 * @author ZEROONE
 *
 */
@Scope("request")
@Controller("tecsoonecharts-index3_2") // 注释类别名，-struts.xml文件中action的class的名称,添加注释后由spring托管创建
public class EchartsTest3_2Action extends ActionSupport implements ServletRequestAware {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5825023603842712715L;

	private Logger logger = LoggerFactory.getLogger(EchartsTest3_2Action.class);
	
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
    private DiagramDao showInfoService = null;
	
	private String typeName;
	
	private String dataType = "";
	
	/**
     * 处理AJAX请求
     * @return SUCCESS
     */
    @SuppressWarnings("unused")
	public String ajaxQuery() {
    	
    	logger.info(this.getClass() + ":ajaxQuery() method start!");
    	
    	try {

    		List<DiagramEntity> entLst = showInfoService.getDiagramCount();
    		GsonOption option = new GsonOption();
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

    		Bar bar1 = new Bar();
    		bar1.name("直接访问");
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
    		bar1.data(data,data10,data11,data12,data13,data14,data15);

    		Bar bar2 = new Bar();
    		bar2.name("邮件营销").data(120,132,101,134,90,230,210);
    		bar2.tooltip().trigger(Trigger.item);
    		bar2.stack("广告");

    		Bar bar3 = new Bar();
    		bar3.name("联盟广告").data(220,182,191,234,290,330,310);
    		bar3.tooltip().trigger(Trigger.item);
    		bar3.stack("广告");

    		Bar bar4 = new Bar();
    		bar4.name("视频广告").data(150,232,201,154,190,330,410);
    		bar4.tooltip().trigger(Trigger.item);
    		bar4.stack("广告");

    		Line line = new Line();
    		line.name("搜索引擎").data(862,1018,964,1026,1679,1600,1570);

    		Pie pie = new Pie();
    		pie.name("搜索引擎细分").tooltip().trigger(Trigger.item).formatter( "{a} <br/>{b} : {c} ({d}%)");
    		pie.center(160, 130).radius(0, 50);
    		pie.itemStyle().normal().labelLine().length(20);
    		
    		Data data1 = new Data();
    		data1.value(1048).name("百度");
    		Data data2 = new Data();
    		data2.value(251).name("谷歌");
    		Data data3 = new Data();
    		data3.value(147).name("必应");
    		Data data4 = new Data();
    		data4.value(102).name("其他");
    		pie.data(data1,data2,data3,data4);
    		option.series(bar1,bar2,bar3,bar4,line,pie);

    		result = option.toPrettyString();

    	} catch (Exception e) {
        	e.printStackTrace();
        	// 发生异常提示信息
        	logger.debug(e.getMessage());
        }
        
        logger.info(this.getClass() + ":ajaxQuery() method end!");
        
        return SUCCESS;
    }
    
    /**
	 * 获取彩虹柱颜色.
	 * 
	 * @return String
	 */
	public static String getRandColorCode(int param) {

		String[] colorArray = { "#C1232B", "#B5C334", "#FCCE10", "#E87C25", "#27727B", "#FE8463", "#9BCA63", "#FAD860",
				"#F3A43B", "#60C0DD", "#D7504B", "#C6E579", "#F4E001", "#F0805A", "#26C0C0" };

		int len = colorArray.length;

		if (param <= len - 1) {
			return colorArray[param];
		} else {
			int tims = param / len;
			return colorArray[param - len * tims];
		}

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
