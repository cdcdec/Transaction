package com.cdc.transaction.jdbc;

/**
 * jdbc异常类
 * @author yangenxiong
 *
 */
public class JDBCException extends RuntimeException {

	public JDBCException(String message) {
		super(message);
	}
}
