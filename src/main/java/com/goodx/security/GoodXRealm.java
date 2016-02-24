package com.goodx.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.jdbc.JdbcRealm;

import com.goodx.models.GoodXUser;
import com.goodx.services.GoodXUserService;

public class GoodXRealm extends JdbcRealm {

	private GoodXUserService userService;
	
	public GoodXRealm(GoodXUserService userService) {
		// TODO Auto-generated constructor stub
		super();
		this.userService = userService;
	}
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
		
		UsernamePasswordToken userPassToken = (UsernamePasswordToken) token;
		final String userName = userPassToken.getUsername();
		
		if (userName == null) {
			System.out.println("Username is null.");
			return null;
		}
		
		final GoodXUser user = this.userService.getByEmail(userName);
		
		if (user == null) {
			System.out.println("No account found for user [" + userName + "]");
			return null;
		}
		
		SaltedAuthenticationInfo info = new GoodXSaltedAuthenticationInfo(userName, user.getPassword(), user.getSalt());
				
		return info;		
	}
}
