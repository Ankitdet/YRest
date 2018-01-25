package com.test.ws.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Query;
import org.hibernate.Session;

import com.test.ws.constant.QueryUrlNameConstant;
import com.test.ws.exception.BusinessException;
import com.test.ws.logger.Logger;
import com.test.ws.table.metadata.CLMS;
import com.test.ws.table.metadata.TBLS;

public class ContextListener implements ServletContextListener {

	private static String MODULE = ContextListener.class.getSimpleName();

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		TokenGenerator.tokenMap = new HashMap<String,String>();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		System.out.println("Initializing Logger.....");
		
		// Initialize all QueryParameter when server init....
		QueryUrlNameConstant.initializedQueryParameter();
		
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
			Query query = session
					.createSQLQuery("SELECT "+CLMS.AUTH_TOKEN+" FROM "+TBLS.USER+"");
			List<String> list = query.list();
			for (String str : list) {
				TokenGenerator.tokenMap.put(str, str);
			}
		} catch (BusinessException be) {
			Logger.logError(MODULE, be.getMessage());
		}
	}
}
