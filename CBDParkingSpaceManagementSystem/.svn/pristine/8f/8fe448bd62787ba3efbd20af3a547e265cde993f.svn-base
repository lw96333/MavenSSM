package com.java.shiro;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import lombok.extern.log4j.Log4j;

/**
 * 
 * @author 罗维 自定义Authenticator
 *         注意，当需要分别定义处理普通用户和管理员验证的Realm时，对应Realm的全类名应该包含字符串“User”，或者“Admin”。
 *         并且，他们不能相互包含，例如，处理普通用户验证的Realm的全类名中不应该包含字符串"Admin"。 2019年3月23日
 */
@Log4j
public class CustomizedModularRealmAuthenticator extends ModularRealmAuthenticator {

	@Override
	protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		log.info("进入自定义Authenticator");
		// 判断getRealms()是否返回为空
		assertRealmsConfigured();
		// 强制转换回自定义的CustomizedToken
		CustomizedToken customizedToken = (CustomizedToken) authenticationToken;
		// 登录类型
		String loginType = customizedToken.getLoginType();
		// 所有Realm
		Collection<Realm> realms = getRealms();
		log.info("所有Realm数量：" + realms.size());
		// 登录类型对应的所有Realm
		Collection<Realm> typeRealms = new ArrayList<Realm>();
		for (Realm realm : realms) {
			log.info("realm.getName():" + realm.getName());
			log.info("loginType" + loginType);
			if (realm.getName().contains(loginType)) {
				typeRealms.add(realm);
			}
		}

		// 判断是单Realm还是多Realm
		if (typeRealms.size() == 1) {
			return doSingleRealmAuthentication(typeRealms.iterator().next(), customizedToken);
		} else {
			return doMultiRealmAuthentication(typeRealms, customizedToken);
		}
	}

}