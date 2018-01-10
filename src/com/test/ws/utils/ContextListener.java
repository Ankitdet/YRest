package com.test.ws.utils;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.test.ws.exception.BusinessException;
import com.test.ws.logger.Logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import com.test.ws.logger.Log4jLogger;

import org.hibernate.Query;
import org.hibernate.Session;


public class ContextListener implements ServletContextListener{

	private static String MODULE = ContextListener.class.getSimpleName();

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		System.out.println("Initializing Logger.....");
		String contextPath = sce.getServletContext().getRealPath("");

		ServletContext servletContext = sce.getServletContext();
		String log4jFile = servletContext.getInitParameter("log4jFileName");
		System.out.println("log4j configuration file:'" + log4jFile + "'");
		String fullPath = contextPath + File.separator + log4jFile;
		PropertyConfigurator.configure(fullPath);
		initilizeTokenList();
	}
	private void initilizeTokenList() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createSQLQuery("select auth_token from users");
			List<String> list = query.list();
			for(String str : list) {
				TokenGenerator.tokenMap.put(str,str);
			}
		} catch (BusinessException be) {
			Logger.logError(MODULE, be.getMessage());
		}
	}
}
