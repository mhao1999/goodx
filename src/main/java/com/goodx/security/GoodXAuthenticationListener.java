package com.goodx.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationListener;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoodXAuthenticationListener implements AuthenticationListener {
	
	private static final Logger logger = LoggerFactory.getLogger(GoodXAuthenticationListener.class);

	@Override
	public void onSuccess(AuthenticationToken token, AuthenticationInfo info) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFailure(AuthenticationToken token, AuthenticationException ae) {
		// TODO Auto-generated method stub
		logger.debug("login failed!");
	}

	@Override
	public void onLogout(PrincipalCollection principals) {
		// TODO Auto-generated method stub

	}

}
