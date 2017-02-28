package com.cdc.transaction.dao;

import com.cdc.transaction.model.Comment;

public interface CommentDao {

	/**
	 * 保存一个事务评论
	 * @param comment
	 */
	Integer save(Comment comment);
	
	/**
	 * 根据ID查找评论
	 * @param id
	 * @return
	 */
	Comment find(String id);
}
