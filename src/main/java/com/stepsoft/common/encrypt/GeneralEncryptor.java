package com.stepsoft.common.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.mina.util.Base64;

import com.stepsoft.common.constant.ConstantData;

/***
 * General encryptor, this class can be used to encrypt password or some other
 * context.
 * 
 * @author sam
 *
 */
public class GeneralEncryptor {
	public static final String AES = "AES";
	private static final String KEY1 = "CommonUtil_1@3$5";// Stepsoft_CommonUtil
	private static final String KEY2 = "P@sswo_$d_!23$5^";// Stepsoft_CommonUtil

	/***
	 * Encrypt text
	 * 
	 * @param value
	 *            ，明文
	 * @return 密文
	 */
	public static String encrypt(String value) {
		try {
			IvParameterSpec iv = new IvParameterSpec(
					KEY2.getBytes(ConstantData.CHARSET_UTF8));

			SecretKeySpec skeySpec = new SecretKeySpec(
					KEY1.getBytes(ConstantData.CHARSET_UTF8), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
			byte[] encrypted = cipher.doFinal(value.getBytes());
			System.out.println("encrypted string:"
					+ Base64.encodeBase64(encrypted));
			return new String(Base64.encodeBase64(encrypted),
					ConstantData.CHARSET_UTF8);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/***
	 * Decrypt cipher
	 * 
	 * @param encrypted
	 *            ，密文
	 * @return 明文
	 */
	public static String decrypt(String encrypted) {
		try {
			IvParameterSpec iv = new IvParameterSpec(
					KEY2.getBytes(ConstantData.CHARSET_UTF8));

			SecretKeySpec skeySpec = new SecretKeySpec(
					KEY1.getBytes(ConstantData.CHARSET_UTF8), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted
					.getBytes(ConstantData.CHARSET_UTF8)));

			return new String(original);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
