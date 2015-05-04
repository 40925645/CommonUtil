package com.stepsoft.common.ideinfiy;

import static org.junit.Assert.*;

import org.junit.Test;

import com.stepsoft.common.ideinfiy.IdentifyCode.SecurityCodeLevel;

public class IdentifyCodeTest {

	@Test
	public void testCreateImage() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetImageAsInputStream() {
		assertTrue(true);
	}

	@Test
	public void testGetSecurityCode() {
		String code=IdentifyCode.getSecurityCode();
		System.out.println(code);
		assertTrue(true);
	}

	@Test
	public void testGetSecurityCodeIntSecurityCodeLevelBoolean() {
		String code=IdentifyCode.getSecurityCode(6, SecurityCodeLevel.Hard, false);
		System.out.println(code);
		assertTrue(true);
	}

}
