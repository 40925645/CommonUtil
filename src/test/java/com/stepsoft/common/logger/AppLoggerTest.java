package com.stepsoft.common.logger;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AppLoggerTest {

	@Test
	public void testDebug() {
		AppLogger.debug(getClass(), "test debug");
		assertTrue(true);
	}

}
