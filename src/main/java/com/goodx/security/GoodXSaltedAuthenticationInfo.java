package com.goodx.security;

import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class GoodXSaltedAuthenticationInfo implements SaltedAuthenticationInfo {
	
	private static final long serialVersionUID = 1L;

	private final String userName;
	private final String password;
	private final String salt;
	
	public GoodXSaltedAuthenticationInfo(String userName, String password, String salt) {
		// TODO Auto-generated constructor stub
		this.userName = userName;
		this.password = password;
		this.salt = salt;
	}
	
	@Override
	public PrincipalCollection getPrincipals() {
		// TODO Auto-generated method stub
		PrincipalCollection coll = new SimplePrincipalCollection(this.userName, this.userName);
		return coll;
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public ByteSource getCredentialsSalt() {
		// TODO Auto-generated method stub
		return new SimpleByteSource(Base64.decode(salt));
	}

}
