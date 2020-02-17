package com.by.hctm.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5���ܹ�����
 * @author ted 2009-12-07 
 *
 */
public class MD5 {
	public static char[] num_chars = new char[] { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	public static String toMD5String(String input)
			throws NoSuchAlgorithmException {
		if (input == null || input.trim().equals(""))
			return null;
		char[] output = new char[32];
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] by = md.digest(input.getBytes());
		for (int i = 0; i < by.length; i++) {
			output[2 * i] = num_chars[(by[i] & 0xf0) >> 4];
			output[2 * i + 1] = num_chars[by[i] & 0xf];
		}
		return new String(output);
	}
	
	public static void main(String args[] ) throws NoSuchAlgorithmException{
		System.out.println( MD5.toMD5String("lshV140214")) ;
	}
}
