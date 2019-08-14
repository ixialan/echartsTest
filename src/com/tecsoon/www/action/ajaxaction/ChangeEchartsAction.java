/**
 * 
 */
package com.tecsoon.www.action.ajaxaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.github.abel533.echarts.Chart;
import com.github.abel533.echarts.Label;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.AxisType;
import com.github.abel533.echarts.code.LineType;
import com.github.abel533.echarts.code.Position;
import com.github.abel533.echarts.code.Symbol;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.Pie;
import com.github.abel533.echarts.series.SeriesFactory;
import com.github.abel533.echarts.series.Treemap;
import com.github.abel533.echarts.style.itemstyle.Emphasis;
import com.github.abel533.echarts.style.itemstyle.Normal;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.tecsoon.www.dao.entity.DiagramEntity;
import com.tecsoon.www.service.DiagramDao;

import net.sf.json.JSONObject;

/**
 * @author ZEROONE
 *
 */
@Scope("request")
@Controller("tecsoonecharts-change") // 注释类别名，-struts.xml文件中action的class的名称,添加注释后由spring托管创建
public class ChangeEchartsAction extends ActionSupport implements ServletRequestAware {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4819130203782677695L;

	private Logger logger = LoggerFactory.getLogger(ChangeEchartsAction.class);

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

	private String typeName;
	
	private String dataType;

	@Autowired
	private DiagramDao showInfoService = null;

	/**
	 * 处理AJAX请求
	 * @return SUCCESS
	 */
	public String ajaxQuery() {

		logger.info(this.getClass() + ":ajaxQuery() method start!");

		try {
			String tName = "tecsoonTreeMap";
			if (typeName != null && !"".equals(typeName)) {
				JSONObject cName = JSONObject.fromObject(typeName);
				tName = (String) cName.get("cname");
			}

			List<DiagramEntity> entLst = showInfoService.getDiagramCount();
			List<String> dataNameList = new ArrayList<String>();
			List<Integer> dataDataList = new ArrayList<Integer>();

			if(entLst.size()==0){
				return "";
			}

			for(DiagramEntity diagramEntity : entLst){
				dataNameList.add(diagramEntity.getDiagramName());
				dataDataList.add(Integer.valueOf(diagramEntity.getNums()));
			}

			GsonOption option = new GsonOption();

			Object[] types = dataNameList.toArray();
			Object[] datas = dataDataList.toArray();

			Chart mychart = null;

			// 图形编辑
			if ("tecsoonPie".equals(tName)) {

				String title = "广告数据";

				// 提示工具 鼠标在每一个数据项上，触发显示提示数据
				option.tooltip().enterable(true).trigger(Trigger.item).backgroundColor("#AB82FF");//.formatter("{a} <br/>{b} : {c} ({d}%)");
				option.calculable(true);// 拖动进行计算

				mychart = SeriesFactory.newPie();

				// 标题、半径、位置
				((Pie) mychart).name(title).radius("55%").center("50%", "60%");

				// 循环数据
				for (int i = 0; i < types.length; i++) {
					Map<String, Object> map = new HashMap<String, Object>(2);
					map.put("value", datas[i]);
					map.put("name", types[i]);
					((Pie) mychart).data(map);
				}

				option.series(((Pie) mychart));
			} else if ("tecsoonTreeMap".equals(tName)) {

				option.tooltip().show(true);
				option.calculable(false);

				Label label = new Label();
				label.show(true);
				label.formatter("{b}");

				Normal normal = new Normal();
				normal.label(label);
				normal.borderWidth(1);

				Label newLabel = new Label();
				newLabel.show(true);
				mychart = SeriesFactory.newTreemap();
				((Treemap) mychart).itemStyle().normal(normal).emphasis().label(newLabel);
				option.grid().borderWidth(1).x(130).x2(130).y(50).y2(50);

				for (int i = 0; i < entLst.size(); i++) {
					DiagramEntity sbjEntity = entLst.get(i);
					Data data = new Data();
					data.name(sbjEntity.getDiagramName()).value(Integer.valueOf(sbjEntity.getNums())).text(sbjEntity.getDiagramName());
					((Treemap) mychart).data(data);
				}

				option.series(((Treemap) mychart));
				
			} else if ("tecsoonLine".equals(tName)) {
				
//				option.legend("高度(km)与气温(°C)变化关系");
	    	 
	    	    option.calculable(true);
	    	    option.tooltip().trigger(Trigger.axis).show(true);//.formatter("Temperature : <br/>{b}km : {c}°C");
	    	 
	    	    ValueAxis valueAxis = new ValueAxis();
	    	    valueAxis.axisLabel().show(true);//.formatter("{value} °C");
	    	    option.xAxis(valueAxis);
	    	 
	    	    CategoryAxis categoryAxis = new CategoryAxis();
	    	    categoryAxis.axisLine().onZero(false);
	    	    categoryAxis.axisLabel().show(true);//.formatter("{value} km");
	    	    categoryAxis.boundaryGap(false);
	    	    categoryAxis.data(0, 10, 20, 30, 40, 50, 60, 70, 80);
	    	    option.yAxis(categoryAxis);
	    	 
	    	    mychart = new Line();
//	    	    line.smooth(true).name("高度(km)与气温(°C)变化关系").data(15, -50, -56.5, -46.5, -22.1, -2.5, -27.7, -55.7, -76.5).itemStyle().normal().lineStyle().shadowColor("rgba(0,0,0,0.4)");
	    	    ((Line) mychart).smooth(true).name("").data(15, -50, -56.5, -46.5, -22.1, -2.5, -27.7, -55.7, -76.5).itemStyle().normal().lineStyle().shadowColor("rgba(0,0,0,0.4)");
	    	    option.series(((Line) mychart));
			} else if ("tecsoonBar".equals(tName)) {

	    		CategoryAxis categoryxAxis = new CategoryAxis();
	    		categoryxAxis.data(dataNameList.toArray()).type(AxisType.category);
	    		option.xAxis(categoryxAxis);
	    		
	    		CategoryAxis categoryyAxis = new CategoryAxis();
	    		categoryyAxis.type(AxisType.value);
	    		option.yAxis(categoryyAxis);
	    		
	    		mychart = new Bar();
	    		((Bar) mychart).data(dataDataList.toArray());
	    		
	    		option.calculable(true);
	    		
	    		option.series(((Bar) mychart));
			} else if ("tecsoonLine1".equals(tName)) {
			
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
	    		
//	    		data.value(201).symbol("star").symbolSize(15);
//	    		Normal normal1 = new Normal();
//	    		normal1.label().show(true).textStyle().fontSize(20).fontFamily("微软雅黑").fontWeight("bold");
//	    		data.itemStyle().normal(normal1);
//	    		data.value(134).symbol("none");
	    		
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
			}

			result = option.toPrettyString();

		} catch (Exception e) {

			// 发生异常提示信息
			logger.debug(e.getMessage());
			throw e;
		}

		logger.info(this.getClass() + ":ajaxQuery() method end!");

		return SUCCESS;
	}


	//    private static String getOtherPersent(int params) {
	//		return "other" + "\n" + params + "%" + "\n";
	//	}
	//    private static String getFormatterValue(int params) {
	//		return (100 - params) + "%";
	//	}

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
