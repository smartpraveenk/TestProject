package com.xebia.assignment.service;

/**
 * Use this Factory to retrieve the good Service implementation. Each Service is then
 * called by the method Factory.getInstance().getXXX() where XXX is the name of
 * the Service
 * 
 */
public final class ServiceFactory {

	/**
	 * Current instance of the Factory. Use Singleton pattern
	 */

	private static final ServiceFactory instance = new ServiceFactory();

	/**
	 * Private Constructor
	 */
	private ServiceFactory() {
	}

	/**
	 * Returns the implementation of YakService interface
	 * 
	 * @return YakService
	 */

	public YakService getYakService() {
		return new YakServiceImpl();
	}

	
	/**
	 * Returns current instance of the Factory singleton class. If it does not
	 * exist, creates a new one.
	 * 
	 * @return Factory
	 */
	public static ServiceFactory getInstance() {
			return instance;
	}

}
