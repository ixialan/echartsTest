package com.tecsoon.www.common;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

/**
 * 重写BeanUtils.copyProperties
 *
 * @author XXX
 */
public class BeanUtilsExtends extends BeanUtils {
	static {
		ConvertUtils.register(new DateLocaleConverter(),java.util.Date.class);
		ConvertUtils.register(new DateLocaleConverter(),java.sql.Date.class);
		//       ConvertUtils.register(new DateConvert(), java.util.Date.class);
		//       ConvertUtils.register(new DateConvert(), java.sql.Date.class);
	}

	public static void copyProperties(Object dest, Object orig) {
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InvocationTargetException ex) {
			ex.printStackTrace();
		}
	}

}

