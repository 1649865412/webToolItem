package com.coderdream.log4jDao;

import org.apache.log4j.Logger;

public class HelloDao {
	private static Logger logger = Logger.getLogger(HelloDao.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 记录debug级别的信息
		if (logger.isDebugEnabled()) {
			logger.debug("This is debug message from Dao.");
		}

		// 记录info级别的信息
		if (logger.isInfoEnabled()) {
			logger.info("This is info message from Dao.");
		}

		// 记录error级别的信息
		logger.error("This is error message from Dao.");
	}
}