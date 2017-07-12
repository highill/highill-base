package com.highill.base.security;

import org.apache.commons.codec.digest.DigestUtils;

public class HashTool {
	
	/**
	 * MD5 of a string
	 * @param param
	 * @return md5 string
	 */
	public static String md5(String param) {
		String md5 = DigestUtils.md5Hex(param);
		return md5;
	}
	
	/**
	 * SHA256 of a string
	 * @param param
	 * @return sha256 string 
	 */
	public static String sha256(String param) {
		String sha256 = DigestUtils.sha256Hex(param);
		return sha256;
	}
	
	/**
	 * SHA512 of a string
	 * @param param
	 * @return sha512 string 
	 */
	public static String sha512(String param) {
		String sha512 = DigestUtils.sha512Hex(param);
		return sha512;
	}

}
