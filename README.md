# byweb
a web project
use   struts2  Developed project 
# 介绍
byweb 是一款基于struts2的招投标管理系统，专注于用户的招投标工作、各招标展示、致力于让招投标线上流程变得简单易用。
# Features
  高性能.
  多线程.
  多图层叠加.
  友好的 API.

# 示例
cache示例
<beans
	xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xmlns:ehcache="http://ehcache-spring-annotations.googlecode.com/svn/schema/ehcache-spring"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
		http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
		http://ehcache-spring-annotations.googlecode.com/svn/schema/ehcache-spring   
  		http://ehcache-spring-annotations.googlecode.com/svn/schema/ehcache-spring/ehcache-spring-1.1.xsd">
		
		<!-- <ehcache:annotation-driven cache-manager="ehCacheManager" />  -->
 
 		<bean id="ehCacheManager" class="org.springframework.cache.ehcache.EhCacheManagerFactoryBean">  
       		<property name="configLocation" value="classpath:ehcache.xml" />  
   		</bean> 
   		
</beans>
