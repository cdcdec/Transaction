package com.cdc.transaction.service.impl;

import java.util.List;

import com.cdc.transaction.dao.RoleDao;
import com.cdc.transaction.model.Role;
import com.cdc.transaction.service.RoleService;

public class RoleServiceImpl implements RoleService {

	private RoleDao roleDao;
	
	public RoleServiceImpl(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public List<Role> getRoles() {
		return this.roleDao.findRoles();
	}
	
	
}
