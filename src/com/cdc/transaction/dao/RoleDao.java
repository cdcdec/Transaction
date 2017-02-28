package com.cdc.transaction.dao;

import java.util.List;

import com.cdc.transaction.model.Role;

public interface RoleDao {

	/**
	 * 根据ID查找角色
	 * @param id
	 * @return
	 */
	Role find(String id);
	
	/**
	 * 查找全部的角色
	 * @return
	 */
	List<Role> findRoles();
}
