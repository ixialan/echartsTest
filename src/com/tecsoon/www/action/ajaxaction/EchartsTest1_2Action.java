/**
 * 
 */
package com.tecsoon.www.action.ajaxaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.github.abel533.echarts.Chart;
import com.github.abel533.echarts.Grid;
import com.github.abel533.echarts.Label;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.AxisType;
import com.github.abel533.echarts.code.LineType;
import com.github.abel533.echarts.code.PointerType;
import com.github.abel533.echarts.code.Position;
import com.github.abel533.echarts.code.RoseType;
import com.github.abel533.echarts.code.SelectedMode;
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
import com.tecsoon.www.dao.entity.ConnectorEntity;
import com.tecsoon.www.dao.entity.DiagramEntity;
import com.tecsoon.www.service.ConnectorDao;
import com.tecsoon.www.service.DiagramDao;

import net.sf.json.JSONObject;

/**
 * @author ZEROONE
 *
 */
@Scope("request")
@Controller("tecsoonecharts-index1_2") // 注释类别名，-struts.xml文件中action的class的名称,添加注释后由spring托管创建
public class EchartsTest1_2Action extends ActionSupport implements ServletRequestAware, SessionAware {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4819130203782677695L;
	
	private Logger logger = LoggerFactory.getLogger(EchartsTest1_2Action.class);
	
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
	private String typeName = "";
	private String dataType = "";
	@Autowired
	private DiagramDao showInfoService = null;
	@Autowired
	private ConnectorDao connectorDaoService = null;
	
	/**
	 * 存储用户登录信息用Session。
	 */
	private Map<String, Object> session;
	
