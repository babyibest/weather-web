/**
 * CryptTool 封装了一些加密工具方�? 包括 3DES, MD5 �?
 *
 * @author ted
 * @version 1.0
 * 2004-05-12
 */

package com.by.base.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
 

public class CryptTool {

	public CryptTool() {
	}

	/**
	 * 生成3DES密钥.
	 * 
	 * @param key_byte
	 *            seed key (must 24bit)
	 * @throws Exception
	 * @return javax.crypto.SecretKey Generated DES key
	 */
	public static javax.crypto.SecretKey genDESKey(byte[] key_byte)
			throws Exception {
		SecretKey k = null;
		k = new SecretKeySpec(key_byte, "DESede");
		return k;
	}

	/**
	 * 3DES 解密(byte[]).
	 * 
	 * @param key
	 *            SecretKey
	 * @param crypt
	 *            byte[]
	 * @throws Exception
	 * @return byte[]
	 */
	public static byte[] desDecrypt(javax.crypto.SecretKey key, byte[] crypt)
			throws Exception {
		Cipher cipher = Cipher.getInstance("DESede");
		cipher.init(Cipher.DECRYPT_MODE, key);
		return cipher.doFinal(crypt);
	}

	/**
	 * 3DES 解密(String).
	 * 
	 * @param key
	 *            SecretKey
	 * @param crypt
	 *            byte[]
	 * @throws Exception
	 * @return byte[]
	 */
	public static String desDecrypt(javax.crypto.SecretKey key, String crypt)
			throws Exception {
		return new String(desDecrypt(key, crypt.getBytes()));
	}

	/**
	 * 3DES加密(byte[]).
	 * 
	 * @param key
	 *            SecretKey
	 * @param src
	 *            byte[]
	 * @throws Exception
	 * @return byte[]
	 */
	public static byte[] desEncrypt(javax.crypto.SecretKey key, byte[] src)
			throws Exception {
		Cipher cipher = Cipher.getInstance("DESede");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		return cipher.doFinal(src);
	}

	/**
	 * 3DES加密(String).
	 * 
	 * @param key
	 *            SecretKey
	 * @param src
	 *            byte[]
	 * @throws Exception
	 * @return byte[]
	 */
	public static String desEncrypt(javax.crypto.SecretKey key, String src)
			throws Exception {
		return new String(desEncrypt(key, src.getBytes()));
	}

	/**
	 * MD5 摘要计算(String).
	 * 
	 * @param src
	 *            String
	 * @throws Exception
	 * @return String
	 */
	public static byte[] md5Digest16(String src) throws Exception {
		MessageDigest alg = java.security.MessageDigest
				.getInstance("MD5");
		return alg.digest(src.getBytes());
	}

	/**
	 * MD5加密
	 * 
	 * @param src
	 *            要加密的字符�?
	 * @return String 加密后的字符�?
	 */
	public static String md5Digest(String src) throws Exception {
		String resultString = null;
		try {
			resultString = new String(src);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString
					.getBytes()));
		} catch (Exception ex) {
		}
		return resultString;
	}

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * 转换字节数组�?6进制字串
	 * 
	 * @param b
	 *            字节数组
	 * @return 16进制字串
	 */
	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * BASE64 编码.
	 * 
	 * @param src
	 *            String inputed string
	 * @return String returned string
	 */
	public static String base64Encode(String src) {
	//	BASE64Encoder encoder = new BASE64Encoder();

	//	return encoder.encode(src.getBytes());
		return  null;  //重写
	}

	/**
	 * BASE64 编码(byte[]).
	 * 
	 * @param src
	 *            byte[] inputed string
	 * @return String returned string
	 */
	public static String base64Encode(byte[] src) {
	//	BASE64Encoder encoder = new BASE64Encoder();

	//	return encoder.encode(src);
		return  null;   //重写
	}

	/**
	 * BASE64 解码.
	 * 
	 * @param src
	 *            String inputed string
	 * @return String returned string
	 */
	public static String base64Decode(String src) {
		//BASE64Decoder decoder = new BASE64Decoder();

		try {
			return null; // new String(decoder.decodeBuffer(src));
		} catch (Exception ex) {
			return null;
		}

	}

	/**
	 * BASE64 解码(to byte[]).
	 * 
	 * @param src
	 *            String inputed string
	 * @return String returned string
	 */
	public static byte[] base64DecodeToBytes(String src) {
		//BASE64Decoder decoder = new BASE64Decoder();

		try {
			return  null; //decoder.decodeBuffer(src);
		} catch (Exception ex) {
			return null;
		}

	}

	/**
	 * 对给定字符进�?URL 编码.
	 * 
	 * @param src
	 *            String
	 * @return String
	 */
	public static String urlEncode(String src) {
		try {
			src = URLEncoder.encode(src, "GB2312");

			return src;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return src;
	}

	/**
	 * 对给定字符进�?URL 解码
	 * 
	 * @param value
	 *            解码前的字符�?
	 * @return 解码后的字符�?
	 */
	public String urlDecode(String value) {
		try {
			return URLDecoder.decode(value, "GB2312");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/** Test crypt */
	public static void main(String[] args) {
		byte src_byte[] = "1234567812345678".getBytes();
		System.out.println(src_byte.length);
		byte key_byte[] = "123456781234567812345678".getBytes();
		// 3DES 24 bytes key

		try {
			// 生成DES密钥
			javax.crypto.SecretKey deskey;
			// 生成DES密钥
			// javax.crypto.KeyGenerator key =
			// javax.crypto.KeyGenerator.getInstance(
			// "DES");
			// key.init(56);
			// deskey = key.generateKey();

			deskey = genDESKey(key_byte);
			System.out.println("Generator DES KEY OK");

			// DES加解�?
			byte[] encrypt, decrypt;
			// 加密
			encrypt = desEncrypt(deskey, src_byte);
			System.out.println("encrypt=" + new String(encrypt));
			// 解密
			decrypt = desDecrypt(deskey, encrypt);
			System.out.println("decrypt=" + new String(decrypt));

			// String s = "12345678";
			// //加密
			// s = desEncrypt(deskey, s);
			// System.out.println("encrypt=" + s);
			// //解密
			// s = desDecrypt(deskey, s);
			// System.out.println("decrypt=" + s);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println("BASE64 Test:" + base64Decode(base64Encode("1234")));
	}

}
