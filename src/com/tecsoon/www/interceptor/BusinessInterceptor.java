package com.tecsoon.www.interceptor;

import java.io.IOException;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tecsoon.www.common.TSCommonUtil;
import com.tecsoon.www.exception.BusinessException;

/**
 * 异常转化拦截器
 * 
 * @author XXX
 * 
 */
@SuppressWarnings("serial")
public class BusinessInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		before(invocation);
		String result = "";
		try {
			result = invocation.invoke();
		} catch (NullPointerException e) {
			throw new BusinessException(TSCommonUtil.getExceptionPropertiesText("interceptor.nullpointer"));
		} catch (IOException e) {
			throw new BusinessException(TSCommonUtil.getExceptionPropertiesText("interceptor.io"));
		} catch (ClassNotFoundException e) {
			throw new BusinessException(TSCommonUtil.getExceptionPropertiesText("interceptor.classnotfound"));
		} catch (ArithmeticException e) {
			throw new BusinessException(TSCommonUtil.getExceptionPropertiesText("interceptor.business"));
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new BusinessException(TSCommonUtil.getExceptionPropertiesText("interceptor.arrayindexoutofbounds"));
		} catch (IllegalArgumentException e) {
			throw new BusinessException(TSCommonUtil.getExceptionPropertiesText("interceptor.illegalargument"));
		} catch (ClassCastException e) {
			throw new BusinessException(TSCommonUtil.getExceptionPropertiesText("interceptor.classcast"));
		} catch (SecurityException e) {
			throw new BusinessException(TSCommonUtil.getExceptionPropertiesText("interceptor.security"));
		} catch (SQLException ex) {
			throw new BusinessException(TSCommonUtil.getExceptionPropertiesText("interceptor.sql"));
		} catch (NoSuchMethodError e) {
			throw new BusinessException(TSCommonUtil.getExceptionPropertiesText("interceptor.nosuchmethod"));
		} catch (InternalError e) {
			throw new BusinessException(TSCommonUtil.getExceptionPropertiesText("interceptor.internal"));
		} catch (Exception e) {
			throw new BusinessException(TSCommonUtil.getExceptionPropertiesText("interceptor.exception"));
		}
		after(invocation, result);
		return result;
	}

	/**
	 * 验证登陆等... 
	 * @param invocation
	 * @throws Exception
	 */
	private void before(ActionInvocation invocation) throws Exception {
		// ...
	}

	/**
	 * 记录日志等...
	 * @param invocation
	 * @param result
	 * @throws Exception
	 */
	private void after(ActionInvocation invocation, String result)throws Exception {
		// TODO Auto-generated method stub
	}
}
