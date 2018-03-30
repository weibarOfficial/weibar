package com.weibar.utils;


import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;

/**
 * 加密类
 * 
 * @author Fentid Peng 2007-2-7 下午07:16:28
 */
public class EncryptUtil {


	public static final String LOG_ENCRYPT_KEY = "fsd2aUS32d01FE62J98a";

	public static String getMD5(String str) {
		return encode(str, "MD5");
	}

	public static String getSHA1(String str) {
		return encode(str, "SHA-1");
	}

	public static String getLittleMD5(String str) {
		String estr = encode(str, "MD5");
		return estr.substring(0, 20);
	}

	public static String getLittleSHA1(String str) {
		String estr = encode(str, "SHA-1");
		return estr.substring(0, 20);
	}

	private static String encode(String str, String type) {
		try {
			MessageDigest alga = MessageDigest.getInstance(type);
			alga.update(str.getBytes("UTF-8"));
			byte[] digesta = alga.digest();
			return byte2hex(digesta);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String uuid(String[] strs) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			for (int i = 0; i < strs.length; i++) {
				if (!StringUtils.isEmpty(strs[i])) {
					md.update(strs[i].getBytes());
				}
			}
			byte[] bs = md.digest();
			return byte2hex(bs);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}

	public static byte[] hex2byte(byte[] b) {
		if ((b.length % 2) != 0) {
			throw new IllegalArgumentException("长度不是偶数");
		}
		byte[] b2 = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}
		return b2;
	}

	/**
	 * 异或加密
	 * 
	 * @param str
	 * @param key
	 * @return
	 */
	public static String xorEncrypt(String str, String key) {
		BigInteger strbi = new BigInteger(str.getBytes());
		BigInteger keybi = new BigInteger(key.getBytes());
		BigInteger encryptbi = strbi.xor(keybi);

		return new String(encryptbi.toByteArray());
	}

	/**
	 * 异或解密
	 * 
	 * @param encryptStr
	 * @param key
	 * @return
	 */
	public static String xorDecrypt(String encryptStr, String key) {
		BigInteger encryptbi = new BigInteger(encryptStr.getBytes());
		BigInteger keybi = new BigInteger(key.getBytes());
		BigInteger decryptbi = encryptbi.xor(keybi);
		return new String(decryptbi.toByteArray());
	}

	// 将 s 进行 BASE64 编码
	public static String base64Encode(String s) {
		if (s == null) {
			return null;
		}
		return (new BASE64Encoder()).encode(s.getBytes());
	}

	// 将 BASE64 编码的字符串 s 进行解码
	public static String base64Decode(String s) {
		if (s == null) {
			return null;
		}
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * DES加密
	 * 
	 * @param datasource
	 * @param password
	 * @return
	 */
	public static byte[] desEncrypt(byte[] datasource, String password) {
		try {
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(password.getBytes());
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance("DES");
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
			// 现在，获取数据并加密
			// 正式执行加密操作
			return cipher.doFinal(datasource);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * DES解密
	 * 
	 * @param src
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static byte[] desDecrypt(byte[] src, String password) throws Exception {
		// DES算法要求有一个可信任的随机数源
		SecureRandom random = new SecureRandom();
		// 创建一个DESKeySpec对象
		DESKeySpec desKey = new DESKeySpec(password.getBytes());
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey securekey = keyFactory.generateSecret(desKey);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance("DES");
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, random);
		// 真正开始解密操作
		return cipher.doFinal(src);
	}

	public static String encryptLog(String str) {
		if (str == null || "".equals(str.trim())) {
			return "";
		}
		String base64 = EncryptUtil.base64Encode(str);
		byte[] pwd = EncryptUtil.desEncrypt(base64.getBytes(), LOG_ENCRYPT_KEY);
		return EncryptUtil.byte2hex(pwd);
	}

	public static String decryptLog(String str) {
		if (str == null || "".equals(str.trim())) {
			return "";
		}
		byte[] pwd = EncryptUtil.hex2byte(str.getBytes());

		String base64 = "";
		try {
			base64 = new String(EncryptUtil.desDecrypt(pwd, LOG_ENCRYPT_KEY));
		} catch (Exception e) {
			return base64;
		}
		return EncryptUtil.base64Decode(base64);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(EncryptUtil.decryptLog("1FCAF78DC3788BC56FB173AE49AE6B20AB69C163A6F685049605B34C9F594ACEF157643DAA86066A8A5F78C86E85385E87C97763CD8A8955F8A8968B1144A74F32AD0A451A63DB06EA98EB08D3B56E844CB7E62F784BFBF6F4B9D4F9751FF72B9669DBC8A3B60C32F6FF7CAC36C9E9BD1AB14CEF01AE43BD2543612FD2238646"));
	}
}
