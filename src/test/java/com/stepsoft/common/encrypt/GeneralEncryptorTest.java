package com.stepsoft.common.encrypt;

import static org.junit.Assert.*;

import org.junit.Test;

public class GeneralEncryptorTest {

	@Test
	public void testEncrypt() {
		String text = "stepsoft_redis_P@ssword";
		String encrypted = GeneralEncryptor.encrypt(text);
		System.out.println(encrypted);
		String actual = GeneralEncryptor.decrypt(encrypted);
		System.out.println(actual);
		assertEquals(text, actual);
	}

}
