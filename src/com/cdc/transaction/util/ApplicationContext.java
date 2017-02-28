package com.cdc.transaction.util;

import com.cdc.transaction.dao.CommentDao;
import com.cdc.transaction.dao.LogDao;
import com.cdc.transaction.dao.RoleDao;
import com.cdc.transaction.dao.TransactionDao;
import com.cdc.transaction.dao.UserDao;
import com.cdc.transaction.dao.UserTransferDao;
import com.cdc.transaction.dao.impl.CommentDaoImpl;
import com.cdc.transaction.dao.impl.LogDaoImpl;
import com.cdc.transaction.dao.impl.RoleDaoImpl;
import com.cdc.transaction.dao.impl.TransactionDaoImpl;
import com.cdc.transaction.dao.impl.UserDaoImpl;
import com.cdc.transaction.dao.impl.UserTransferDaoImpl;
import com.cdc.transaction.model.User;
import com.cdc.transaction.service.CommentService;
import com.cdc.transaction.service.RoleService;
import com.cdc.transaction.service.TransactionService;
import com.cdc.transaction.service.UserService;
import com.cdc.transaction.service.impl.CommentServiceImpl;
import com.cdc.transaction.service.impl.RoleServiceImpl;
import com.cdc.transaction.service.impl.TransactionServiceImpl;
import com.cdc.transaction.service.impl.UserServiceImpl;

/**
 * 应用上下文
 * @author yangenxiong yangenxiong2009@gmail.com
 * @version  1.0
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br>Copyright (C), 2009-2010, yangenxiong
 * <br>This program is protected by copyright laws.
 */
public class ApplicationContext {

	//系统登录用户
	public static User loginUser;

	public static UserDao userDao;
	
	public static RoleDao roleDao;
	
	public static RoleService roleService;
	
	public static UserService userService;
	
	public static TransactionDao transactionDao;
	
	public static TransactionService transactionService;
	
	public static CommentDao commentDao;
	
	public static CommentService commentService;
	
	public static UserTransferDao userTransferDao;
	
	public static LogDao logDao;
	
	static {
		logDao = new LogDaoImpl();
		roleDao = new RoleDaoImpl();
		roleService = new RoleServiceImpl(roleDao);
		userDao = new UserDaoImpl();
		userTransferDao = new UserTransferDaoImpl();
		userService = new UserServiceImpl(userDao, roleDao);
		transactionDao = new TransactionDaoImpl();
		commentDao = new CommentDaoImpl();
		transactionService = new TransactionServiceImpl(transactionDao, userDao, 
				commentDao, userTransferDao, logDao);
		
		commentService = new CommentServiceImpl(commentDao, transactionDao, userDao);
	}

}
