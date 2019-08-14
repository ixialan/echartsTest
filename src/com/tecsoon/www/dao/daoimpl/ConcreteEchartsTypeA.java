/**
 * 
 */
package com.tecsoon.www.dao.daoimpl;

import com.github.abel533.echarts.series.Pie;
import com.github.abel533.echarts.series.Series;
import com.tecsoon.www.dao.IDiagramType;

/**
 * @author ZEROONE
 *
 */
public class ConcreteEchartsTypeA implements IDiagramType {

	@Override
	public Series<?> getSeries(String param) {
		
		Series<Pie> pie = null;
		
		pie = new Pie();
		return pie;
	}

}
