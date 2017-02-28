package com.cdc.transaction.service;

import java.util.List;

import com.cdc.transaction.model.Role;

public interface RoleService {

	/**
	 * 查找全部的角色
	 * @return
	 */
	List<Role> getRoles();
}
