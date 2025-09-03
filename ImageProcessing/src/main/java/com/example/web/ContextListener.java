package com.example.web;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.example.processors.FilterManager;
import com.example.util.Util;

/**
 * This listener loads the filters to memory when the application is deployed.
 * @author gloria.figueroa
 */
@WebListener
public class ContextListener implements ServletContextListener{

	private static final Logger LOGGER = Logger.getLogger(ContextListener.class.getName());
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) { }
 
	/**
	 * Loads the filters to memory when the context is initialized.
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		FilterManager.getInstance().loadFilters(Util.getFiltersList());
		LOGGER.info("Filters were loaded correctly");
	}
	
}
