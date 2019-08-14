package com.tecsoon.www.exception;

import java.io.IOException;

import com.tecsoon.www.common.TSCommonUtil;

/**
 * 自定义业务异常类,避免所有地方都加上try/catch
 * 
 * @author XXX
 * 
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * 构造函数
	 * 
	 * @param frdMessage
	 *            异常信息
	 */
	public BusinessException(String frdMessage) {
		super(createFriendlyErrMsg(frdMessage));
	}

	/**
	 * 构造函数重载
	 * @param throwable
	 */
	public BusinessException(Throwable throwable){
		super(throwable);
	}
	
	public BusinessException(Throwable throwable,String frdMsg){
		super(throwable);
	}
	
	/**
	 * 产生友好异常信息
	 * 
	 * @param frdMessage
	 *            异常信息
	 * @return 友好异常信息
	 * @throws IOException 
	 */
	private static String createFriendlyErrMsg(String frdMessage) {
		String prefixStr = TSCommonUtil.getExceptionPropertiesText("global.exception.srry");
		String suffixStr = TSCommonUtil.getExceptionPropertiesText("global.exception.info");
		StringBuffer friendlyErrMsg = new StringBuffer();
		friendlyErrMsg.append(prefixStr);
		friendlyErrMsg.append(frdMessage);
		friendlyErrMsg.append(suffixStr);
		return friendlyErrMsg.toString();
	}
}
