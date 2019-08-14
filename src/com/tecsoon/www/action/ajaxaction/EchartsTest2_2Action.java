/**
 * 
 */
package com.tecsoon.www.action.ajaxaction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.AxisType;
import com.github.abel533.echarts.code.Position;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
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
@Controller("tecsoonecharts-index2_2") // 注释类别名，-struts.xml文件中action的class的名称,添加注释后由spring托管创建
public class EchartsTest2_2Action extends ActionSupport implements ServletRequestAware {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5825023603842712715L;

	private Logger logger = LoggerFactory.getLogger(EchartsTest2_2Action.class);
	
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
    public String ajaxQuery() {
    	
    	logger.info(this.getClass() + ":ajaxQuery() method start!");
    	
    	try {

    		List<DiagramEntity> entLst = showInfoService.getDiagramCount();
    		GsonOption option = new GsonOption();
			option.grid().borderWidth(0).x(10).x2(10).y(80).y2(60);
			option.calculable(true);

			ValueAxis valueXAxis = new ValueAxis();

			ValueAxis valueYAxis = new ValueAxis();
			valueYAxis.type(AxisType.log);
			valueYAxis.show(false);
			option.yAxis(valueYAxis);

			Bar bar = new Bar();
			List<Data> seriesDataList = new ArrayList<Data>();
			if (entLst != null && 0 < entLst.size()) {
				for (int i = 0; i < entLst.size(); i++) {
					DiagramEntity sbjEntity = entLst.get(i);
					valueXAxis.type(AxisType.category).show(false).data(sbjEntity.getDiagramName());
					Data data = new Data();
					data.value(sbjEntity.getNums()).text(sbjEntity.getDiagramName()).itemStyle().normal()
							.color(getRandColorCode(i)).label().show(true).position(Position.top).formatter("{b}\n{c}");
					seriesDataList.add(data);
				}
			}

			bar.barGap("40%");
			bar.barWidth(40);
			bar.data(seriesDataList.toArray());
			option.series(bar);
			option.xAxis(valueXAxis);
    		
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
