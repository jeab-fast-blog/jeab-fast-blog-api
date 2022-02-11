package me.xueyao.exception;


/**
 * 参数非法
 * 
 * @author 喻聪聪
 * @date   2019-03-07
 */
public class ParamIllegalException extends RuntimeException {
	private static final long serialVersionUID = -1856562982412014245L;

	public ParamIllegalException(String msg) {
		super(msg);
	}
  
  
}

