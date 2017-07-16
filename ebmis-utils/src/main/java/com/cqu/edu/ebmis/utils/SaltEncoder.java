/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.utils;

import java.security.MessageDigest;
import java.util.logging.Logger;

import com.cqu.edu.ebmis.utils.enums.Algorithm;

/**
 * 
 * @author mxl
 * @version $ SaltEncoder.java v1.0, 2017年4月26日 下午5:18:35 mxl Exp $
 */
public class SaltEncoder {
	
	private static final Logger	logger			= Logger.getLogger("PasswordEncoder");
	
	/** 盐值 */
	private String				salt;
	
	/** 算法 */
	private String				algorithm;
	
	/** CUT_SYMBOL */
	private static final String	CUT_SYMBOL		= "#";
	
	private static final String	SSO_ENCODING	= "UTF-8";
	
	protected SaltEncoder() {
	
		/* 保护 */
	}
	
	public SaltEncoder(String salt, Algorithm algorithm) {
	
		this.salt = salt;
		this.algorithm = algorithm.getKey();
	}
	
	/**
	 * 
	 * <p>
	 * md5 盐值加密字符串
	 * </p>
	 * 
	 * @param salt
	 *            盐值
	 * @param rawText
	 *            需要加密的字符串
	 * @return
	 */
	public static String md5SaltEncode(String salt, String rawText) {
	
		return new SaltEncoder(salt , Algorithm.MD5).encode(rawText);
	}
	
	/**
	 * 
	 * <p>
	 * 判断md5 盐值加密内容是否正确
	 * </p>
	 * 
	 * @param salt
	 *            盐值
	 * @param encodeText
	 *            加密后的文本内容
	 * @param rawText
	 *            加密前的文本内容
	 * @return
	 */
	public static boolean md5SaltValid(String salt, String encodeText,
			String rawText) {
	
		return new SaltEncoder(salt , Algorithm.MD5).isValid(encodeText ,
				rawText);
	}
	
	/**
	 * 
	 * <p>
	 * 字符串盐值加密
	 * </p>
	 * 
	 * @param rawText
	 *            需要加密的字符串
	 * @return
	 */
	public String encode(String rawText) {
	
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			// 加密后的字符串
			return Byte2Hex.byte2Hex(md.digest(mergeRawTextAndSalt(rawText)
					.getBytes(SSO_ENCODING)));
		} catch (Exception e) {
			logger.severe(" SaltEncoder encode exception.");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * <p>
	 * 判断加密内容是否正确
	 * </p>
	 * 
	 * @param encodeText
	 *            加密后的文本内容
	 * @param rawText
	 *            加密前的文本内容
	 * @return
	 */
	public boolean isValid(String encodeText, String rawText) {
	
		return this.encode(rawText).equals(encodeText);
	}
	
	/**
	 * 
	 * <p>
	 * 合并混淆盐值至加密内容
	 * </p>
	 * 
	 * @param rawText
	 *            需要加密的字符串
	 * @return
	 */
	private String mergeRawTextAndSalt(String rawText) {
	
		if (rawText == null) {
			rawText = "";
		}
		
		if (this.salt == null || "".equals(this.salt)) {
			return rawText;
		} else {
			StringBuffer mt = new StringBuffer();
			mt.append(rawText);
			mt.append(CUT_SYMBOL);
			mt.append(this.salt);
			return mt.toString();
		}
	}
	
	public String getSalt() {
	
		return salt;
	}
	
	public void setSalt(String salt) {
	
		this.salt = salt;
	}
	
	public String getAlgorithm() {
	
		return algorithm;
	}
	
	public void setAlgorithm(String algorithm) {
	
		this.algorithm = algorithm;
	}
}
