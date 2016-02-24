package com.goodx.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.sql.DataSource;

import org.apache.shiro.authc.AuthenticationListener;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.goodx.security.GoodXAuthenticationListener;
import com.goodx.security.GoodXRealm;
import com.goodx.services.GoodXUserService;

@Configuration
@ComponentScan({"com.goodx.services", "com.goodx.repository"})
public class GoodXWebSecurityConfig {

	private static final Logger logger = LoggerFactory.getLogger(GoodXWebSecurityConfig.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private GoodXUserService goodXUserService;
	
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilter() {
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		Map<String, String> filterChainDefinitionMapping = new HashMap<String, String>(); 
		filterChainDefinitionMapping.put("/login.jsp", "authc");
		filterChainDefinitionMapping.put("/logout", "logout");
		filterChainDefinitionMapping.put("/**", "anon");
		shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMapping);

		shiroFilter.setSecurityManager(securityManager());
		//shiroFilter.setLoginUrl("/login.jsp");
		logger.debug("remove this line");

		
		Map<String, Filter> filters = new HashMap<>();
		filters.put("anon", new AnonymousFilter());
		FormAuthenticationFilter authenticationFilter = new FormAuthenticationFilter();
		authenticationFilter.setLoginUrl("/login.jsp");
		authenticationFilter.setSuccessUrl("/home");
		
		filters.put("authc", authenticationFilter);
		LogoutFilter logoutFilter = new LogoutFilter();
		logoutFilter.setRedirectUrl("/login?logout");
		filters.put("logout", logoutFilter);
		filters.put("roles", new RolesAuthorizationFilter());
		filters.put("user", new UserFilter());
		shiroFilter.setFilters(filters);
		
		
		return shiroFilter;
	}
	
	@SuppressWarnings("serial")
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(jdbcRealm());

		ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
		authenticator.setAuthenticationListeners(new ArrayList<AuthenticationListener>(){{
			add(new GoodXAuthenticationListener());
			}});
		securityManager.setAuthenticator(authenticator);
		return securityManager;
	}
	
	@Bean(name = "realm")
	@DependsOn("lifecycleBeanPostProcessor")
	public JdbcRealm jdbcRealm() {
		JdbcRealm realm = new GoodXRealm(this.goodXUserService);
		HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
		credentialsMatcher.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
		credentialsMatcher.setStoredCredentialsHexEncoded(false);
		credentialsMatcher.setHashIterations(1024);
		realm.setCredentialsMatcher(credentialsMatcher);
		realm.setDataSource(dataSource);
		realm.setUserRolesQuery("select rolename from goodx_user_roles where email = ?");
		realm.setAuthenticationQuery("select password from goodx_users where username = ?");
		realm.setPermissionsQuery("select permission from goodx_roles_permissions where rolename = ?");
		realm.init();
		return realm;
	}
	
	@Bean 
	public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
}