	/**
     * 处理AJAX请求
     * @return SUCCESS
     */
    @SuppressWarnings("unused")
	public String ajaxQuery() {
    	
    	logger.info(this.getClass() + ":ajaxQuery() method start!");
    	
    	try {
			List<DiagramEntity> entLst = null;
			List<ConnectorEntity> connectorList = null;

//			List<Data> dataList = new ArrayList<Data>();
			// TODO================================================================
			
			String dbName = "";
			String echartsName = "";
			
			if (typeName != null && !"".equals(typeName)) {
				JSONObject cName = JSONObject.fromObject(typeName);
				echartsName = (String) cName.get("cname");
				dbName = (String) cName.get("dbdata");
			} else {
				if (session.get("chart2") != null) {
					echartsName = String.valueOf(session.get("chart2"));
					dbName = String.valueOf(session.get("data1"));
				}
			}
			
			//TODO================================================================

			//			List<String> dataNameList = new ArrayList<String>();
			//			List<Integer> dataDataList = new ArrayList<Integer>();

			//			for(DiagramEntity diagramEntity : entLst){
			//				dataNameList.add(diagramEntity.getDiagramName());
			//				dataDataList.add(Integer.valueOf(diagramEntity.getNums()));
			//			}

			GsonOption option = new GsonOption();

			//			Object[] types = dataNameList.toArray();
			//			Object[] datas = dataDataList.toArray();

			Chart mychart = null;

			// 1_PIE标准饼图
			if ("tecsoonPie1_1".equals(echartsName)) {

				String title = "广告数据";

				// 提示工具 鼠标在每一个数据项上，触发显示提示数据
				option.tooltip().enterable(true).trigger(Trigger.item).backgroundColor("#AB82FF");//.formatter("{a} <br/>{b} : {c} ({d}%)");
				option.calculable(true);// 拖动进行计算

				mychart = SeriesFactory.newPie();

				// 标题、半径、位置
				((Pie) mychart).name(title).radius("55%").center("50%", "60%");

				List<Data> dataList = getDataSourceType1(dbName);

				((Pie) mychart).data(dataList);

				option.series(((Pie) mychart));

				// 2_PIE标准饼图
			} else if ("tecsoonPie1_2".equals(echartsName)) {

				List<Data> dataList = getDataSourceType1(dbName);

				//				List<DiagramEntity> entLst = showInfoService.getDiagramCount();

				// 提示工具 鼠标在每一个数据项上，触发显示提示数据
				option.tooltip().enterable(true).trigger(Trigger.item).formatter("{a} <br/>{b} : {c} ({d}%)");

				option.calculable(true);// 拖动进行计算

				Normal normal = new Normal();
				normal.label().show(false);
				normal.labelLine().show(false);

				Emphasis emphasis = new Emphasis();
				emphasis.label().show(true);
				emphasis.labelLine().show(true);

				//	    		List<Data> dataList = new ArrayList<Data>();

				//	    		for (DiagramEntity diagramEntity : entLst) {
				//	    			Data data = new Data();
				//	    			data.value(diagramEntity.getNums()).name(diagramEntity.getDiagramName());
				//	    			dataList.add(data);
				//	    		}

				Pie pie = new Pie();

				// 标题、半径、位置
				pie.name("radius").radius(20, 100).center("45%", 100);
				pie.roseType(RoseType.radius).itemStyle().normal(normal).emphasis(emphasis);

				pie.data(dataList.toArray());

				option.series(pie);

				// PIE图形编辑3
			} else if ("tecsoonPie1_3".equals(echartsName)) {

				List<Data> dataList = getDataSourceType1(dbName);

				option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c} ({d}%)");
				option.calculable(true);

				Normal normal = new Normal();
				normal.label().show(true).position(Position.inside);
				normal.labelLine().show(false);

				Pie pie = new Pie();
				pie.name("访问来源");
				pie.selectedMode(SelectedMode.single);
				pie.radius(0, "30%");
				pie.itemStyle().normal(normal);

//				Data data11 = new Data();
//				data11.value(335).name("直达").selected(true);
//
//				Data data12 = new Data();
//				data12.value(679).name("营销广告");
//
//				Data data13 = new Data();
//				data13.value(1548).name("搜索引擎");

//				pie.data(data11, data12, data13);
				pie.data(dataList.toArray());

				Pie pie1 = new Pie();
				pie1.name("访问来源");
				pie1.radius("40%", "55%");

//				Data data21 = new Data();
//				data21.value(335).name("直达");
//
//				Data data22 = new Data();
//				data22.value(310).name("邮件营销歌");
//
//				Data data23 = new Data();
//				data23.value(234).name("联盟广告");
//
//				Data data24 = new Data();
//				data24.value(145).name("视频广告");
//
//				Data data25 = new Data();
//				data25.value(1048).name("百度");
//
//				Data data26 = new Data();
//				data26.value(251).name("谷歌");
//
//				Data data27 = new Data();
//				data27.value(147).name("必应");
//
//				Data data28 = new Data();
//				data28.value(102).name("其他");

//				pie1.data(data21, data22, data23, data24, data25, data26, data27, data28);
				pie1.data(dataList.toArray());
				option.series(pie, pie1);


				// PIE图形编辑4
			} else if ("tecsoonPie1_4".equals(echartsName)) {

				List<Data> dataList = getDataSourceType1(dbName);

				option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c} ({d}%)");
				//option.legend().orient(Orient.vertical).x(X.left).data("直接访问","邮件营销","联盟广告","视频广告","搜索引擎");
				option.calculable(true);

				Normal normal = new Normal();
				normal.label().show(false);
				normal.labelLine().show(false);

				Emphasis emphasis = new Emphasis();
				emphasis.label().show(true).position("center").textStyle().fontSize(30).fontWeight("bold");

				Pie pie = new Pie();
				pie.name("访问来源");
				pie.radius("50%", "70%");
				pie.itemStyle().normal(normal).emphasis(emphasis);

				//	    		Data data = null;
				//			    for(DiagramEntity diagramEntity : entLst){
				//			    	data = new Data();
				//			    	pie.data(data.value(diagramEntity.getNums()).name(diagramEntity.getDiagramName()));
				//			    }
				pie.data(dataList);
				option.series(pie);


				// PIE图形编辑5
			} else if ("tecsoonPie1_5".equals(echartsName)) {

				// TODO
				List<Data> dataList = getDataSourceType1(dbName);

				option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c} ({d}%)");

				//				List<Series<Pie>> series = new ArrayList<Series<Pie>>();

				Stack<Pie> series = new Stack<Pie>();

