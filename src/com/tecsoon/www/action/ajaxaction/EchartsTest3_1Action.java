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
import com.github.abel533.echarts.code.LineType;
import com.github.abel533.echarts.code.Position;
import com.github.abel533.echarts.code.Symbol;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.style.itemstyle.Emphasis;
import com.github.abel533.echarts.style.itemstyle.Normal;
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
@Controller("tecsoonecharts-index3_1") // 注释类别名，-struts.xml文件中action的class的名称,添加注释后由spring托管创建
public class EchartsTest3_1Action extends ActionSupport implements ServletRequestAware {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5825023603842712715L;

	private Logger logger = LoggerFactory.getLogger(EchartsTest3_1Action.class);
	
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
    		option.tooltip().trigger(Trigger.axis);
    		option.calculable(true);
    		
    		CategoryAxis categoryxAxis = new CategoryAxis();
    		categoryxAxis.type(AxisType.category);
    		categoryxAxis.boundaryGap(false).data("周一","周二","周三","周四","周五","周六","周日");
    		option.xAxis(categoryxAxis);
    		
    		CategoryAxis categoryyAxis = new CategoryAxis();
    		categoryyAxis.type(AxisType.value);
    		option.yAxis(categoryyAxis);

    		Line line1 = new Line();
    		line1.name("邮件营销");
    		line1.stack("总量").symbol("none");
    		
    		Normal normal1 = new Normal();
    		normal1.areaStyle().color("#CD853F");
    		line1.itemStyle().normal(normal1);
    		
    		Data data11 = new Data();
    		data11.value(120);
    		
    		Data data12 = new Data();
    		data12.value(132);
    		
    		Data data13 = new Data();
    		data13.value(301);
    		
    		Data data14 = new Data();
    		data14.value(134);
    		
    		Data data15 = new Data();
    		data15.value(90).symbol(Symbol.droplet).symbolSize(5);
    		
    		Data data16 = new Data();
    		data16.value(230);
    		
    		Data data17 = new Data();
    		data17.value(210);
    		line1.data(data11, data12, data13, data14, data15, data16, data17);
    		
    		
    		Line line2 = new Line();
    		line2.name("联盟广告").stack("总量").smooth(true).symbol("image://../asset/ico/favicon.png").symbolSize(8);
    		
    		Data data21 = new Data();
    		data21.value(120);
    		
    		Data data22 = new Data();
    		data22.value(82);
    		
    		Data data23 = new Data();
    		data23.value(201).symbol(Symbol.star).symbolSize(15).itemStyle().normal().label().show(true).textStyle().fontSize(20).fontFamily("微软雅黑").fontWeight("bold");
    		
    		Data data24 = new Data();
    		data24.value(134).symbol(Symbol.none);
    		
    		Data data25 = new Data();
    		data25.value(190);
    		
    		Data data26 = new Data();
    		data26.value(230).symbol(Symbol.emptypin).symbolSize(8);
    		
    		Data data27 = new Data();
    		data27.value(110);
    		
    		line2.data(data21, data22, data23, data24, data25, data26, data27);
    		
    		Line line3 = new Line();
    		line3.name("直接访问").stack("总量").symbol("arrow").symbolSize(6).symbolRoate(-45);
    		Normal normal2 = new Normal();
    		normal2.color("red").lineStyle().width(2).type(LineType.dashed);
    		Emphasis emphasis2 = new Emphasis();
    		emphasis2.color("blue");
    		line3.itemStyle().normal(normal2).emphasis(emphasis2);
    		
    		Data data31 = new Data();
    		data31.value(320);
    		
    		Data data32 = new Data();
    		data32.value(332);
    		
    		Data data33 = new Data();
    		data33.value("-");
    		
    		Data data34 = new Data();
    		data34.value(334);
    		
    		Normal normal31 = new Normal();
    		normal31.color("green");
    		
    		Emphasis emphasis31 = new Emphasis();
    		emphasis31.color("orange");
    		emphasis31.label().show(true).position(Position.inside).textStyle().fontSize(20);
    		
    		Data data35 = new Data();
    		data35.value(390).symbol("star6").symbolSize(20);
    		data35.itemStyle().normal(normal31).emphasis(emphasis31);
    		
    		Data data36 = new Data();
    		data36.value(330);
    		
    		Data data37 = new Data();
    		data37.value(320);
    		
    		line3.symbolRoate(10);
    		line3.data(data31, data32, data33, data34, data35, data36, data37);
    		
    		Normal normal41 = new Normal();
    		normal41.lineStyle().width(2).color("green").shadowColor("rgba(0,0,0,0.5)").shadowBlur(10).shadowOffsetX(8).shadowOffsetY(8);
    		Emphasis emphasis41 = new Emphasis();
    		emphasis41.label().show(true);
    		
    		Line line4 = new Line();
    		line4.name("搜索引擎").symbol(Symbol.emptyCircle);
    		
    		line4.itemStyle().normal(normal41).emphasis(emphasis41);
    		
    		Data data41 = new Data();
    		data41.value(620);
    		
    		Data data42 = new Data();
    		data42.value(732);
    		
    		Data data43 = new Data();
    		data43.value(791);
    		
    		Data data44 = new Data();
    		data44.value(734).symbol(Symbol.emptyheart).symbolSize(10);
    		
    		Data data45 = new Data();
    		data45.value(890);
    		
    		Data data46 = new Data();
    		data46.value(930);
    		
    		Data data47 = new Data();
    		data47.value(820);
    		
    		line4.data(data41, data42, data43, data44, data45, data46, data47);
    		
    		option.series(line1,line2,line3,line4);
    		
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
