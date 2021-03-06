package com.java.config;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.java.shiro.BackstageRealm;
import com.java.shiro.CustomizedModularRealmAuthenticator;
import com.java.shiro.FortendRealm;

import lombok.extern.log4j.Log4j;
/**
 * shiro配置
 * @author 罗维
 *
 * 2019年3月19日
 */
@Configuration
@Log4j
public class ShiroConfig {
	
	 /**
	     * LifecycleBeanPostProcessor，这是个DestructionAwareBeanPostProcessor的子类，
	     * 负责org.apache.shiro.util.Initializable类型bean的生命周期的，初始化和销毁。
	     * 主要是AuthorizingRealm类的子类，以及EhCacheManager类。
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }


    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        log.info("加载shirFilter");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String,String> filterChainDefinitionMap = new LinkedHashMap();
        //注意过滤器配置顺序 不能颠倒
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了，登出后跳转配置的loginUrl
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/jsp/SelectLogin.jsp", "anon");
        filterChainDefinitionMap.put("/jsp/BackLogin.jsp", "anon");
        filterChainDefinitionMap.put("/jsp/FortendLogin.jsp", "anon");
        filterChainDefinitionMap.put("/backLogin", "anon");
        filterChainDefinitionMap.put("/fortendLogin", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/images/**", "anon");
        filterChainDefinitionMap.put("/lib/**", "anon");
        filterChainDefinitionMap.put("/share/**", "anon");
        filterChainDefinitionMap.put("/jsp/fortend/Enroll.jsp", "anon");
        filterChainDefinitionMap.put("/insertPersonage", "anon");
        filterChainDefinitionMap.put("/jsp/index-temporary.jsp", "anon");
        filterChainDefinitionMap.put("/jsp/SaleOfParkingSpaceHomePage.jsp", "anon");
        filterChainDefinitionMap.put("/jsp/CarRentalFrontPage.jsp", "anon");
        filterChainDefinitionMap.put("/showAllParkingInfo", "anon");
        filterChainDefinitionMap.put("/selectAllSellCar", "anon");
        filterChainDefinitionMap.put("/jsp/jurisdiction.jsp", "anon");
        //拦截其他所以接口
        //后台
        filterChainDefinitionMap.put("/jsp/backstage/**", "roles[admin]");
        filterChainDefinitionMap.put("/super/**", "perms[admin:super]");

        //前台
        filterChainDefinitionMap.put("/jsp/fortend/**", "roles[user]");
        filterChainDefinitionMap.put("/**", "user");
        
//        配置shiro默认登录界面地址，前后端分离中登录界面跳转应由前端路由控制，后台仅返回json数据
        shiroFilterFactoryBean.setLoginUrl("/jsp/SelectLogin.jsp");
//         登录成功后要跳转的链接 自行处理。不用shiro进行跳转
//         shiroFilterFactoryBean.setSuccessUrl("/returnLogin");
        //未授权界面;
         shiroFilterFactoryBean.setUnauthorizedUrl("/jsp/jurisdiction.jsp");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
    



    /**
     * shiro 用户数据注入
     * @return
     */
    @Bean
    public BackstageRealm shiroRealm(){
    	log.info("加载shiroRealm");
    	BackstageRealm shiroRealm = new BackstageRealm();
        return shiroRealm;
    }
    
    @Bean
    public FortendRealm shiroFRealm(){
    	log.info("加载shiroFRealm");
    	FortendRealm shiroRealm = new FortendRealm();
        return shiroRealm;
    }
    
    /**
     * cookie对象;
     * rememberMeCookie()方法是设置Cookie的生成模版，比如cookie的name，cookie的有效时间等等。
     * @return
    */
   @Bean
   public SimpleCookie rememberMeCookie(){
	   	 log.info("加载rememberMeCookie");
         //System.out.println("ShiroConfiguration.rememberMeCookie()");
         //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
         SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
         //<!-- 记住我cookie生效时间30天 ,单位秒;-->
         simpleCookie.setMaxAge(259200);
         return simpleCookie;
   }

   /**
     * cookie管理对象;
     * rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中
     * @return
    */
   @Bean
   public CookieRememberMeManager rememberMeManager(){
         //System.out.println("ShiroConfiguration.rememberMeManager()");
         CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
         cookieRememberMeManager.setCookie(rememberMeCookie());
         //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
         cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
         return cookieRememberMeManager;
   }
   
	 /**
	 * EhCacheManager，缓存管理，用户登陆成功后，把用户信息和权限信息缓存起来，
	 * 然后每次用户请求时，放入用户的session中，如果不设置这个bean，每个请求都会查询一次数据库。
	 */
	@Bean(name = "ehCacheManager")
	@DependsOn("lifecycleBeanPostProcessor")
	public EhCacheManager ehCacheManager() {
	    return new EhCacheManager();
	}


    @Bean(name = "securityManager")
    public SecurityManager securityManager() {
    	log.info("加载securityManager");
    	
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置realm.
        //securityManager.setRealm(adminRealm());
        //设置多realm
        List<Realm> realms = new ArrayList<Realm>();
        realms.add(shiroFRealm());
        realms.add(shiroRealm());
        securityManager.setRealms(realms);

        securityManager.setAuthenticator(customizedModularRealmAuthenticator());

        //缓存
        securityManager.setCacheManager(ehCacheManager());

        //注入记住我管理器;
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }
    /**
     * 配置使用自定义认证器，可以实现多Realm认证，并且可以指定特定Realm处理特定类型的验证
     * @return
     */
    @Bean
    public CustomizedModularRealmAuthenticator customizedModularRealmAuthenticator(){
    	CustomizedModularRealmAuthenticator customizedModularRealmAuthenticator = new CustomizedModularRealmAuthenticator();
    	log.info("加载customizedModularRealmAuthenticator");
    	//配置认证策略，只要有一个Realm认证成功即可，并且返回所有认证成功信息
    	customizedModularRealmAuthenticator.setAuthenticationStrategy(new FirstSuccessfulStrategy());
    	List<Realm> realms = new ArrayList<Realm>();
    	realms.add(shiroFRealm());
    	realms.add(shiroRealm());
    	customizedModularRealmAuthenticator.setRealms(realms);
 
    	return  customizedModularRealmAuthenticator;
    }
  
    
    
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
    	log.info("加载advisorAutoProxyCreator");
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }
    /**
     * 开启shiro aop注解支持 使用代理方式所以需要开启代码支持
     *  一定要写入上面advisorAutoProxyCreator（）自动代理。不然AOP注解不会生效
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
    	log.info("加载authorizationAttributeSourceAdvisor");
    	AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