				for (int i = 0; i < 30; i++) {

					Normal normal = new Normal();
					normal.label().show(i < 28);
					normal.labelLine().show(i < 28).length(20);

					Data data1 = new Data();
					data1.value(i * 128 + 80).name("Chrome");

					Data data2 = new Data();
					data2.value(i * 64  + 160).name("Firefox");

					Data data3 = new Data();
					data3.value(i * 32  + 320).name("Safari");

					Data data4 = new Data();
					data4.value(i * 16  + 640).name("IE9+");

					Data data5 = new Data();
					data5.value(i * 8  + 1280).name("IE8-");

					Pie pie = new Pie();
					pie.name("浏览器（数据纯属虚构）");
					pie.itemStyle().normal().label().show(i < 28);
					pie.radius(i * 4 + 40, i * 4 + 43);
					pie.data(data1, data2, data3, data4, data5);

					series.push(pie);
				}

				Data data = new Data();
				data.x("50%");
				data.y("50%");

				series.get(0).markPoint().symbol("emptyCircle").symbolSize(series.get(0).radius(0)).effect().show(true).scaleSize(12).color("rgba(250,225,50,0.8)").shadowBlur(10).period(30);
				series.get(0).data(data);

				// TODO

				return option.toPrettyString();


				// TreeMap图形编辑
			} else if ("tecsoonTreeMap1_1".equals(echartsName)) {

				List<Data> dataList = getDataSourceType1(dbName);

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
				// echarts3.0滚轮缩放失效
				((Treemap) mychart).roam(false);
				((Treemap) mychart).data(dataList.toArray());
				option.grid().borderWidth(1).x(130).x2(130).y(50).y2(50);

				option.series(((Treemap) mychart));


				// Line图形编辑1
			} else if ("tecsoonLine1_1".equals(echartsName)) {

				List<Data> dataList = getDataSourceType1(dbName);

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
//				((Line) mychart).smooth(true).name("").data(15, -50, -56.5, -46.5, -22.1, -2.5, -27.7, -55.7, -76.5).itemStyle().normal().lineStyle().shadowColor("rgba(0,0,0,0.4)");
				((Line) mychart).smooth(true).name("").data(dataList.toArray()).itemStyle().normal().lineStyle().shadowColor("rgba(0,0,0,0.4)");
				option.series(((Line) mychart));

				
				// Line图形编辑2
			} else if ("tecsoonLine1_2".equals(echartsName)) {

				List<Data> dataList = getDataSourceType1(dbName);

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

//				Data data11 = new Data();
//				data11.value(120);
//
//				Data data12 = new Data();
//				data12.value(132);
//
//				Data data13 = new Data();
//				data13.value(301);
//
//				Data data14 = new Data();
//				data14.value(134);
//
//				Data data15 = new Data();
//				data15.value(90).symbol(Symbol.droplet).symbolSize(5);
//
//				Data data16 = new Data();
//				data16.value(230);
//
//				Data data17 = new Data();
//				data17.value(210);
//				line1.data(data11, data12, data13, data14, data15, data16, data17);
				line1.data(dataList.toArray());


				Line line2 = new Line();
				line2.name("联盟广告").stack("总量").smooth(true).symbol("image://../asset/ico/favicon.png").symbolSize(8);

//				Data data21 = new Data();
//				data21.value(120);
//
//				Data data22 = new Data();
//				data22.value(82);
//
//				Data data23 = new Data();
//				data23.value(201).symbol(Symbol.star).symbolSize(15).itemStyle().normal().label().show(true).textStyle().fontSize(20).fontFamily("微软雅黑").fontWeight("bold");
//
//				Data data24 = new Data();
//				data24.value(134).symbol(Symbol.none);
//
//				Data data25 = new Data();
//				data25.value(190);
//
//				Data data26 = new Data();
//				data26.value(230).symbol(Symbol.emptypin).symbolSize(8);
//
//				Data data27 = new Data();
//				data27.value(110);
//				line2.data(data21, data22, data23, data24, data25, data26, data27);
				line2.data(dataList.toArray());

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

//				Data data31 = new Data();
//				data31.value(320);
//
//				Data data32 = new Data();
//				data32.value(332);
//
//				Data data33 = new Data();
//				data33.value("-");
//
//				Data data34 = new Data();
//				data34.value(334);
//
//				Normal normal31 = new Normal();
//				normal31.color("green");
//
//				Emphasis emphasis31 = new Emphasis();
//				emphasis31.color("orange");
//				emphasis31.label().show(true).position(Position.inside).textStyle().fontSize(20);
//
//				Data data35 = new Data();
//				data35.value(390).symbol("star6").symbolSize(20);
//				data35.itemStyle().normal(normal31).emphasis(emphasis31);
//
//				Data data36 = new Data();
//				data36.value(330);
//
//				Data data37 = new Data();
//				data37.value(320);
				line3.symbolRoate(10);
//				line3.data(data31, data32, data33, data34, data35, data36, data37);
				line3.data(dataList.toArray());

				Normal normal41 = new Normal();
				normal41.lineStyle().width(2).color("green").shadowColor("rgba(0,0,0,0.5)").shadowBlur(10).shadowOffsetX(8).shadowOffsetY(8);
				Emphasis emphasis41 = new Emphasis();
				emphasis41.label().show(true);

				Line line4 = new Line();
				line4.name("搜索引擎").symbol(Symbol.emptyCircle);

				line4.itemStyle().normal(normal41).emphasis(emphasis41);

//				Data data41 = new Data();
//				data41.value(620);
//
//				Data data42 = new Data();
//				data42.value(732);
//
//				Data data43 = new Data();
//				data43.value(791);
//
//				Data data44 = new Data();
//				data44.value(734).symbol(Symbol.emptyheart).symbolSize(10);
//
//				Data data45 = new Data();
//				data45.value(890);
//
//				Data data46 = new Data();
//				data46.value(930);
//
//				Data data47 = new Data();
//				data47.value(820);
//				line4.data(data41, data42, data43, data44, data45, data46, data47);
				line4.data(dataList.toArray());

				option.series(line1, line2, line3, line4);
				
				// LINE3
			} else if ("tecsoonLine1_3".equals(echartsName)) {
				
				List<Data> dataList = getDataSourceType1(dbName);
				
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
	    		
	    		List<Data> dataList1 = new ArrayList<Data>();
	    		
	    		int[] valueArr = {120, 132, 301, 134, 90, 230, 210};
	    		
	    		for (int i = 0; i < valueArr.length; i++) {
	    			
	    			Data data11 = null;
	    			if (i == 5) {
	    				data11 = new Data();
	    				data11.value(90).symbol(Symbol.droplet).symbolSize(5);
	    				dataList1.add(data11);
	    			} else {
	    				
	    				data11 = new Data();
	    				data11.value(valueArr[i]);
	    				dataList1.add(data11);
	    			}
	    		}
	    		
//	    		Data data11 = new Data();
//	    		data11.value(120);
//	    		
//	    		Data data12 = new Data();
//	    		data12.value(132);
//	    		
//	    		Data data13 = new Data();
//	    		data13.value(301);
//	    		
//	    		Data data14 = new Data();
//	    		data14.value(134);
//	    		
//	    		Data data15 = new Data();
//	    		data15.value(90).symbol(Symbol.droplet).symbolSize(5);
//	    		
//	    		Data data16 = new Data();
//	    		data16.value(230);
//	    		
//	    		Data data17 = new Data();
//	    		data17.value(210);
//	    		
//	    		dataList1.add(data11);
//	    		dataList1.add(data12);
//	    		dataList1.add(data13);
//	    		dataList1.add(data14);
//	    		dataList1.add(data15);
//	    		dataList1.add(data16);
//	    		dataList1.add(data17);
//	    		line1.data(data11, data12, data13, data14, data15, data16, data17);
	    		line1.data(dataList1);
	    		
	    		
	    		Line line2 = new Line();
	    		line2.name("联盟广告").stack("总量").smooth(true).symbol("image://../asset/ico/favicon.png").symbolSize(8);
	    		
	    		List<Data> dataList2 = new ArrayList<Data>();
	    		
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
	    		dataList2.add(data21);
	    		dataList2.add(data22);
	    		dataList2.add(data23);
	    		dataList2.add(data24);
	    		dataList2.add(data25);
	    		dataList2.add(data26);
	    		dataList2.add(data27);
//	    		line2.data(data21, data22, data23, data24, data25, data26, data27);
	    		line2.data(dataList2);
	    		
	    		List<Data> dataList3 = new ArrayList<Data>();
	    		
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
	    		
	    		dataList3.add(data31);
	    		dataList3.add(data32);
	    		dataList3.add(data33);
	    		dataList3.add(data34);
	    		dataList3.add(data35);
	    		dataList3.add(data36);
	    		dataList3.add(data37);
	    		
	    		line3.symbolRoate(10);
//	    		line3.data(data31, data32, data33, data34, data35, data36, data37);
	    		line3.data(dataList3);
	    		
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
	    		
	    		// BAR1
			} else if ("tecsoonBar1_1".equals(echartsName)) {

				List<Data> dataList = getDataSourceType1(dbName);

				CategoryAxis categoryxAxis = new CategoryAxis();
				categoryxAxis.data(dataList).type(AxisType.category);
				option.xAxis(categoryxAxis);

				CategoryAxis categoryyAxis = new CategoryAxis();
				categoryyAxis.type(AxisType.value);
				option.yAxis(categoryyAxis);

				mychart = new Bar();
				((Bar) mychart).data(dataList);

				option.calculable(true);

				option.series(((Bar) mychart));

				// BAR2
			} else if ("tecsoonBar1_2".equals(echartsName)) {

				List<Data> dataList = getDataSourceType1(dbName);
				
				option.tooltip().trigger(Trigger.axis).axisPointer().type(PointerType.shadow);
				option.calculable(true);

				CategoryAxis categoryxAxis = new CategoryAxis();
				categoryxAxis.boundaryGap(false).data("周一","周二","周三","周四","周五","周六","周日");
				option.xAxis(categoryxAxis);

				CategoryAxis categoryyAxis = new CategoryAxis();
				categoryyAxis.type(AxisType.value);
				categoryyAxis.splitArea().show(true);
				option.yAxis(categoryyAxis);
				Grid grid = new Grid();
				grid.x2(40);

				Bar bar1 = new Bar();
				bar1.name("直接访问").stack("总量").data(320,332,301,334,390,330,320);
				Bar bar2 = new Bar();
				bar2.name("邮件营销").stack("总量").data(120,132,101,134,90,230,210);
				Bar bar3 = new Bar();
				bar3.name("联盟广告").stack("总量").data(220,182,191,234,290,330,310);
				Bar bar4 = new Bar();
				bar4.name("视频广告").stack("总量").data(150,232,201,154,190,330,410);
				Bar bar5 = new Bar();
				bar5.name("搜索引擎").stack("总量").data(820,932,901,934,1290,1330,1320);

				option.series(bar1,bar2,bar3,bar4,bar5);

			} else if ("tecsoonBar1_3".equals(echartsName)) {

				option.grid().borderWidth(0).x(10).x2(10).y(80).y2(60);
				option.calculable(true);

				ValueAxis valueXAxis = new ValueAxis();

				ValueAxis valueYAxis = new ValueAxis();
				valueYAxis.type(AxisType.log);
				valueYAxis.show(false);
				option.yAxis(valueYAxis);

				Bar bar = new Bar();
				List<Data> seriesDataList = new ArrayList<Data>();

				if ("datachange1_1".equals(dbName)) {
					connectorList = connectorDaoService.getConnectorInfo();

					if(connectorList.size() == 0){
						return "";
					}

					for (int i = 0; i < connectorList.size(); i++) {
						ConnectorEntity connectorEntity = connectorList.get(i);
						valueXAxis.type(AxisType.category).show(false).data(connectorEntity.getConnName());
						Data data = new Data();
						data.value(connectorEntity.getNums()).text(connectorEntity.getConnName()).itemStyle().normal()
						.color(getRandColorCode(i)).label().show(true).position(Position.top).formatter("{b}\n{c}");
						seriesDataList.add(data);
					}
				} else if ("datachange1_2".equals(dbName)) {
					entLst = showInfoService.getDiagramCount();

					if(entLst.size() == 0){
						return "";
					}

					String[] str = {"需求管理","业务架构","技术架构","机会和解决方案","迁移规划","实施治理","数据架构","应用组件","应用协作","应用接口","应用服务","应用功能","应用交互"};

					for (int i = 0; i < entLst.size(); i++) {
						DiagramEntity diagramEntity = entLst.get(i);
						valueXAxis.type(AxisType.category).show(false).data(diagramEntity.getDiagramName());
						Data data = new Data();
						data.value(diagramEntity.getNums()).text(diagramEntity.getDiagramName()).itemStyle().normal()
						.color(getRandColorCode(i)).label().show(true).position(Position.top).formatter("{b}\n{c}");
						seriesDataList.add(data);
					}
				}

				bar.barGap("40%");
				bar.barWidth(40);
				bar.data(seriesDataList.toArray());
				option.series(bar);
				option.xAxis(valueXAxis);

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
    
	public List<Data> getDataSourceType1(String dbName) {
		
		List<DiagramEntity> entLst = null;
		List<ConnectorEntity> connectorList = null;

		List<Data> dataList = new ArrayList<Data>();
		
		if ("datachange1_1".equals(dbName)) {
			connectorList = connectorDaoService.getConnectorInfo();

			if(connectorList.size() == 0){
				return new ArrayList<Data>();
			}

			for (int i = 0; i < connectorList.size(); i++) {
				ConnectorEntity sbjEntity = connectorList.get(i);
				Data data = new Data();
				data.name(sbjEntity.getConnName()).value(Integer.valueOf(sbjEntity.getNums())).text(sbjEntity.getConnName());
				dataList.add(data);
			}
		} else if ("datachange1_2".equals(dbName)) {
			entLst = showInfoService.getDiagramCount();

			if(entLst.size() == 0){
				return new ArrayList<Data>();
			}

			String[] str = {"需求管理","业务架构","技术架构","机会和解决方案","迁移规划","实施治理","数据架构","应用组件","应用协作","应用接口","应用服务","应用功能","应用交互"};

			for (int i = 0; i < entLst.size(); i++) {
				DiagramEntity sbjEntity = entLst.get(i);
				Data data = new Data();
				//						data.name(sbjEntity.getDiagramName()).value(Integer.valueOf(sbjEntity.getNums())).text(sbjEntity.getDiagramName());
				//						data.name(str[i]).value(Integer.valueOf(sbjEntity.getNums())).text(str[i]);
				data.name(str[i]).value(Integer.valueOf(sbjEntity.getNums())).symbol(Symbol.star).symbolSize(15).itemStyle().normal().label().show(true).textStyle().fontSize(20).fontFamily("微软雅黑").fontWeight("bold");
				dataList.add(data);
			}
		} else if ("".equals(dbName) || dbName == null) {
			entLst = showInfoService.getDiagramCount();

			if(entLst.size() == 0){
				return new ArrayList<Data>();
			}

			String[] str = {"需求管理","业务架构","技术架构","机会和解决方案","迁移规划","实施治理","数据架构","应用组件","应用协作","应用接口","应用服务","应用功能","应用交互"};

			for (int i = 0; i < entLst.size(); i++) {
				DiagramEntity sbjEntity = entLst.get(i);
				Data data = new Data();
				//						data.name(sbjEntity.getDiagramName()).value(Integer.valueOf(sbjEntity.getNums())).text(sbjEntity.getDiagramName());
				//						data.name(str[i]).value(Integer.valueOf(sbjEntity.getNums())).text(str[i]);
				data.name(str[i]).value(Integer.valueOf(sbjEntity.getNums())).symbol(Symbol.star).symbolSize(15).itemStyle().normal().label().show(true).textStyle().fontSize(20).fontFamily("微软雅黑").fontWeight("bold");
				dataList.add(data);
			}
		}
		
		return dataList;
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
	 * 继承SessionAware接口重写的方法。
	 * @param sessionAttibutes
	 */
	@Override
	public void setSession(Map<String, Object> sessionAttibutes) {
		this.session = sessionAttibutes;
	}
	
	/**  
	 * 获取session  
	 * @return session session  
	 */
	public Map<String, Object> getSession() {
		return session;
	}
}
