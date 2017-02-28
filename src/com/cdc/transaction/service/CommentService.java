package com.cdc.transaction.service;

import com.cdc.transaction.model.Comment;

public interface CommentService {

	/**
	 * 保存一个事务评论
	 * @param comment 评论对象
	 */
	void save(Comment comment);
}
