package com.cdc.transaction.ui.handler.impl;

import com.cdc.transaction.model.Comment;
import com.cdc.transaction.ui.handler.TransactionHandler;
import com.cdc.transaction.util.ApplicationContext;

/**
 * 完成事务处理类
 * @author yangenxiong yangenxiong2009@gmail.com
 * @version  1.0
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br>Copyright (C), 2009-2010, yangenxiong
 * <br>This program is protected by copyright laws.
 */
public class FinishHandler implements TransactionHandler {

	public void handler(Comment comment) {
		//将事务状态改变为完成, 再添加评论
		ApplicationContext.transactionService.finish(comment.getTRANSACTION_ID(), 
				comment.getUSER_ID(), comment);
	}

}
