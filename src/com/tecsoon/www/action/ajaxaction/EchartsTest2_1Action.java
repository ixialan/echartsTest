/**
 * 
 */
package com.tecsoon.www.action.ajaxaction;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.github.abel533.echarts.code.Position;
import com.github.abel533.echarts.code.SelectedMode;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Pie;
import com.github.abel533.echarts.style.itemstyle.Normal;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * @author ZEROONE
 *
 */
@Scope("request")
@Controller("tecsoonecharts-index2_1") // 注释类别名，-struts.xml文件中action的class的名称,添加注释后由spring托管创建
public class EchartsTest2_1Action extends ActionSupport implements ServletRequestAware {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4819130203782677695L;

	private Logger logger = LoggerFactory.getLogger(EchartsTest2_1Action.class);
	
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
	
	private String dataType = "";
	
	/**
     * 处理AJAX请求
     * @return SUCCESS
     */
    public String ajaxQuery() {
    	
    	logger.info(this.getClass() + ":ajaxQuery() method start!");
    	
    	try {

//    		JSONObject cName = JSONObject.fromObject(typeName);
//    		String tName = (String) cName.get("cname");
//    		
//    		String[] types = { "邮件营销", "联盟广告", "视频广告" };
//
//    		int[] datas = { 120, 132, 101 };
//    		String title = "广告数据";
//    		GsonOption option = new GsonOption();
//
//    		// 提示工具 鼠标在每一个数据项上，触发显示提示数据
//    		option.tooltip().enterable(true).trigger(Trigger.item).backgroundColor("#AB82FF");//.formatter("{a} <br/>{b} : {c} ({d}%)");
//
//    		option.legend().orient(Orient.vertical).x(X.left).selectedMode("singel").data("更改图形", "更改数据源", "自定义按钮");
//
//    		option.calculable(true);// 拖动进行计算
//
//    		Pie pie = DiagramTypeFactory.createDiagramType(tName);
//
//    		// 标题、半径、位置
//    		pie.name(title).radius("55%").center("50%", "60%");
//
//    		// 循环数据
//    		for (int i = 0; i < types.length; i++) {
//    			Map<String, Object> map = new HashMap<String, Object>(2);
//    			map.put("value", datas[i]);
//    			map.put("name", types[i]);
//    			pie.data(map);
//    		}
//
//    		option.series(pie);
//
//    		result = option.toPrettyString();
    		GsonOption option = new GsonOption();
    		
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
     		
//     		Data[] dataArr = new Data[7];
     		Data[] dataArr = {new Data(), new Data(), new Data(), new Data(), new Data(), new Data()};
     		
     		Data data11 = new Data();
     		data11.value(335).name("直达").selected(true);
     		
     		dataArr[0] = data11;
     		
     		Data data12 = new Data();
     		data12.value(679).name("营销广告");
     		
     		Data data13 = new Data();
     		data13.value(1548).name("搜索引擎");
		    
     		pie.data(data11, data12, data13);
            
    		Pie pie1 = new Pie();
    		pie1.name("访问来源");
    		pie1.radius("40%", "55%");
    		
    		Data data21 = new Data();
    		data21.value(335).name("直达");
    		
    		Data data22 = new Data();
    		data22.value(310).name("邮件营销歌");
    		
    		Data data23 = new Data();
    		data23.value(234).name("联盟广告");
    		
    		Data data24 = new Data();
    		data24.value(145).name("视频广告");
    		
    		Data data25 = new Data();
    		data25.value(1048).name("百度");
    		
    		Data data26 = new Data();
    		data26.value(251).name("谷歌");
    		
    		Data data27 = new Data();
    		data27.value(147).name("必应");
    		
    		Data data28 = new Data();
    		data28.value(102).name("其他");
    		
    		pie1.data(data21, data22, data23, data24, data25, data26, data27, data28);
    		
    		option.series(pie, pie1);
    		
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
