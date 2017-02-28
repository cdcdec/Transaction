package com.cdc.transaction.ui.handler.impl;

import com.cdc.transaction.model.Comment;
import com.cdc.transaction.ui.handler.TransactionHandler;
import com.cdc.transaction.util.ApplicationContext;

public class ForAWhileHandler implements TransactionHandler {


	public void handler(Comment comment) {
		//将事务置为暂时不做状态, 需要先设置事务的状态, 再添加评论
		ApplicationContext.transactionService.forAWhile(comment.getTRANSACTION_ID(), 
				comment.getUSER_ID(), comment);
//		ApplicationContext.commentService.save(comment);
	}

}
