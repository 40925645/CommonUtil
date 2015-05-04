package com.stepsoft.common.encrypt;

import java.security.MessageDigest;

/***
 * 
 * @author Sam <br />
 *         加密工具类
 *
 */
public class MD5Encrypter {

	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/***
	 * 使用MD5进行加密
	 * 
	 * @param text
	 *            , 需要加密的文字
	 * @return, md5密文
	 */
	public static String encrypt(String text) {
		byte[] input = text.getBytes();
		return encrypt(input);
	}

	/***
	 * 使用MD5进行加密
	 * 
	 * @param input
	 *            ,需要加密的byte数组
	 * @return,md5密文
	 */
	public static String encrypt(byte[] input) {
		try {
			// 获得MD5摘要算法的 MessageDigest对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(input);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = HEX_DIGITS[byte0 >>> 4 & 0xf];
				str[k++] = HEX_DIGITS[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
