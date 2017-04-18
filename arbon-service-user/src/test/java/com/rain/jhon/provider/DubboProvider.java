package com.rain.jhon.provider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>功能描述</br> 启动Dubbo服务用的MainClass</p>
 * @className  DubboProvider
 * @author  jhonrain
 * @date  2017年4月18日 下午5:52:01
 * @version  v1.0
 */
public class DubboProvider {
	
	private static final Log log = LogFactory.getLog(DubboProvider.class);

    public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
			context.start();
		} catch (Exception e) {
			log.error("== DubboProvider context start error:",e);
		}
		synchronized (DubboProvider.class) {
			while (true) {
				try {
					DubboProvider.class.wait();
				} catch (InterruptedException e) {
					log.error("== synchronized error:",e);
				}
			}
		}
	}
    
}