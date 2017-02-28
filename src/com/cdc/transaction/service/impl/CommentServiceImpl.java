package com.cdc.transaction.service.impl;

import java.util.Date;

import com.cdc.transaction.dao.CommentDao;
import com.cdc.transaction.dao.TransactionDao;
import com.cdc.transaction.dao.UserDao;
import com.cdc.transaction.model.Comment;
import com.cdc.transaction.service.CommentService;
import com.cdc.transaction.util.ViewUtil;

public class CommentServiceImpl implements CommentService {

	private CommentDao commentDao;
	
	private TransactionDao transactionDao;
	
	private UserDao userDao;
	
	public CommentServiceImpl(CommentDao commentDao, TransactionDao transactionDao, 
			UserDao userDao) {
		this.commentDao = commentDao;
		this.transactionDao = transactionDao;
		this.userDao = userDao;
	}
	
	public void save(Comment comment) {
		this.commentDao.save(comment);
	}

}
