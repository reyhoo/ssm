package com.yl.spring.aop.verifier.impl;

import com.yl.spring.aop.verifier.RoleVerifier;
import com.yl.spring.pojo.Role;

public class RoleVerifierImpl implements RoleVerifier {

	@Override
	public boolean verify(Role role) {
		return role != null;
	}

}
